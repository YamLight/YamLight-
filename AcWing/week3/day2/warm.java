package AcWing.week3.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class warm {
    static int N = 1010;
    static int n = 0;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[][] dir = new int[][]{
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!st[i][j] && g[i][j] == '#'){
                    if (dfs(i,j)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static boolean dfs(int x,int y){
        Queue<PII> q = new LinkedList<>();
        q.add(new PII(x,y));//将当前这个点入队
        st[x][y] = true;
        int total = 0,bound = 0;
        while (!q.isEmpty()){
            PII t = q.poll();
            total++;
            int tx,ty;
            boolean is_bound = false;
            for (int i = 0; i < 4; i++) {
                tx = t.x + dir[i][0] ; ty = t.y + dir[i][1];
                if (tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                if (st[tx][ty]) continue;
                if (g[tx][ty] == '.') {
                    is_bound = true;
                    continue;
                }
                q.add(new PII(tx,ty));
                st[tx][ty] = true;
            }
            if (is_bound) bound++;
        }
        return total == bound;
    }
}
class PII{
    int x;
    int y;

    public PII(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
