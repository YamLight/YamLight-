package zhenti.p2020;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p10 {
    static int N = 10010;
    static int[] cnt = new int[N];
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        Arrays.fill(h,-1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);
        while (q-- > 0){
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int c = Integer.parseInt(s2[2]);
            if (a == 1){
                add(b,c); add(c,b);
            }
            else {
                bfs(b,c);
            }
        }
        for (int i = 1; i <= n ; i++) {
            bw.write(cnt[i] + " ");
        }
        bw.close();
        br.close();
    }
    static void bfs(int num,int info){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] st = new boolean[N];
        queue.add(num);
        st[num] = true;
        cnt[num] += info;
        while (queue.size() > 0){
            int t = queue.poll();
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (st[j]) continue;
                cnt[j] += info;
                queue.add(j);
                st[j] = true;
            }
        }
    }
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
