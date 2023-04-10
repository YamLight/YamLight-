package chapter1.Lesson02;

import java.util.Scanner;

public class GapMetrix {
    private static int N = 1010;
    private static int[][] a = new int[N][N];
    private static int[][] b = new int[N][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        for (int i = 1; i <= n; i++) {//输入a数组
            for (int j = 1; j <= m; j++) {
                a[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {//输入a数组
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {//初始化差分数组
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }
        while (q-- > 0) {//加c
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int c=scanner.nextInt();
            insert(x1,y1,x2,y2,c);
        }
        for (int i = 1; i <= n; i++) {//存储结果
            for (int j = 1; j <= m; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
