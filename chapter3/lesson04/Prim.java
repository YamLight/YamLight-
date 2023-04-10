package chapter3.lesson04;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {
    static int N = 510;
    static int n = 0;
    static int m = 0;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
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
        while (m-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            g[a][b] = g[b][a] = Math.min(c,g[a][b]);
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
            for (int j = 1; j <= n; j++) {
                if (!st[j]&&(t == -1 || dist[t] > dist[j])) t = j;//找到一个距离集合最近的点
            }
            //两次判断都要带上i 因为如果是第一次 那么集合里面就是空的 全都是正无穷了
            if (i != 0 &&dist[t] == max) return max;
            if (i != 0) res += dist[t];//将距离加入到res中
            st[t] = true;//把t点加入到集合当中
            //用t来更新其他的点
            for (int j = 1; j <= n ; j++) {
                dist[j] = Math.min(dist[j],g[t][j]);
            }
        }
        return res;
    }
}
