package chapter5.lesson02;

import java.util.Scanner;

public class pub_sub {
    static int N = 1010;
    static int[][] f = new int[N][N];
    static char[] a = new char[N];
    static char[] b = new char[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s1 = scanner.next();
        String s2 = scanner.next();
        for (int i = 1; i <= n ; i++) {
            a[i] = s1.charAt(i - 1);
        }
        for (int i = 1; i <= m ; i++) {
            b[i] = s2.charAt(i - 1);
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]);
                if (a[i] == b[j]) f[i][j] = Math.max(f[i][j],f[i - 1][j - 1] +1);
            }
        }
        System.out.println(f[n][m]);
    }
}
