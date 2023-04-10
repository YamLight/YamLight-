package chapter4.lesson02;

import java.util.Scanner;

public class qmi_inverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int a = scanner.nextInt();
            int p = scanner.nextInt();
            if (a % p == 0) System.out.println("impossible");
            else System.out.println(qmi_inverse(a,p - 2,p));
        }
    }
    static int qmi_inverse(int a,int k,int p){
        int res = 1;
        while (k != 0){
            if ((k & 1) == 1) res = (int)((long) res * a % p);
            k >>= 1;
            a = (int)((long)a * a % p);
        }
    return res;
    }
}
