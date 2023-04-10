package AcWing.week6.day2;

import java.util.Scanner;

public class stone {
    static int N = 310;
    static int[][] f = new int[N][N];
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        s[0] = 0;
        for (int i = 1; i <= n ; i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i,r = i + len - 1;
                f[l][r] = (int)1e8;
                for (int k = l; k < r ; k++) {
                    f[l][r] = Math.min(f[l][r],f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
