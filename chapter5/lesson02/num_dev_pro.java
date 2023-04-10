package chapter5.lesson02;

import java.util.Scanner;

public class num_dev_pro {
    static int N = 1010;
    static int[] f = new int[N];
    static int mod = (int)(1e9 + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        f[0] = 1;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = i; j <= n ; j++) {
                if (j >= i) f[j] = (f[j] + f[j - i]);
            }
        }
        System.out.println(f[n]);
    }
}
