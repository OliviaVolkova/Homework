import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class DownloadSite {
    public static void main(String[] args){
        DownloadSite downloader = new DownloadSite();
        downloader.downloadSite();
    }
    private int pageNumber;
    private Elements links;
    private Elements media;
    private Elements imports;
    private String url;
    private Set<String> pages;
    public DownloadSite(){
        init();
    }

    private void init(){
        pageNumber = 1;
        url = "https://itpark.tech/";
        try {
            Document doc = Jsoup.connect(url).get();
            doc = Jsoup.connect(url).get();
            links = doc.select("a[href]");
            media = doc.select("[src]");
            imports = doc.select("link[href]");
            pages = new TreeSet<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadFile(String urlS) throws Exception {
        URL url = new URL(urlS);
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get("src\\Downloaded\\Page"+pageNumber+".html" ));
            pageNumber++;
        }
    }


    public void downloadSite(){
        for (Element link : links) {
            Pattern pattern = Pattern.compile("https://itpark.tech/[a-z.\\-A-Z0-9]+");
            String currentLink = link.attr("abs:href");
            System.out.println(currentLink);
            if (pattern.matcher(currentLink).find()) {
                try {
                    Thread.sleep(10);
                    if(!pages.contains(currentLink)) {
                        downloadFile(currentLink);
                        pages.add(currentLink);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}