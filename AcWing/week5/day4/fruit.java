package AcWing.week5.day4;

import java.util.Scanner;

public class fruit {
    static int N = 2010;
    static long[][] c = new long[N][N];
    static int mod = 998244353;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= k ; i++) {
            c[1][i] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            c[i][0] = m;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= k && j < i; j++) {
                if (j == 0) c[i][j] = m;
                else c[i][j] = (c[i - 1][j - 1] * (m - 1) % mod + c[i - 1][j]) % mod;
            }
        }
        System.out.println(c[n][k]);
    }
}
