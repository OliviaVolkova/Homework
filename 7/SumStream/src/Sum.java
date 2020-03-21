import java.util.ArrayList;
import java.util.stream.Stream;

public class Sum {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("wefwcwc");
        list.add("erbtte");
        list.add("tbtb4e");
        list.add("rg3gr");
        list.add("rfwrf");
        Stream<String> stream=list.stream();
        System.out.println(stream.filter(n -> n.length()>5).count());
    }
}
