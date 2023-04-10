package chapter1.Lesson01;

import java.util.Scanner;

public class quicksort05 {
    private static int N = 100010;
    private static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        quicksort(a,0,n-1);
        for (int i = 0; i <n ; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void quicksort(int a[],int l,int r){
        int i,j,x,temp;
        if(l>=r) return;
        i=l-1;j=r+1;
        x=a[(i+j)>>1];
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
        quicksort(a,l,j);quicksort(a,j+1,r);
    }
}
