package chapter1.Lesson01;

import java.util.Scanner;

public class quick_sort02 {
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
        quicksort(a, 0, m-1);
        for (int i = 0; i < m; i++) {
            System.out.print(a[i]+ " ");
        }
    }
    static void quicksort(int a[],int l,int r){
        int i,j,x;
        int temp;
        if(l>=r){
            return;
        }
        i=l-1;j=r+1;x=a[(i+j)>>1];
        while(i<j){
            do {
                i++;
            }while(a[i]<x);
            do {
                j--;
            }while(a[j]>x);
            if(i<j) {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        quicksort(a,l,j);
        quicksort(a,j+1,r);
    }
}
