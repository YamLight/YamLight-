package chapter1.Lesson02;

import java.util.Scanner;

public class Gap {
    private static int N = 100010;
    private static int[] a = new int[N];
    private static int[] b = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();//初始化a数组
        }
        for (int i = 1; i <= n; i++) {
            insert(i, i, a[i]);//求a的差分数组 也就是b数组
        }
        while (m-- > 0) {//m个询问
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            insert(l,r,c);//加c
        }
        for (int i = 1; i <=n ; i++) {
            a[i]=a[i-1]+b[i];
        }
        for (int i = 1; i <=n ; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }
}
