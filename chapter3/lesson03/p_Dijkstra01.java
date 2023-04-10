package chapter3.lesson03;

import java.util.Arrays;
import java.util.Scanner;

public class p_Dijkstra01 {
    static int N = 510;
    static int[][] g = new int[N][N];
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];
    static int n = 0;
    static int max = 0x3f3f3f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(dist, max);
        dist[1] = 0;
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = max;
            }
        }
        int m = scanner.nextInt();
        while (m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (g[a][b] > c) g[a][b] = c;
        }
        System.out.println(Dijkstra());
    }

    static int Dijkstra() {
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) t = j;
            }
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[t] + g[t][j], dist[j]);
            }
        }
        if (dist[n] == max) return -1;
        else return dist[n];
    }
}
