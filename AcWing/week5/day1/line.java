package AcWing.week5.day1;

import java.util.Scanner;

public class line {
    static int N = 100010;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        boolean[] st = new boolean[N];
        int[] primes = new int[N];
        for (int i = 2; i <= n ; i++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; primes[j] <= n / i ; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
        System.out.println(cnt);
    }
}
