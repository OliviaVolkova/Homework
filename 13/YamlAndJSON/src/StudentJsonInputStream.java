import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StudentJsonInputStream extends InputStream {
    private InputStream is;

    public StudentJsonInputStream(InputStream is){
        this.is=is;
    }

    public Student readStudent() throws IOException {
        JSONParser jParser = new JSONParser();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            JSONObject json = (JSONObject)jParser.parse(br);
                    String name = (String)json.get("Name:");
                    int score = (int)(long)json.get("Score:");
                    int birthYear = (int)(long)json.get("BirthYear:");
                    int group = (int)(long)json.get("Group:");
            return new Student(name, score, birthYear, group);
        }
        catch (Exception e){
            throw new IOException(e.getMessage());
        }

    }

    @Override
    public int read() throws IOException {
        return is.read();
    }
}
