package chapter1.Lesson02;

import java.util.Scanner;

public class Metrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 1010;
        int[][] a = new int[N][N];
        int[][] s = new int[N][N];
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        s[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i][j-1]+s[i-1][j]-s[i-1][j-1]+a[i][j];
            }
        }
        while (q-->0){
            int x1=scanner.nextInt();
            int y1=scanner.nextInt();
            int x2=scanner.nextInt();
            int y2=scanner.nextInt();
            int sum=s[x2][y2]-s[x2][y1-1]-s[x1-1][y2]+s[x1-1][y1-1];
            System.out.println(sum);
        }
    }
}
