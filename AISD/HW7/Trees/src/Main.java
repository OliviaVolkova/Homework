import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BinarTree tree = new BinarTree();
        tree.add(11);
        tree.add(14);
        tree.add(13);
        tree.add(7);
        tree.add(9);
        tree.add(0);
        tree.add(15);
        tree.bfs();
    }
}
