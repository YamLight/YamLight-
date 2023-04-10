package 蓝桥杯辅导课.chapter1.BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 献给阿尔吉侬的花束 {
    static int M = 210;
    static int T = 0;
    static int r,c;
    static boolean[][] st = new boolean[M][M];
    static int[][] dist = new int[M][M];
    static char[][] map = new char[M][M];
    static int startx,starty;
    static int[][] dir = new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
    };
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0){
            String[] s1 = br.readLine().split(" ");
            int r = Integer.parseInt(s1[0]);
            int c = Integer.parseInt(s1[1]);
            for (int i = 1; i <= r ; i++) {
                String s2 = br.readLine();
                for (int j = 1; j <= c ; j++) {
                    map[i][j] = s2.charAt(j - 1);
                }
            }
            for (int i = 1; i <= r ; i++) {
                for (int j = 1; j <= c ; j++) {
                    if (map[i][j] == 'S') {
                        startx = i;
                        starty = j;
                    }
                }
            }
            int res = bfs(startx,starty);
            if (res != -1) System.out.println(res);
            else System.out.println("oop!");
        }
    }
    static int bfs(int x,int y){
        Queue<pair> q = new LinkedList<>();
        for (int i = 1; i <= r ; i++) {
            Arrays.fill(dist,-1);
        }
        q.add(new pair(x,y));
        dist[x][y] = 0;
//        st[x][y] = true;
        while (!q.isEmpty()){
            pair t = q.poll();
//            st[x][y] = false;
            for (int i = 0; i < 4; i++) {
                int dx = t.x + dir[i][0];
                int dy = t.y + dir[i][1];
                if (dx >= 1 && dx <= r && dy >= 1 && dy <= c && map[dx][dy] != '#' && dist[dx][dy] != -1){
                    dist[dx][dy] = dist[t.x][t.y] + 1;
                    q.add(new pair(dx,dy));
                    if (map[dx][dy] == 'E') return dist[dx][dy];
                }
            }
        }
        return -1;
    }
}
class pair{
    int x;
    int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
