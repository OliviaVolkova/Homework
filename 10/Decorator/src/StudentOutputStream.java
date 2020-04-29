import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StudentOutputStream extends OutputStream {

    private DataOutputStream sout;

    public StudentOutputStream(OutputStream sout){
        this.sout= new DataOutputStream(sout);
    }

    public void writeStudent(Student student) throws IOException {
        try{
            sout.writeUTF(student.getName());
            sout.writeInt(student.getBirthYear());
            sout.writeShort(student.getGroup());
            sout.writeInt(student.getAverageScore());
        }
        catch(IOException ex){
            throw ex;
        }
    }
    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        super.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    public void write(int b) throws IOException {
        sout.write(b);
    }

    public void writeBoolean(boolean v) throws IOException {
        sout.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        sout.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        sout.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        sout.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        sout.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        sout.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        sout.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        sout.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        sout.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        sout.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        sout.writeUTF(str);
    }

    public int size() {
        return sout.size();
    }

}
