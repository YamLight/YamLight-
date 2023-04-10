package chapter3.lesson02;

import java.util.Scanner;

public class Nqueen {
    static int N = 10;
    static int n = 0;
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];
    static char[][] path = new char[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = '.';
            }
        }
        dfs(0);//deep first search
    }
    static void dfs(int u){
        if (u == n) {
            //[0,n - 1]
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n ; j++) {
                    System.out.print(path[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        //遍历n行
        for (int i = 0; i < n  ; i++) {
            if (!col[i] && !udg[i - u + n] && !dg[i + u]){//如果这行没有放过皇后
                path[u][i] = 'Q';
                //保证数组下标index不是负的
                //如果本身就是正的 那么加n 也可以保证对角线(斜对角线)编号唯一
                col[i] = true; udg[i - u + n] = true; dg[i + u] = true;
                dfs(u + 1);
                path[u][i] = '.';
                col[i] = false; udg[i - u + n] = false; dg[i + u] = false;
            }
        }
    }
}
