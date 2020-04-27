public class Student {
    private String name;
    private boolean gender;
    private int birthYear;
    private int group;

    public Student(String name,boolean gender,int birthYear, int group){
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return  "name:" + name + ", gender:" + gender + ", birthYear:" + birthYear + ", group:" + group;
    }
}