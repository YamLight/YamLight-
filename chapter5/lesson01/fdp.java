package chapter5.lesson01;

import java.util.Scanner;

public class fdp {
    static int N = 110;
    static int[][] v = new int[N][N];
    static int[][] w = new int[N][N];
    static int[] f = new int[N];
    static int[] s = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            s[i] = scanner.nextInt();
            for (int j = 0; j < s[i] ; j++) {
                v[i][j] = scanner.nextInt();
                w[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1 ; i <= n ; i++) {//第一组
            for (int j = m; j >= 0 ; j--) {//体积
                for (int k = 0; k < s[i] ; k++) {//遍历每个物品
                    if (v[i][k] <= j){
                        f[j] = Math.max(f[j],f[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        System.out.println(f[m]);
    }
}
