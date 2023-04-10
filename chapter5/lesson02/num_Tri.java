package chapter5.lesson02;

import java.util.Scanner;

public class num_Tri {
    static int N = 510;
    static int[][] a = new int[N][N];
    static int[][] f = new int[N][N];
    static int INF = (int)1e9;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= i + 1 ; j++) {
                f[i][j] = -INF;
            }
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        f[1][1] = a[1][1];
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1] + a[i][j],f[i - 1][j] + a[i][j]);
            }
        }
        int res = -INF;
        for (int i = 1; i <= n ; i++) {
            res = Math.max(f[n][i],res);
        }
        System.out.println(res);
    }
}
