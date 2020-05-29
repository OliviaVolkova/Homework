import java.util.*;

public class BinarTree {
    Knot root;
   // ArrayList<Integer> dfsArray = new ArrayList<>();
    //ArrayList<Knot> bfsArray = new ArrayList<>();
    BinarTree(){

    }
    public void add(int value){
        if(root == null){
            root = new Knot(null,value);
        }
        else{
            add(root, value);
        }
    }

    public void add(Knot parent,int value){
        if(value > parent.value){
            if(parent.right == null){
                Knot knot = new Knot(parent, value);
                parent.right = knot;
            }
            else{
                add(parent.right,value);
            }
        }
        else{
            if(parent.left == null){
                Knot knot = new Knot(parent, value);
                parent.left = knot;
            }
            else{
                add(parent.left,value);
            }
        }
    }


    public void bfs() {
        ArrayList a = new ArrayList();
        if(root!=null){
            a.add(root);
        }
        bfs(a);
    }


    public void bfs(ArrayList<Knot> bfsArray){
        if(bfsArray.size() ==0)return;
        ArrayList<Knot> level = new ArrayList<>();
        for(Knot knot: bfsArray){
            System.out.println(knot.value);
            if(knot.left != null){
                level.add(knot.left);
            }
            if(knot.right != null){
                level.add(knot.right);
            }
        }
        bfs(level);
    }

    public void dfs(){
        dfs(root);
    }
    private void dfs(Knot knot){
        if(knot == null){
            return;
        }
        System.out.println(knot.value);
        dfs(knot.left);
        dfs(knot.right);
    }

    public class Knot {
        Knot left;
        Knot right;
        int value;
        Knot parent;

        public Knot(Knot parent, int value) {
            this.parent = parent;
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Knot knot = (Knot) o;
            return
                    value == knot.value &&
                    Objects.equals(left, knot.left) &&
                    Objects.equals(right, knot.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right, value);
        }

        @Override
        public String toString() {
            return "Knot{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }
}
