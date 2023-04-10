package chapter1.Lesson01;

import java.util.Scanner;

public class quick_sort03 {
    private static int N = 100000;
    private static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m;
        m=sc.nextInt();
        for (int i = 0; i <m ; i++) {
            a[i]=sc.nextInt();
        }
        quicksort(a,0,m-1);
        for (int i = 0; i <m ; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    static void quicksort(int a[],int l ,int r){
        int i,j,x;
        int temp;
        if(l>=r)  return;
        i=l-1;j=r+1;
        x=a[(i+j)>>1];
        while(i<j){
            do {
                i++;
            }while(a[i]<x);
            do {
                j--;
            }while(a[j]>x);
            if(i<j){
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        quicksort(a,l,j);quicksort(a,j+1,r);
    }
}
