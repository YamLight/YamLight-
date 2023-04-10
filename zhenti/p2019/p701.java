package zhenti.p2019;

import java.io.*;
import java.util.Arrays;

public class p701 {
    static int N = 100010;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n,m,T;
    static PII[] pair = new PII[N];
    static int[] score = new int[N];
    static int[] last = new int[N];
    static boolean[] st = new boolean[N];
    static int res = 0;
    public static void main(String[] args) throws IOException {
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        T = Integer.parseInt(s1[2]);
        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().split(" ");
            int ts = Integer.parseInt(s2[0]);
            int id = Integer.parseInt(s2[1]);
            pair[i] = new PII(ts,id);
        }
        Arrays.sort(pair,0,m);
        for (int i = 0; i < m;) {//遍历所有订单
            int j = i;
            while (j < m && pair[i].ts == pair[j].ts && pair[i].id == pair[j].id) j++;//寻找相同订单
            int t = pair[i].ts, id = pair[i].id, cnt = j - i;//相同订单数
            i = j;
            score[id] -= t - last[id] - 1;//上一次有订单是什么时间
            if (score[id] <= 0) score[id] = 0;
            if (score[id] <= 3) st[id] = false;
            score[id] += cnt * 2;
            if (score[id] > 5) st[id] = true;
            last[id] = t;
        }
        for (int i = 1; i <= n ; i++) {
            if (last[i] < T){
                score[i] -= T - last[i];
            }
            if (score[i] <= 0) score[i] = 0;
            if (score[i] <= 3) st[i] = false;
            if (score[i] > 5) st[i] = true;
        }
        for (int i = 1; i <= n ; i++) {
            if (st[i]) res++;
        }
        pw.print(res);
        pw.close();
    }
}
class PII implements Comparable<PII>{
    int ts;
    int id;

    public PII(int ts, int id) {
        this.ts = ts;
        this.id = id;
    }

    @Override
    public int compareTo(PII o) {
        if (ts == o.ts){
            if (id > o.id){
                return 1;
            }
            else if (id < o.id) return -1;
            return 0;
        }
        return ts > o.ts ? 1 : -1;
    }
}
