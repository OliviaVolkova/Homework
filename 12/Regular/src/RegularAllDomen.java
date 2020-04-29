import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularAllDomen {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Pattern pattern = Pattern.compile("[A-Za-z0-9]+@((([a-zA-Z0-9])+(-[a-zA-Z0-9]+)*)(\\.))+(ru|edu|info|com|org|int)\\.?");
        Matcher matcher = pattern.matcher(str);

        matcher.find();
        System.out.println("upper level: "+matcher.group(2)+", lower level: "+matcher.group(matcher.groupCount()));

    }
}
