import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Download extends Thread {
    private URL url;
    Path path;
    URLConnection connection;
    public long currentSize;
    public long maxSize;


    public Download(URL currentUrl) {
        this.url = currentUrl;
        path = Paths.get("src\\Downloaded");
    }

    public void run(){
        download();
    }

    private void download(){
        try {
            connection = url.openConnection();
            maxSize = connection.getContentLength();
            String mime = connection.getContentType().split(";")[0];
            String extension = MimeTypes.getDefaultMimeTypes().forName(mime).getExtension();
            path = Paths.get(path + File.separator + connection.getContent().hashCode() + extension);
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path.toString()));
                BufferedInputStream bin = new BufferedInputStream(connection.getInputStream());) {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                currentSize = 0;
                byte[] bytes = new byte[4096];
                int mark;
                while ((mark = bin.read(bytes)) != -1) {
                    Thread.sleep(100);
                    bos.write(bytes,0,mark);
                    currentSize = Files.size(path);
                }
                bos.flush();
                System.out.println("File is downloaded");
            }
        }
        catch (IOException | MimeTypeException | InterruptedException e) {
            System.out.println("Downloading process has been interrupted");
            try {
                Files.delete(path);
            } catch (IOException e2) {
                System.out.println("File isn't delete");
            }
        }
    }

    public int progress(){
        if(maxSize!=0) {
            return (int) ((double) (100 * currentSize / maxSize));
        }
        else {
            return 0;
        }
    }


}
