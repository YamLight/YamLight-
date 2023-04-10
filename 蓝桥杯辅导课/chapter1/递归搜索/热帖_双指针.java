package 蓝桥杯辅导课.chapter1.递归搜索;

import java.io.*;
import java.util.Arrays;

public class 热帖_双指针 {
    static int N = 100010;
    static PII[] PII = new PII[N];
    static boolean[] st = new boolean[N];
    static int[] cnt = new int[N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n,d,k = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            int ts = Integer.parseInt(s1[0]);
            int id = Integer.parseInt(s1[1]);
            max = Math.max(max, id);
            PII[i] = new PII(ts, id);
        }
        Arrays.sort(PII, 1, n + 1);
        for (int i = 1,j = 1; i <= n ; i++) {
            int id = PII[i].id;
            cnt[id]++;
            while (PII[i].ts - PII[j].ts >= d){
                cnt[PII[j].id]--;
                j++;
            }
            if (cnt[id] >= k) st[id] = true;
        }
        for (int i = 0; i <= 100000 ; i++) {
            if (st[i]) System.out.println(i);
        }
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
        return Integer.compare(ts,o.ts);
    }
}
