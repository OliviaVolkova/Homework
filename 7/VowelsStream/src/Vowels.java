import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Vowels {
    public static void main(String[] args) {
        Set<String> set= new HashSet<>();
        set.add("assvfbrn");
        set.add("fdgrgwewrf2");
        set.add("wefwefacdw");
        set.add("dfdfsdds");
        String[] vowels={"a","i","y","e","o"};
        Set<String> set2=new HashSet<>();
        for(int i=0;i<vowels.length;i++){
            set.add(vowels[i]);
        }
        set.stream().filter(s -> Arrays.stream(s.toLowerCase().split("")).filter(n -> set2.contains(n)).count() > 3).forEach(str -> System.out.print(str + " "));
    }
}
