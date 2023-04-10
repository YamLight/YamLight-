package chapter1.Lesson01;

import java.util.Scanner;

public class cube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double l = -10000;
        double r = 10000;
        double mid = 0 ;
        while(r - l>1e-8){
            mid = (l + r) / 2;
            if (mid*mid*mid >= n) r = mid;
            else l=mid;
        }
        System.out.printf("%.6f",mid);
    }
}
