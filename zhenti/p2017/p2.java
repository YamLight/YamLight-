package zhenti.p2017;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class p2 {
    static int[] t = new int[]{1,2,3,4,5,6,7,8,9};
    static int[] a = new int[9];
    static int cnt = 0;
    static boolean[] st = new boolean[9];
    static int res = 0;
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
        dfs(0);
        System.out.println(res / 6);
    }
    static void dfs(int u){
        if (u == 9){
            int sum1 = a[0] + a[1] + a[3] + a[5];
            int sum2 = a[0] + a[2] + a[4] + a[8];
            int sum3 = a[5] + a[6] + a[7] + a[8];
            if (sum1 == sum2 && sum1 == sum3){
                res++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!st[i]){
                a[cnt++] = t[i];
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
                a[--cnt] = 0;
            }
        }
    }
}
