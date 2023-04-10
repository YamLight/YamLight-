package chapter4.lesson02;

import java.util.Scanner;

public class qmi01 {
//    static int N = 1000010;
//    static int[] primes = new int[N];
//    static int[] phi = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int a = scanner.nextInt();
            int k = scanner.nextInt();
            int p = scanner.nextInt();
            System.out.println(get_qmi(a,k,p));
        }
    }
    static int get_qmi(int a,int k,int p){
        int res = 1;
        while (k != 0){
            if (k > 0){
                if ((k & 1) == 1) res = (int)((long)res * a % p);
                k >>= 1;
                a = (int)((long)a * a % p);
        }
    }
        return res;
    }
}
