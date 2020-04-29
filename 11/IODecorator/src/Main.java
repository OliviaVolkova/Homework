import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Map<String,String>> map = null;
        try(InputDecorator id = new InputDecorator(new FileInputStream("src//ini"))){
           map = id.readIni();

        }
        catch(IOException e){
            throw e;
        }

        try(OutputDecorator od = new OutputDecorator(new FileOutputStream("src//ini"))){
            od.writeIni(map);
        }
        catch(IOException e){
            throw e;
        }
    }
}
