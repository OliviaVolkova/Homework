import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        
        Student student = new Student("Kate", 2000,198, 92);
        Student student1 = null;
        try(StudentJsonOutputStream out = new StudentJsonOutputStream(new FileOutputStream("src/Json"))){
            out.writeStudent(student);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(StudentJsonInputStream in = new StudentJsonInputStream(new FileInputStream("src/Json"))){
            student1 = in.readStudent();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(student1.toString());


        student = new Student("Eva", 2022,198, 92);
        student1 = null;
        try(StudentYamlOutputStream out = new StudentYamlOutputStream(new FileOutputStream("src/Yaml"))){
            out.writeStudent(student);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        try(StudentYamlInputStream in = new StudentYamlInputStream(new FileInputStream("src/Yaml"))){
            student1 = in.readStudent();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(student1.toString());

    }
}