package chapter3.lesson01;

import java.util.Scanner;

public class str_Hash {
    static int N = 100010;
    static int P = 131;//进制数 这样是冲突最少的情况
    static long[] h = new long[N];
    static long[] p = new long[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        char[] chars = s.toCharArray();
        p[0] = 1;
        h[0] = 0;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + chars[i - 1];
            p[i] = p[i - 1] * P;
        }
        while (m-- > 0) {
            int l1, r1, l2, r2;
            l1 = scanner.nextInt();
            r1 = scanner.nextInt();
            l2 = scanner.nextInt();
            r2 = scanner.nextInt();
            if (get(l1, r1) == get(l2, r2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static long get(int l, int r) {
        //这里和迭代有些相似 但是位权对不上
        // a   b   c   d   e
        //         a   b   c
        //要想求 de 的哈希值 根据学习的前缀和知识直接 h[r] - h[r - 1]就可以 但是位权是对不上的
        // a   b   c         才可以 p[l - r - 1]就是相差的位权 即需要移动的位数
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
