package chapter1.Lesson01;

import java.util.Scanner;

public class Oj01 {
    public static void main(String[] args) {
        int m, n;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int[] a = new int[m];
        n = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        quicksort(a, 0, m - 1);
        System.out.println(a[n - 1]);
    }

    public static void quicksort(int a[], int l, int r) {
        int i, j, x, temp;
        if (l >= r) return;
        i = l - 1;
        j = r + 1;
        x = a[(i + j) >> 1];
        while (i < j) {
            do {
                i++;
            } while (a[i] < x);
            do {
                j--;
            } while (a[j] > x);
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        quicksort(a, l, j);
        quicksort(a, j + 1, r);
    }
}
