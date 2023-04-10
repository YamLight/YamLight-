package 蓝桥杯辅导课.chapter1.BFS;

import java.io.*;

public class 红与黑 {
    static int N = 30;
    static char[][] map = new char[N][N];
    static int[][] dist = new int[N][N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int T,W,H;
    static int startx,starty;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0){
            String[] s1 = br.readLine().split(" ");
            W = Integer.parseInt(s1[0]);
            H = Integer.parseInt(s1[1]);
            for (int i = 0; i < W; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < H; j++) {
                    map[i][j] = c[j];
//                    if (map[i][j] == '')
                }
            }
        }
    }
}
