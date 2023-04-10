package AcWing.week3.day3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class way {
    static int[][] g = new int[10][10];
    static HashSet<Integer> set = new HashSet<>();
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
//    static int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    static int n,m,k;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i,j,g[i][j],0);
            }
        }
        System.out.println(set.size());
    }
    static void dfs(int x,int y,int num,int u){
        if (u == k) {
            set.add(num);
        }
        else {
            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
//                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (tx >= 0 && tx < n && ty >= 0 && ty < m) dfs(tx,ty,num * 10 + g[tx][ty],u + 1);
            }
        }
    }
}
