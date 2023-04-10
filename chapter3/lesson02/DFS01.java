package chapter3.lesson02;

import java.util.Scanner;

public class DFS01 {
    static int N = 100010;
    static int n = 0;
    static boolean[] use = new boolean[N];
    static int[] path = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0);
    }
    static void dfs(int x){
        if (x == n) {
            for (int i = 0; i < n ; i++) {
                System.out.print(path[i]+" ");
            }
            System.out.println();
        }
        for (int i = 1; i <=n ; i++) {
            if (!use[i]){
                path[x] = i;
                use[i] = true;
                dfs(x + 1);
                use[i] = false;
            }
        }
    }
}
