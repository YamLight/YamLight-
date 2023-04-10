package chapter3.lesson01;

import java.util.Scanner;

public class str_hash01 {
    static int N = 100010;
    static long[] h = new long[N]; //代表字符串的唯一P进制数 转成的十进制数
    static long[] p = new long[N];
    static int P = 131;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int n = scanner.nextInt();
        String str = scanner.next();
        char[] chars = str.toCharArray();
        h[0] = 0;
        p[0] = 1;
        for (int i = 1; i <= len; i++) {
            h[i] = h[i - 1] * P + chars[i - 1];
            p[i] = p[i - 1] * P;
        }
        while (n-- > 0) {
            int l1, r1, l2, r2;
            l1 = scanner.nextInt();
            r1 = scanner.nextInt();
            l2 = scanner.nextInt();
            r2 = scanner.nextInt();
            if (get(l1, r1) == get(l2, r2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
