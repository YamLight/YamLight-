package zhenti.p2019;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p7 {
    static int N = 10010;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n,m,t;
    static int[][] a = new int[N][N];
    static int[][] s = new int[N][N];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        t = Integer.parseInt(s1[2]);
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= t ; j++) {
                a[i][j] = -1;
            }
        }
        while (m-- > 0){
            String[] s2 = br.readLine().split(" ");
            int ts = Integer.parseInt(s2[0]);
            int id = Integer.parseInt(s2[1]);
            if (a[id][ts] == -1) a[id][ts] = 0;
            if (ts <= t) a[id][ts] += 2;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= t ; j++) {
                int tmp = s[i][j - 1] + a[i][j];
                if (tmp > 0) s[i][j] = tmp;
                else s[i][j] = 0;
            }
        }
        for (int i = 1; i <= n ; i++) {
            if (s[i][t] > 5) q.add(i);
        }
        pw.print(q.size());
        pw.close();
    }
}
