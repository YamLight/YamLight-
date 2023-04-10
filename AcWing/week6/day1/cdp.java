package AcWing.week6.day1;

import java.util.Scanner;

public class cdp {
    static int N = 2010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] dp = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            dp[0] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = v[i]; j <= m ; j++) {
                dp[j] = Math.max(dp[j],dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
