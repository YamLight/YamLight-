package chapter4.lesson02;

import java.util.Scanner;

public class qmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0)
        {
            int a,k,p;
            a = scanner.nextInt();
            k = scanner.nextInt();
            p = scanner.nextInt();
            System.out.println(qmi(a,k,p));
        }
    }
    static int qmi(int a,int k,int p){
        int res = 1;
        while (k > 0){
            if ((k & 1) == 1) res = (int)((long)res * a % p);
            k >>= 1;
            a = (int)((long)a * a % p);
        }
        return res;
    }
}
