package AcWing.week6.day1;

import java.util.Scanner;

public class cdp_pro {
    static int N = 1010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = m; j >= v[i] ; j--) {
                //我们发现 我们的第f[i][j]都是由f[i - 1][j]来迭代更新出来的
                //所以可以直接把二维数组降为一维数组
                //但是降维之后 我们的f[j - v[i]] + w[i]中 j - v[i]是一定严格小于j的
                //所以f[j - v[i]] + w[i]是在第i层被更新出来的 那这里就显然不符合我们的要求了
                //所以我们可以直接从大到小枚举 就可以保证我们先更新了容量大的状态 再去更新容量小的状态了
                f[j] = Math.max(f[j],f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
