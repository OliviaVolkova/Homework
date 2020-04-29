import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StudentJsonOutputStream extends OutputStream {
    private OutputStream os;

    public StudentJsonOutputStream(OutputStream os) {
        this.os = os;
    }

    public void writeStudent(Student student) throws IOException {
        JSONObject json = new JSONObject();
        json.put("Name:", student.getName());
        json.put("Score:", student.getAverageScore());
        json.put("BirthYear:", student.getBirthYear());
        json.put("Group:", student.getGroup());
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            bw.write(json.toJSONString());
            bw.flush();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public void write(int b) throws IOException {

    }
}
