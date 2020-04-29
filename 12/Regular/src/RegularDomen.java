import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularDomen {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Pattern pattern = Pattern.compile("((([a-zA-Z0-9])+(-[a-zA-Z0-9]+)*)(\\.)?){1,250}(ru|edu|info|com|org|int)\\.?");
        Matcher matcher = pattern.matcher(str);
        System.out.println("All domens:");
        while (matcher.find()){
            System.out.print(matcher.group()+"\n");
        }

    }
}
