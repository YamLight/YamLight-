package chapter5.lesson02;

import java.util.Scanner;

public class stone_merge {
    static int N = 310;
    static int[] a = new int[N];
    static int[] s = new int[N];
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1 ; i <= n ; i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (int len = 2; len <= n ; len++) {//区间长度
            for (int i = 1; i + len - 1 <=n ; i++) {//左端点
                int l = i,r = i + len - 1;//左右两个断点
                f[l][r] = (int)1e8;
                for (int k = l; k < r ; k++) {//k是断点 因为至少要给左区间留一个元素 所以最大是r - 1
                    f[l][r] = Math.min(f[l][r],f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
