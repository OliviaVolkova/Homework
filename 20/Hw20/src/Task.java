import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Task extends Thread {
    private static Scanner in;
    private static URL currentURL;
    Download download;

    public static void main(String[] args){
        Task task = new Task();
        task.run();
    }

    public void run(){
        in = new Scanner(System.in);
        writeUrl();
    }

    private void writeUrl(){
        try {
            System.out.println("Please enter url:");
            currentURL = new URL(in.nextLine().trim());
        }
        catch (MalformedURLException e){
            System.out.println("Please enter correct url");
            writeUrl();
        }

        System.out.println("Commands:"+"\n"+"1 -> Start downloading"+"\n"+"2 -> Check Progress(%)"+"\n"+"3 -> Stop downloading");
        commands();
    }

    private void commands(){
        while(true) {
            switch (in.nextLine().trim()) {
                case "1":
                    startDownload();
                    break;
                case "2":
                    progress();
                    break;
                case "3":
                    stopDownload();
                    break;
                default:
                    System.out.println("Please enter one of the correct commands(1-3):");
                    commands();
            }
        }
    }

    private void startDownload(){
        if(download!=null && download.isAlive()){
            System.out.println("File is already downloading process");
        }
        else {
            download = new Download(currentURL);
            download.setPriority(1);
            download.start();
            System.out.println("Downloading process has been started");
        }
        commands();
    }

    private void progress(){
        if(download!=null) {
            System.out.println("Progress: "+download.progress()+"%");
        }
        else {
            System.out.println("Downloading process hasn't started please enter \"1\" for downloading");

        }
        commands();
    }

    private void stopDownload(){
        if(!download.isAlive()){
            System.out.println("Скачивание завершено");
        }
        else {
            download.interrupt();
            System.out.println("Скачивание прекращено");
        }
        commands();
    }
}
