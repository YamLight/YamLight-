package chapter1.Lesson01;

import java.util.Scanner;

public class Oj_Bsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m, n;
        int x;
        int[] a = new int[100000];
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        while (m-- > 0) {
            int l, r, mid;
            l = 0;
            r = n - 1;
            x = scanner.nextInt();
            while (l < r) {
                mid = (l + r) / 2;
                if (a[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (a[r] != x) System.out.println("-1 -1");
            else {
                System.out.print(l + " ");
                l = 0;
                r = n - 1;
                while (l < r) {
                    mid = (l + r + 1) / 2;
                    if (a[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }
}
