package AcWing.week6.day1;

import java.util.Scanner;

public class num_dev01 {
    static int N = 100010;
    static int[] f = new int[N];
    static int mod = (int)1e9;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        f[0] = 1;
        for (int i = 1; i <= n ; i *= 2) {
            for (int j = i; j <= n ; j++) {
                f[j] = (f[j] % mod + f[j - i] % mod) % mod;
            }
        }
        System.out.println(f[n]);
    }
}
