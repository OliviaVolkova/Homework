import java.io.*;

public class Stream{
    public static void main(String[] args){
        try(FileOutputStream w= new FileOutputStream("C:\\Users\\black\\Desktop\\stream.txt")){
            int num=4563876;
            char c='в';
            w.write(num >>> 24 & 0xFF );
            w.write(num >>> 16 & 0xFF );
            w.write(num >>> 8 & 0xFF );
            w.write(num >>> 0 & 0xFF );
            w.write( c >>> 8 & 0xFF );
            w.write( c >>> 0 & 0xFF );
            w.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        try(InputStream r= new FileInputStream("C:\\Users\\black\\Desktop\\stream.txt")){
            int num1=r.read();
            int num2=r.read();
            int num3=r.read();
            int num4=r.read();
            int num5=r.read();
            int num6=r.read();
            System.out.println(((num1 << 24) + (num2 << 16) + (num3 << 8) + (num4<<0)));
            System.out.println((char)((num5 << 8) + num6 << 0));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
