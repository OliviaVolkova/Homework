import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeRecursion{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
    }
    public static int[] mergeSort(int[] a) {

        if(a.length>=2) {
            int start = 0;
            int end = a.length-1;
            int [] copy1;
            int [] copy2;
            copy1 = mergeSort(Arrays.copyOfRange(a, start, 1+(start + end) / 2));
            copy2 = mergeSort(Arrays.copyOfRange(a, (start + end) / 2 + 1, 1+end));
            return merge(copy1,copy2);
        }
        return a;
    }

    public static int [] merge(int[] a, int[] b){
        int [] c = new int[a.length+b.length];
        int cursor1 = 0;
        int cursor2 = 0;
        for(int i = 0; i < c.length; i++){

            if(cursor1==a.length){
                c[i] = b[cursor2];
                cursor2++;
            }
            else if(cursor2==b.length){
                c[i] = a[cursor1];
                cursor1++;
            }
            else if(a[cursor1] < b[cursor2]){
                c[i] = a[cursor1];
                cursor1++;
            }
            else{
                c[i] = b[cursor2];
                cursor2++;
            }
        }
        return c;
    }
}
