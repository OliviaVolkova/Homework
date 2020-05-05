import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TaskSerialization {

    public Collection<Student> read() {
        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("C:\\Users\\black\\Desktop\\test.txt")) {
            ByteBuffer bb;
            bb = ByteBuffer.allocate(4);
            for (int i = 0; i < 4; i++) {
                bb.put((byte) fis.read());
            }
            int length = bb.getInt();
            char[] array = new char[0];
            String name;
            boolean gender = false;
            int group;
            int birthYear;
            while (length != -1) {
                gender = false;
                array = new char[length];
                bb = ByteBuffer.allocate(length * 2 + 11);
                for (int i = 0; i < length * 2 + 11; i++) {
                    bb.put((byte) fis.read());
                }
                bb.rewind();
                for (int i = 0; i < length; i++) {
                    array[i] = bb.getChar();
                }
                name = new String(array);
                if (bb.get() == 1) {
                    gender = true;
                }
                birthYear = bb.getInt();
                group = bb.getInt();
                length = bb.getInt();
                students.add(new Student(name, gender, birthYear, group));
            }
            return students;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void write(Collection<Student> collection) {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\black\\Desktop\\test.txt")) {
            ByteBuffer bb = null;
            for (Student s : collection) {
                bb = ByteBuffer.allocate(11 + s.getName().length() * 2);
                bb.putInt(s.getName().length());
                byte gender = 0;
                for (int i = 0; i < s.getName().length(); i++) {
                    bb.putChar(s.getName().charAt(i));
                }
                if (s.isGender()) gender = 1;
                bb.put(gender);
                bb.putInt(s.getBirthYear());
                bb.putInt(s.getGroup());
                fos.write(bb.array());
                fos.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}