package chapter1.Lesson01;

import java.util.Scanner;

public class OJ_Reverse {
    private static int N = 100000;
    private static long[] a = new long[N];
    private static long[] temp = new long[N];
    private static long res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextLong();
        }
        mergesort(a, 0, m - 1);
        System.out.println(res);
    }

    static long mergesort(long a[], int l, int r) {
        if (l >= r) return 0;
        int i, j, mid;
        mid = (l + r) >> 1;
        mergesort(a, l, mid);
        mergesort(a, mid + 1, r);
        i = l;
        j = mid+1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else {
                temp[k++] = a[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        for (i = l, j = 0; i <= r; i++, j++) a[i] = temp[j];
        return res;
    }
}
