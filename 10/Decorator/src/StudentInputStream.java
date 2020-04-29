import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentInputStream extends InputStream {

    private DataInputStream sin;

    public StudentInputStream(InputStream in) {
        this.sin = new DataInputStream(in);
    }

    public Student readStudent() throws IOException {
        try {
            String name = sin.readUTF();
            short group = sin.readShort();
            int birthYear = sin.readInt();
            int averageScore =sin.readInt();

            return new Student(name, birthYear, group, averageScore);
        } catch (IOException ex) {
            throw ex;
        }
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return super.skip(n);
    }

    @Override
    public int available() throws IOException {
        return super.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        super.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        super.reset();
    }

    @Override
    public boolean markSupported() {
        return super.markSupported();
    }

    @Override
    public int read() throws IOException {
        return sin.read();
    }

    public void readFully(byte[] b) throws IOException {
        sin.readFully(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        sin.readFully(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        return sin.skipBytes(n);
    }

    public boolean readBoolean() throws IOException {
        return sin.readBoolean();
    }

    public byte readByte() throws IOException {
        return sin.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return sin.readUnsignedByte();
    }

    public short readShort() throws IOException {
        return sin.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return sin.readUnsignedShort();
    }

    public char readChar() throws IOException {
        return sin.readChar();
    }

    public int readInt() throws IOException {
        return sin.readInt();
    }

    public long readLong() throws IOException {
        return sin.readLong();
    }

    public float readFloat() throws IOException {
        return sin.readFloat();
    }

    public double readDouble() throws IOException {
        return sin.readDouble();
    }

    @Deprecated
    public String readLine() throws IOException {
        return sin.readLine();
    }

    public String readUTF() throws IOException {
        return sin.readUTF();
    }

    public static String readUTF(DataInput in) throws IOException {
        return DataInputStream.readUTF(in);
    }
}
