package 蓝桥杯辅导课.chapter1.递归搜索;

import java.io.*;

public class 带分数 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] st = new boolean[10];
    static int[] num = new int[10];
    static int n = 0;
    static int ans = 0;
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        dfs(0);
        pw.println(ans);
        pw.close();
    }
    static int cal(int l,int r){
        int res = 0;
        for (int i = l; i <= r ; i++) {
            res = res * 10 + num[i];
        }
        return res;
    }
    static void dfs(int u){
        if (u == 9){
            for (int i = 0; i <= 6 ; i++) {
                for (int j = i + 1; j <= 7 ; j++) {
                    int a = cal(0,i);
                    int b = cal(i + 1,j);
                    int c = cal(j + 1,8);
                    if (a * c + b == n * c) ans++;
                }
            }
            return;
        }
        for (int i = 1; i <= 9 ; i++) {
            if (!st[i]){
                num[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}
