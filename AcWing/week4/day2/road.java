package AcWing.week4.day2;

import java.util.Arrays;
import java.util.Scanner;

public class road {
    static int N = 410;
    static int[][] f = new int[N][N];
    static int[][] g = new int[N][N];
    static int n,m;
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            Arrays.fill(f[i],max);
            Arrays.fill(g[i],max);
            f[i][i] = g[i][i] = 0;
        }
        while (m-- > 0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            f[x][y] = f[y][x] = 1;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (i != j && f[i][j] != 1) g[i][j] = g[j][i] = 1;
            }
        }
        int a = floyd(f); int b = floyd(g);
        int res = Math.max(a,b);
        if (res == max) System.out.println(-1);
        else System.out.println(res);
    }
    static int floyd(int[][] a){
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    a[i][j] = Math.min(a[i][j],a[i][k] + a[k][j]);
                }
            }
        }
        return a[1][n];
    }
}
