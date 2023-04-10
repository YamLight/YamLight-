package AcWing.week5.day3;

import java.util.Scanner;

public class mi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextInt();
        long n = scanner.nextInt();
        int p = 233333;
        System.out.println(qmi(x,n,p));
    }
    static long qmi(long a,long k,long p){
        long res = 1;
        while (k != 0){
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}
