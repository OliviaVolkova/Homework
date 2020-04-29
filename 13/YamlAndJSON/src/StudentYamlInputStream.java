import org.ho.yaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

public class StudentYamlInputStream extends InputStream {
    private InputStream is;

    public StudentYamlInputStream(InputStream is){
        this.is=is;
    }

    public Student readStudent() throws IOException{
        Student student= (Student) Yaml.load(is);
        return student;
    }

    @Override
    public int read() throws IOException {
        return is.read();
    }
}
