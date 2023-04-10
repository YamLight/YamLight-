package chapter4.lesson02;

import java.util.Scanner;

public class Euler01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int x = scanner.nextInt();
            int res = x;
            for (int i = 2; i <= x / i ; i++) {//枚举所有质数
                if (x % i == 0) {
                    //错误
                    while (x % i == 0){
                        x /= i;
                    }
                    res = res / i * (i - 1);
                }
            }
            if (x > 1) res = res / x * (x - 1);
            System.out.println(res);
        }
    }
}
