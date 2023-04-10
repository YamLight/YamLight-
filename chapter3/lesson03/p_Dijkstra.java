package chapter3.lesson03;

import java.util.Arrays;
import java.util.Scanner;

public class p_Dijkstra {
    static int N = 510;
    static boolean[] st = new boolean[N];
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static int n = 0;
    static int nulls = 0x3f3f3f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(dist, nulls);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = nulls;
            }
        }
        while (m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }
        System.out.println(Dijkstra());
    }

    static int Dijkstra() {
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {//遍历n次 每次确定一个最小值
            int t = -1;
            for (int j = 1; j <= n; j++) {
                //为什么要以这样的形式更新 因为如果直接开始按点遍历 就会出现第一个小的一直称霸王
                //让别的小的点上不去的现象 那就会出现无法更新的状况
                //这里t = -1的好处就是 不管三七二十一把第一次来的点直接给赋上 然后遍历找距离源点最近的
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {//找一个在s集合中的 并且距离源点最近
                    t = j;
                }
            }
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[t] + g[t][j], dist[j]);
            }
        }
        if (dist[n] == nulls) return -1;
        else return dist[n];
    }
}
