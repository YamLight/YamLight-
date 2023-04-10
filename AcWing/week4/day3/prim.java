package AcWing.week4.day3;

import java.util.Arrays;
import java.util.Scanner;

public class prim {
    static int N = 510;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m;
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                g[i][j] = max;
            }
        }
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b],c);
            if (a == b) g[a][b] = g[b][a] = 0;
        }
        int t = prim();
        if (t == max) System.out.println("impossible");
        else System.out.println(t);
    }
    static int prim(){
        Arrays.fill(dist,max);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n ; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) t = j;
            }
            if (i != 0 && dist[t] == max) return max;
            if (i != 0){
                res += dist[t];
            }
            st[t] = true;
            for (int j = 1; j <= n ; j++) {
                dist[j] = Math.min(dist[j],g[t][j]);
            }
        }
        return res;
    }
}
