package chapter3.lesson02;

import java.util.Scanner;

public class Nqueen01 {
    static int N = 20;
    static char[][] path = new char[N][N];
    static boolean[] row = new boolean[N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];
    static int n = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[n][n] = '.';
            }
        }
        dfs(0, 0, 0);
    }

    static void dfs(int x, int y, int q) {
        if (y == n) {
            y = 0;
            x++;
        }
        if (x == n) {
            if (q == n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(path[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }
        dfs(x, y + 1, q);//不放皇后
        if (!row[x] && !col[y] && !dg[x - y + n]  && !udg[x + y]){//放皇后
            path[x][y] = 'Q';
            row[x] = col[y] = dg[x - y + n] = udg[x + y]= true;
            dfs(x,y + 1,q + 1);
            path[x][y] = '.';
            row[x] = col[y] = dg[x - y + n] = udg[x + y]= false;
        }
    }
}
