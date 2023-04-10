package AcWing.week5.day1;

import java.util.Scanner;

public class prime_sum {
    static int N = 1010;
    static int[] s = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0){
            int[] primes = new int[N];
            boolean[] st = new boolean[N];
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int cnt = 0;
            for (int i = 2; i <= n ; i++) {
                if (!st[i]) primes[cnt++] = i;
                for (int j = 0; primes[j] <= n / i  ; j++) {
                    st[primes[j] * i] = true;
                    if (i % primes[j] == 0) break;
                }
            }
            int res = 0;
            for (int i = 0; i < cnt - 1; i++) {
                int sum = primes[i] + primes[i + 1] + 1;
                for (int j = 0; j < cnt; j++) {
                    if (primes[j] == sum) res++;
                }
            }
            if (res >= k) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
