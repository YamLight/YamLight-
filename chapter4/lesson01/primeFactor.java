package chapter4.lesson01;

import java.util.Scanner;

public class primeFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int a = scanner.nextInt();
            prime(a);
        }
    }
    static void prime(int x){
        for (int i = 2; i <= x / i ; i++) {
            if (x % i == 0){
                int res = 0;
                while (x % i == 0){
                    x /= i;
                    res++;
                }
                System.out.println(i+" "+res);
            }
        }
        if (x > 1) System.out.println(x + " 1");
        System.out.println();
    }
}
