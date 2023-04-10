package AcWing.week6.day1;

import java.util.Scanner;

public class dp01 {
    static int N = 1010;
    static int[][] dp = new int[N][N];
    static int[] v = new int[N];//体积
    static int[] w = new int[N];//价值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= c ; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[n][c]);
    }
}
