package chapter1.Lesson01;

import java.util.Scanner;

public class merge_sort02 {
    private static int N = 100000;
    private static int[] a = new int[N];
    private static int[] temp = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        mergesort(a, 0, m - 1);
        for (int i = 0; i < m; i++) {
            System.out.print(a[i] + " ");
        }

    }
    static void mergesort(int a[], int l, int r) {
        int i, j, mid;
        if (l >= r) return;
        int k = 0;
        mid = (l + r) >> 1;
        i = l;
        j = mid+1;
        mergesort(a, l, mid);
        mergesort(a, mid + 1, r);
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        for (i = l, j = 0; i <= r; i++, j++) a[i] = temp[j];
    }
}
