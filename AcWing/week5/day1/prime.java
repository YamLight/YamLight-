package AcWing.week5.day1;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Scanner;

public class prime {
    static int[] primes = new int[100010];
    static boolean[] st = new boolean[100010];
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 2; i <= n ; i++) {
            if (!st[i]){
                primes[cnt++] = i;
                for (int j = i; j <= n ; j += i) {//只筛质数的倍数
                    st[j] = true;
                }
            }
        }
        System.out.println(cnt);
    }
}
