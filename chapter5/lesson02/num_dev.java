package chapter5.lesson02;

import java.util.Scanner;

public class num_dev {
    static int N = 1010;
    static int mod = (int) 1e9 + 7;
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i <= n ; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= n ; i++) {//把数字看成物品 枚举前i个物品
            for (int j = 1; j <= n ; j++) {//和是j
                f[i][j] = f[i - 1][j] % mod;
                if (j >= i) f[i][j] = (f[i - 1][j] + f[i][j - i]) % mod;//这是我们推导发现的公式
            }
        }
        System.out.println(f[n][n]);
    }
}
