package chapter1.Lesson01;

import java.util.Scanner;

public class quick_sort {
    public static void main(String[] args) {
        int N = 1000000;
        int[] a = new int[N];
        int m;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        qsort(a, 0, m-1);
        for (int i = 0; i < m; i++) {
            System.out.print(a[i]+ " ");
        }
    }

    static void qsort(int a[], int l, int r) {
        int i, j,  mid;
        if (l >= r) return;
        i = l - 1;
        j = r + 1;
        mid = a[(i + j) / 2];
        while (i < j) {
            do {
                i++;
            } while (a[i] < mid);
            do {
                j--;
            } while (a[j] > mid);
            if (i < j) swap(a,i,j);
        }
        qsort(a, l, j);
        qsort(a, j + 1, r);
    }

    static void swap(int a[], int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
