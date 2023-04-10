package zhenti.p2021;

import java.util.Scanner;

public class fama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long i,ans;
        for (i = 1,ans = 1 ; ans < n ; i++) {
            ans += Math.pow(3,i);
        }
        System.out.println(i);
    }
}
