package chapter5.lesson01;

import java.util.Scanner;

public class cdp {
    static int M = 1010;
    static int[] v = new int[M];
    static int[] w = new int[M];
    static int[][] f = new int[M][M];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        //dp问题 我们一般都是直接从第 1 层开始的 所以这里也从1开始就可以遍历到
        for (int i = 1; i <= N ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j <= V ; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) f[i][j] = Math.max(f[i][j],f[i][j - v[i]] + w[i]);
            }
        }
        System.out.println(f[N][V]);
    }
}
