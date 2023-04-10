package AcWing.week5.day3;

import java.util.Scanner;

public class qmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0){
            int a = scanner.nextInt();
            int k = scanner.nextInt();
            int p = scanner.nextInt();
            System.out.println(qmi(a,k,p));
        }
    }
    static long qmi(int a,int k,int p){
        long res = 1;
        while (k != 0){
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}
