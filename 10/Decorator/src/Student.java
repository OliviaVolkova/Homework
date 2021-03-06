import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {

    private String name;
    private int birthYear;
    private int group;
    private int averageScore;

    Student( String name, int birthYear, int group, int averageScore){
        this.name = name;
        this.birthYear = birthYear;
        this.group = group;
        this.averageScore=averageScore;
    }

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
