package chapter1.Lesson02;

import java.util.Scanner;

public class Prefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 100010;
        int[] a = new int[N];
        int[] s = new int[N];
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (int i = 1; i <= n ; i++) {
            System.out.print(s[i]+" ");
        }
//        while (m-- > 0) {
//            int l = scanner.nextInt();
//            int r = scanner.nextInt();
//            System.out.println(s[r] - s[l - 1]);
//        }
    }
}
