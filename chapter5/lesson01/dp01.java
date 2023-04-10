package chapter5.lesson01;

import java.util.Scanner;

public class dp01 {
    static int N = 1010;
    static int[] v = new int[N];//体积
    static int[] w = new int[N];//价值
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {//读入每个物品的信息
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {//枚举所有物品
            for (int j = 0; j <= m ; j++) {//枚举总体积
                f[i][j] = f[i - 1][j];//不考虑第i件物品
                if (j >= v[i]) f[i][j] = Math.max(f[i][j],f[i - 1][j - v[i]] + w[i]);//考虑第i件物品
            }
        }
        System.out.println(f[n][m]);
    }
}
