package AcWing.week2.day4;

import java.util.Scanner;

public class slipWindow_p {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] q = new int[N];
    static int hh = 0;
    static int tt = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            //hh管起点
            //tt管元素
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }
    }
}
