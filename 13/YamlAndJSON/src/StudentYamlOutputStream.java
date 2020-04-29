import org.ho.yaml.Yaml;
import org.ho.yaml.YamlEncoder;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StudentYamlOutputStream extends OutputStream {
    private OutputStream os;

    public StudentYamlOutputStream(OutputStream os){
        this.os=os;
    }

    public void writeStudent(Student student){
        YamlEncoder encoder = new YamlEncoder(os);
        encoder.writeObject(student);
        encoder.flush();
    }


    @Override
    public void write(int b) throws IOException {
        os.write(b);
    }
}
