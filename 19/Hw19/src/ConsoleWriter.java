import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsoleWriter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path, please:");
        String p = sc.nextLine();
        Path path = Paths.get(p.trim());
        if(!path.isAbsolute()){
            path = Paths.get(System.getProperty("user.dir")+File.separator+path);
        }
        System.out.println("Write type of disared encoding:");
        String encode = sc.nextLine();
        cat(path,encode);

    }
        public static void cat(Path path, String encode){
            String string;
            try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), encode))){
                string = br.readLine();
                while (string!= null){
                    System.out.println(string);
                    string = br.readLine();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }





}
