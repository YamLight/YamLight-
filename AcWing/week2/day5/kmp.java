package AcWing.week2.day5;

import java.util.Scanner;

public class kmp {
    static int N = 100010;
    static int[] ne = new int[N];
    static char[] s = new char[N];
    static char[] p = new char[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s1 = scanner.next();
        int m = scanner.nextInt();
        String s2 = scanner.next();
        for (int i = 1; i <= n ; i++) {
            p[i] = s1.charAt(i - 1);
        }
        for (int i = 1; i <= m ; i++) {
            s[i] = s2.charAt(i - 1);
        }
        for (int i = 2,j = 0; i <= n ; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        for (int i = 1,j = 0; i <= m ; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n){
                System.out.print(i - n + " ");
                j = ne[j];
            }
        }
    }
}
