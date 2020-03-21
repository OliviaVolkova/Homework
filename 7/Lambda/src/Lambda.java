import java.util.*;

public class Lambda {
    public static void main(String[]args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i=0;i<10;i++){
            int n= (int)Math.random();
            list1.add(n);
        }

        for(int i=0;i<10;i++){
            int n= (int)Math.random();
            list2.add(n);
        }

        list1.stream().filter(a -> a > list2.stream().max((x,y) -> x-y).get()).forEach(t -> System.out.println(t+" "));
    }
}
