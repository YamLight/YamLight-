package chapter2.lesson1;

import java.util.Scanner;

public class Mqueue01 {
    private static int N = 100010;
    private static int[] a = new int[N];
    private static int[] q = new int[N];
    private static int k = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        k = scanner.nextInt();
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]]+" ");
        }
    }
}
