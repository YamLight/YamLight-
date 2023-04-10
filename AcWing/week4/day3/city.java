package AcWing.week4.day3;

import java.util.HashSet;
import java.util.Scanner;

public class city {
    static int N = 2010;
    static int M = 4000010;
    static PII[] p = new PII[N];
    static long[] dist = new long[N];
    static int[] f = new int[N];
    static long[] wc = new long[N];
    static long[] wk = new long[N];
    static boolean[] st = new boolean[N];
    static int n,m;
    static HashSet<Integer> res1 = new HashSet<>();
    static HashSet<PII> res2 = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            p[i] = new PII(a,b);
        }
        for (int i = 1; i <= n ; i++) {
            wc[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            wk[i] = scanner.nextInt();
        }
        System.out.println(prim());
        if (res1.size() > 0){
            System.out.println(res1.size());
            for (int i : res1){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else System.out.println(0);
        if (res2.size() > 0){
            System.out.println(res2.size());
            for (PII t : res2){
                System.out.println(t.a + " " + t.b);
            }
        }
        else System.out.println(0);
    }
    static long prim(){
        long res = 0;
        dist[0] = 0;
        st[0] = true;
        for (int i = 1; i <= n ; i++) {
            dist[i] = wc[i];
        }
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n ; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) t = j;
            }
            res += dist[t];
            st[t] = true;
            if (f[t] == 0) res1.add(t);
            else res2.add(new PII(f[t],t));
            for (int j = 1; j <= n ; j++) {
                if (dist[j] > get_dist(t,j)){
                    dist[j] = get_dist(t,j);
                    f[j] = t;
                }
            }
        }
        return res;
    }
    static long get_dist(int a,int b){
        int da = Math.abs(p[a].a - p[b].a);
        int db = Math.abs(p[a].b - p[b].b);
        return (da + db) * (wk[a] + wk[b]);
    }
}
class PII{
    int a;
    int b;

    public PII(int a, int b) {
        this.a = a;
        this.b = b;
    }
}