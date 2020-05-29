import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeWORecursion {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(sc.next());
        }
        mergeSortWORec(arr);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void mergeSortWORec(int[] arr){
        for(int i = 1; i<=arr.length;i*=2){
            for(int j = 0;j<arr.length;j+= 2*i){
                if(j+2*i-1<arr.length){
                    merge(arr,j,j+i-1,j+i,j+2*i-1);
                }
                else if(j+2*i-1>=arr.length && j+i<arr.length){
                    merge(arr,j,j+i-1,j+i,arr.length-1);
                }
            }
        }

    }

    public static void merge(int[] arr,int begin1,int end1,int begin2,int end2){
        int[] arr1 = Arrays.copyOfRange(arr,begin1,end1+1);
        int c1 = 0;
        int c2 = begin2;
        for(int i = begin1; i <= end2; i++){
            if(c2 > end2){
                arr[i] = arr1[c1];
                c1++;
            }
            else if(c1<arr1.length && arr1[c1] <= arr[c2]){
                arr[i] = arr1[c1];
                c1++;
            }
            else{
                arr[i] = arr[c2];
                c2++;
            }

        }
    }
}