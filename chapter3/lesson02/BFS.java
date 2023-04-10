package chapter3.lesson02;

import java.io.*;
import java.util.Scanner;

public class BFS {
    static int N = 110;
    static int n, m;
    static int[][] map = new int[N][N];
    static int[][] d = new int[N][N];
    static PII[] q = new PII[N*N];
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = re.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            String[] st = re.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st[j]);
                d[i][j] = -1;
            }
        }
        System.out.println(bfs());
        wt.close();
    }
    static int bfs() {
        int hh = 0, tt = -1;//维护队列
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};//x方向和y方向的向量
        d[0][0] = 0;//起点的距离是0
        q[++tt] = new PII(0, 0);
        while (hh <= tt) {
            PII t = q[hh++];//先把队头元素取出来 然后出队
            for (int i = 0; i < 4; i++) {//遍历四个方向
                int x = t.first + dx[i];
                int y = t.second + dy[i];
                //如果x没出界 y没出界 d[x][y]没被遍历过 而且map[x][y]可以走
                if (x >= 0 && x < n && y >= 0 && y < m && d[x][y] == -1 && map[x][y] == 0) {
                    //把这个点的距离加一
                    d[x][y] = d[t.first][t.second] + 1;
                    //那就把这个点入队
                    q[++tt] = new PII(x,y);
                }
            }
        }
        return d[n - 1][m - 1];
    }
}

class PII {
      int first;
    int second;

    public PII(int first, int second) {
        this.first = first;
        this.second = second;
    }
}