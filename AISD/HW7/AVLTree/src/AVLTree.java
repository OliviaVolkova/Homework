import java.util.*;import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

class AVLTree{


    public class BinarTree {
        public Knot root;
        BinarTree(){

        }
        public void add(int value){
            if(root == null){
                root = new Knot(value);
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
        int height;
        Knot left;
        Knot right;
        int value;

        public Knot(int value) {
            this.height =1;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Knot knot = (Knot) o;
            return height == knot.height &&
                    value == knot.value &&
                    Objects.equals(left, knot.left) &&
                    Objects.equals(right, knot.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, left, right, value);
        }

        @Override
        public String toString() {
            return "Knot{" +
                    "height=" + height +
                    ", left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }

    public void insert(int value){
        root = insert(root,value);
    }

    public void delete(int value){
        delete(null,root,value,true);
    }

    private int calculateHeight(Knot knot){
        if(knot == null){
            return 0;
        }
        knot.height = Math.max(calculateHeight(knot.left),calculateHeight(knot.right))+1;
        return knot.height;
    }

    private Knot insert(Knot knot, int value) {
        if (knot == null)
        {
            return (new Knot(value));
        }

        if (value <= knot.value) {
            knot.left = insert(knot.left, value);
        }
        else if (value > knot.value) {
            knot.right = insert(knot.right, value);
        }
        else {
            return knot;
        }
        knot.height = 1 + Math.max(height(knot.left), height(knot.right));
        return insertingBalance(knot,value);
    }


    private Knot rightRotation(Knot knot) {
        Knot left = knot.left;
        Knot rightOfLeft = left.right;
        left.right = knot;
        knot.left = rightOfLeft;
        knot.height = Math.max(height(knot.left), height(knot.right)) + 1;
        left.height = Math.max(height(left.left), height(left.right)) + 1;
        return left;
    }

    private Knot leftRotation(Knot knot) {
        Knot right = knot.right;
        Knot leftOfRight = right.left;
        right.left = knot;
        knot.right = leftOfRight;
        knot.height = Math.max(height(knot.left), height(knot.right)) + 1;
        right.height = Math.max(height(right.left), height(right.right)) + 1;
        return right;
    }

    private int getBalance(Knot knot) {
        if (knot == null) {
            return 0;
        }
        return height(knot.left) - height(knot.right);
    }


    private Knot insertingBalance(Knot knot, int value){
        int balance = getBalance(knot);
        if (balance > 1 && value <= knot.left.value)
        {
            return rightRotation(knot);
        }
        if (balance < -1 && value > knot.right.value)
        {
            return leftRotation(knot);
        }
        if (balance > 1 && value > knot.left.value) {
            knot.left = leftRotation(knot.left);
            return rightRotation(knot);
        }
        if (balance < -1 && value <= knot.right.value) {
            knot.right = rightRotation(knot.right);
            return leftRotation(knot);
        }
        return knot;
    }


    private Knot deletingBalance(Knot root){
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) > 0)
        {
            return rightRotation(root);
        }
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        if (balance < -1 && getBalance(root.right) < 0)
        {
            return leftRotation(root);
        }
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }





    public Knot minNode(Knot knot)
    {
        Knot current = knot;
        while (current.left != null)
        {
            current = current.left;
        }
        return current;
    }

    private Knot delete(Knot parent,Knot root, int value ,boolean isLeft)
    {
        if (root == null)
        {
            return null;
        }
        if (value < root.value)
        {
            root.left = delete(root,root.left, value,true);
        }
        else if (value > root.value)
        {
            root.right = delete(root,root.right, value,false);
        }
        else
        {
            if(root.left != null && root.right !=null){
                Knot next = minNode(root.right);
                root.value = next.value;
                root.right = delete(root,root.right, next.value,false);
            }
            else {
                if (root.left != null) {
                    if (parent == null) {
                        this.root = root.left;
                        root = root.left;
                    }
                    if (isLeft) {
                        parent.left = root.left;
                        root = root.left;
                    } else {
                        parent.right = root.left;
                        root = root.left;
                    }
                } else if (root.right != null) {
                    if (parent == null) {
                        this.root = root.right;
                        root = root.right;
                    }
                    if (isLeft) {
                        parent.left = root.right;
                        root = root.right;
                    } else {
                        parent.right = root.right;
                        root = root.right;
                    }
                } else {
                    if (parent == null) {
                        this.root = null;
                        root = null;
                    } else if (isLeft) {
                        parent.left = null;
                        root = null;
                    } else {
                        parent.right = null;
                        root = null;
                    }
                }
            }
        }
        if (root == null)
        {
            return null;
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        return deletingBalance(root);
    }


    private int height(Knot N) {
        if (N == null)
            return 0;
        return N.height;
    }

}
}