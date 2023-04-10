package AcWing.week3.day5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    static int N = 510;
    static int M = 50010;
    static int[] dist = new int[M];
    static boolean[] st = new boolean[N];
    static int[][] g = new int[N][N];
    static int max = 0x3f3f3f;
    static int n,m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        Arrays.fill(dist,max);
        dist[1] = 0;//初始化1到自己的距离
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = max;
            }
        }
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            g[a][b] = Math.min(g[a][b],c);
        }
        Dijkstra();
        if (dist[n] == max) System.out.println("-1");
        else System.out.println(dist[n]);
    }
    static void Dijkstra(){
        for (int i = 1; i <= n ; i++) {
            int t = -1;
            for (int j = 1; j <= n ; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) t = j;
            }
            st[t] = true;
            for (int j = 1; j <= n ; j++) {
                dist[j] = Math.min(dist[t] + g[t][j],dist[j]);
            }
        }
    }
}
