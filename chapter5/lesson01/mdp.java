package chapter5.lesson01;

import java.util.Scanner;

public class mdp {
    static int N = 1010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] s = new int[N];
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= m ; j++) {
                for (int k = 0; k <= s[i] && k * v[i] <= j /*这里应该是小于等于j*/ ; k++) {
                    f[i][j] = Math.max(f[i][j],f[i - 1][j - v[i] * k] + k * w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
