package chapter2.lesson1;

import java.util.Scanner;

public class kmp02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 100010;int M = 1000010;
        int[] ne = new int[100010];
        int n = scanner.nextInt();
        String P = scanner.next();
        char[] p = new char[N];
        int m = scanner.nextInt();
        String S = scanner.next();
        char[] s = new char[M];
        for (int i = 1; i <= n; i++) {
            p[i] = P.charAt(i - 1);
        }
        for (int i = 1; i <= m; i++) {
            s[i] = S.charAt(i - 1);
        }
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) {
                System.out.print(i-n + " ");
                j = ne[j];
            }
        }
    }
}
