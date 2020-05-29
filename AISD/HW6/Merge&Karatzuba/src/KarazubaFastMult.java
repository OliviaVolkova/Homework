import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class KarazubaFastMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean[] x  = translateToBoolean(a);
        boolean[] y  = translateToBoolean(b);
        System.out.println(translateToInt(karazuba(x,y)));
    }

    public static boolean[] karazuba(boolean[] x, boolean[] y) {
        int n = maxlength(x.length, y.length);
        boolean[] p1;
        boolean[] p2;
        boolean[] p3;
        if (x.length == 1) {
            return mult(x, y);
        }
        if (y.length == 1) {
            return mult(y, x);
        } else {
            boolean[] x1 = new boolean[n / 2 + n % 2];
            boolean[] x2 = new boolean[n / 2];
            boolean[] y1 = new boolean[n / 2 + n % 2];
            boolean[] y2 = new boolean[n / 2];
            fill(x, x1, x2, n);
            fill(y, y1, y2, n);
            p1 = karazuba(x1, y1);
            p2 = karazuba(x2, y2);
            p3 = karazuba(sum(x1, x2), sum(y1, y2));
        }
        return sum(sum(shift(2 * (n / 2), p1), shift(n / 2, sub(p3, sum(p1, p2)))), p2);
    }
    public static int translateToInt(boolean[] b){
        int answer = 0;
        for(int i = 0; i < b.length; i++){
            if(b[i]){
                answer+= Math.pow(2,i);
            }
        }
        return answer;
    }

    public static boolean [] translateToBoolean(int a){
        int log =(int)Math.floor(Math.log10(a)/Math.log10(2))+1;
        if(log <= 0){
            log = 1;
        }
        boolean [] b = new boolean[log];
        int i = 0;
        while(a > 0) {
            if (a % 2 != 0) {
                b[i] = true;
            }
            a = a/2;
            i++;
        }
        return b;
    }

    public static int maxlength(int a, int b){
        if(a > b){
            return a;
        }
        else return b;
    }

    public static void fill(boolean[] a,boolean[] a1,boolean[] a2, int n ){
        int cursor = 0;
        for (int i = 0; i < a2.length && cursor<a.length; i++) {
            a2[i] = a[cursor];
            cursor++;
        }
        for (int i = 0; i < a1.length && cursor<a.length; i++) {
            a1[i] = a[cursor];
            cursor++;
        }
    }

    public static boolean[] sub(boolean[] a, boolean[] b){
        boolean [] res = new boolean[a.length];
        if(b.length < a.length){
            b = Arrays.copyOf(b, a.length);
        }
        int last = 0;
        for(int i = a.length-1; i>=0; i--){
            if(a[i]&&!b[i]){
                res[i] = true;
                last = i;
            }
            if(!a[i]&&!b[i]){
                res[i] = false;
            }
            if(a[i]&&b[i]){
                res[i] = false;
            }
            if(!a[i]&&b[i]){
                res[last] = false;
                for(int j = i; j<last ;j++){
                    res[j] = true;
                }
                last = i;
            }
        }
        return res;
    }



    public static boolean[] sum(boolean[] a, boolean[] b){
        boolean[] c = new boolean[Math.max(a.length,b.length)];
        boolean stock = false;
        int count;
        for(int i = 0; i< c.length; i++){
            count = 0;
            if(i < a.length){
                if(a[i]){
                    count++;
                }
            }
            if(i < b.length){
                if(b[i]){
                    count++;
                }
            }
            if(stock){
                count++;
            }
            if(count % 2 == 1){
                c[i]=true;
            }
            if(count >= 2){
                stock=true;
            }
            else stock = false;
        }
        if(stock){
            boolean[] p= Arrays.copyOf(c,c.length+1);
            p[p.length-1] = true;
            c = p;
        }
        return c;
    }

    public static boolean[] mult(boolean[] x, boolean[] y){

        if(x[0]){
            return y;
        }
        else{
            boolean[] y2 = new boolean[y.length];
            return y2;
        }
    }

    public static boolean[] shift(int n, boolean[] a){
        boolean[] k = new boolean[a.length + n];
        for(int i = n; i < k.length;i++){
            k[i] = a[i-n];
        }
        return k;
    }

    public static boolean[] reverse(boolean[] a){
        boolean[] b = new boolean[a.length];
        int cursor = 0;
        for(int i = a.length-1; i >= 0; i--){
            b[cursor] = a[i];
        }
        return b;
    }
}