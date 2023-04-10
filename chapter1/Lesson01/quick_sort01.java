package chapter1.Lesson01;

import java.util.Scanner;

public class quick_sort01 {
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
        if(l>=r) return;
        i=l-1;j=r+1;x=a[(l+r)>>1];//x=a[l];  取左边界的、取右边界的、取中间的、随便取的
        while(i<j){
            do {
                i++;
                System.out.println("i="+i);
            }while(a[i]<x);
            do {
                j--;
                System.out.println("j="+j);
            }while(a[j]>x);
            System.out.println();
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
