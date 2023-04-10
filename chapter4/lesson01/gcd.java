package chapter4.lesson01;

import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(gcd(a,b));
        }
    }
    static int gcd(int a,int b){
        return b > 0 ? gcd(b,a % b) : a;
    }
}
