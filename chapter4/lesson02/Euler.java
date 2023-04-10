package chapter4.lesson02;

import java.util.Scanner;

public class Euler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int x = scanner.nextInt();
            int res = x;
            for (int i = 2 ; i <= x / i ; i++) {
                if (x % i ==0){
                    //如果找到了质因数 那就要一直除 还是前面没把思想学到为
                    while (x % i == 0) x /= i;
                    res = res / i * (i - 1);
                }
                //特判 错误
            }
            if (x > 1) res = res / x * (x - 1);
            System.out.println(res);
        }
    }
}
