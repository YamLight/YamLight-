package AcWing.week5.day2;

import java.util.HashSet;
import java.util.Scanner;

public class mice {
    static int N = 1010;
    static double max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        HashSet<Double> set = new HashSet<>();
        while (n-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            double dx = x - x0;
            double dy = y - y0;
            if (dx == 0) {
                set.add(max);
            }
            else {
                double k = dy / dx;
                set.add(k);
            }
        }
        if (set.contains(0.0) && set.contains(-0.0)) set.remove(-0.0);
        System.out.println(set.size());
    }
}