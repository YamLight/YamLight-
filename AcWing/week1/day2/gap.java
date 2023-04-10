package AcWing.week1.day2;

import java.util.Scanner;

public class gap {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            add(i,i,a[i]);//初始化差分数组(b)
        }
        while (m-- > 0){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            add(l,r,c);
        }
        for (int i = 1; i <= n ; i++) {
            a[i] = a[i - 1] + b[i];
        }
        for (int i = 1; i <= n ; i++) {
            System.out.print(a[i] + " ");
        }
    }
    static void add(int l,int r,int c){
        b[l] += c;
        b[r + 1] -= c;
    }
}
