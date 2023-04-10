package chapter1.Lesson01;

import java.util.Scanner;

public class merge_sort04 {
    private static int N = 100010;
    private static int[] a = new int[N];
    private static int[] temp = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i <n ; i++) {
            a[i] = scanner.nextInt();
        }
        mergesort(a,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void mergesort(int a[], int l, int r) {
        int i, j, mid;
        if (l >= r) return;
        mid = (l + r) >> 1;
        mergesort(a, l, mid);
        mergesort(a, mid + 1, r);
        i = l;
        j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            a[i] = temp[j];
        }
    }
}
