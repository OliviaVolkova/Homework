import java.util.*;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {

    Map<String,Integer> map = new HashMap<>();
    map.put("f",7);
    map.put("u",1);
    map.put("c",2);
    map.put("p",2);
    map.put("s",4);
    map.put("y",5);
        Stream<String> stream= map.keySet().stream();
        StringBuffer str=new StringBuffer();
        stream.forEach(x -> str.append(x));
        System.out.println(str.toString());
    }
}
