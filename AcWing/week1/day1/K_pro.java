package AcWing.week1.day1;

import java.util.Scanner;

public class K_pro {
    static int N = 100010;
    static int[] a = new int[N];
    static long[] s = new long[N];
    static long[] cnt = new long[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            s[i] = s[i - 1] + a[i];
        }
        long res = 0;
        cnt[0]++;
        for (int i = 1; i <= n ; i++) {
            int num = (int)(s[i] % k);
            res += cnt[num];
            cnt[num] ++;
        }
        System.out.println(res);
    }
}

