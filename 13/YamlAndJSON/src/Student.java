import java.io.Serializable;
import java.util.Objects;


public class Student implements Serializable {

    public String name;
    public int birthYear;
    public int group;
    public int averageScore;

    public Student( String name, int averageScore, int birthYear, int group){
        this.name = name;
        this.birthYear = birthYear;
        this.group = group;
        this.averageScore=averageScore;
    }

    public Student(){}

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }


    public int getGroup() {
        return group;
    }

    public int getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", group=" + group +
                ", averageScore=" + averageScore +
                '}';
    }
}
