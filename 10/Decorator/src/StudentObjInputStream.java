import java.io.*;

public class StudentObjInputStream extends InputStream {

    private ObjectInputStream in;

    public StudentObjInputStream(InputStream in) throws IOException {
        this.in = new ObjectInputStream(in);
    }

    public Student readStudent() throws IOException {
        try {
            return (Student) in.readObject();
        }
        catch (IOException  e) {
            throw e;
        }
        catch (ClassNotFoundException e){
            return null;
        }
    }

    @Override
    public int read() throws IOException {
        return in.read();
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

    public Object readObject() throws IOException, ClassNotFoundException {
        return in.readObject();
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        return in.readUnshared();
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    public ObjectInputStream.GetField readFields() throws IOException, ClassNotFoundException {
        return in.readFields();
    }

    public void registerValidation(ObjectInputValidation obj, int prio) throws NotActiveException, InvalidObjectException {
        in.registerValidation(obj, prio);
    }

    public boolean readBoolean() throws IOException {
        return in.readBoolean();
    }

    public byte readByte() throws IOException {
        return in.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return in.readUnsignedByte();
    }

    public char readChar() throws IOException {
        return in.readChar();
    }

    public short readShort() throws IOException {
        return in.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return in.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return in.readInt();
    }

    public long readLong() throws IOException {
        return in.readLong();
    }

    public float readFloat() throws IOException {
        return in.readFloat();
    }

    public double readDouble() throws IOException {
        return in.readDouble();
    }

    public void readFully(byte[] buf) throws IOException {
        in.readFully(buf);
    }

    public void readFully(byte[] buf, int off, int len) throws IOException {
        in.readFully(buf, off, len);
    }

    public int skipBytes(int len) throws IOException {
        return in.skipBytes(len);
    }

    @Deprecated
    public String readLine() throws IOException {
        return in.readLine();
    }

    public String readUTF() throws IOException {
        return in.readUTF();
    }

}
