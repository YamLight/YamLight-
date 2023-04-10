package zhenti.p2021;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class p6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long HH = n / (1000 * 3600);
        long MM = n / (1000 * 60);
        long SS = n / 1000;
        int a = (int)(HH % 24);
        int b = (int)(MM % 60);
        int c = (int)(SS % 60);
        System.out.printf("%02d:%02d:%02d",a,b,c);
    }
}
