package chapter4.lesson02;

import java.util.Scanner;

public class linearEuler {
    static int N = 100010;
    static int[] phi = new int[N];
    static boolean[] st = new boolean[N];
    static int[] primes = new int[N];
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getEuler(n);
        long res = 0;
        for (int i = 1; i <= n ; i++) {
            res += phi[i];
        }
        System.out.println(res);
    }
    static void getEuler(int x){
        phi[1] = 1;
        for (int i = 2; i <= x ; i++) {
            if (!st[i]){
                primes[cnt++] = i;
                phi[i] = i - 1;
            }
            for (int j = 0; primes[j] <= x / i ; j++) {//枚举所有的质数
                st[primes[j] * i] = true;
                if (i % primes[j] == 0){
                    phi[primes[j] * i] = primes[j] * phi[i];
                    break;
                }
                phi[primes[j] * i] = phi[i] * (primes[j] - 1);
            }
        }
    }
}
