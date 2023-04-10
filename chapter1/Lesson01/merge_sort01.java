package chapter1.Lesson01;

import java.util.Scanner;

public class merge_sort01 {
    private static int N = 100000;
    private static int[] a = new int[N];
    private static int[] temp = new int[N];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        for (int i = 0; i <m ; i++) {
            a[i]=scanner.nextInt();
        };
        mergesort(a,0,m-1);
        for (int i = 0; i <m ; i++) {
            System.out.println(a[i]);
        }
    }
    public static void mergesort(int a[], int l, int r) {
        int i, j;
        int mid = (l + r) >> 1;
        if (l >= r) return;
        mergesort(a,l,mid);mergesort(a,mid+1,r);
        int k = 0;
        i = l;
        j = mid + 1;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        for (i=l,j=0;i<=r;i++,j++) a[i]=temp[j];
    }
}
