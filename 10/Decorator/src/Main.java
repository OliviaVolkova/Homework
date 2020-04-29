import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try(StudentObjOutputStream out = new StudentObjOutputStream(new FileOutputStream("src/Text"));
            StudentOutputStream sout= new StudentOutputStream(new FileOutputStream("src/TextData"))){

            Student student = new Student("Maria",1999,  902, 1999);
            out.writeStudent(student);

            Student student1 = new Student("Bala", 1923,309,209300);
            sout.writeStudent(student1);


        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(StudentObjInputStream in = new StudentObjInputStream(new FileInputStream("src/Text"));
        StudentInputStream sin = new StudentInputStream(new FileInputStream("src/TextData"))){
            System.out.println(in.readStudent().toString());
            System.out.println(sin.readStudent().toString());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
