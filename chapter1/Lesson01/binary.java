package chapter1.Lesson01;

import java.util.Scanner;

public class binary {
    private static int N = 100010;
    private static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        while (n-- > 0) {
            int q = scanner.nextInt();
            int l, r, mid;
            l = 0;
            r = m - 1;
            while (l < r) {
                mid = (l + r) / 2;
                if (a[mid] >= q) r = mid;
                else l = mid + 1 ;
            }
            if (a[l] != q) System.out.println("-1 -1");
            else {
                System.out.print(l+" ");
                l = 0;
                r = m - 1;
                while (l < r) {
                    mid = (l + r + 1) / 2;
                    if (a[mid] <= q) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }
}
