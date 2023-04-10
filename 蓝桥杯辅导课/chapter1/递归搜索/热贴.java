package 蓝桥杯辅导课.chapter1.递归搜索;

import java.io.*;
import java.util.Arrays;

public class 热贴 {
    static int N = 100010;
    static pair[] pairs = new pair[N];
    static boolean[] st = new boolean[N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n,d,k = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        for (int i = 1; i <= n ; i++) {
            String[] s1 = br.readLine().split(" ");
            int ts = Integer.parseInt(s1[0]);
            int id = Integer.parseInt(s1[1]);
            max = Math.max(max,id);
            pairs[i] = new pair(ts,id);
        }
        Arrays.sort(pairs,1,n + 1);
        for (int i = 1; i <= n ; i++) {
            int cnt = 0,j = i;
            int t = pairs[i].ts;
            int id = pairs[i].id;
            while (j <= n && pairs[j].id == pairs[i].id && pairs[j].ts < t + d){
                cnt++;
//                System.out.println(cnt + " " + j + " " + pairs[j].ts);
                j++;
            }
            if (cnt >= k) {
                st[pairs[i].id] = true;
                i = j;
            }
        }
//        for (int i = 1; i <= n ; i++) {
//            System.out.println(pairs[i].ts + " " + pairs[i].id);
//        }
        for (int i = 1; i <= max ; i++) {
            if (st[i]) System.out.println(i);
        }
    }
}
class pair implements Comparable<pair>{
    int ts;
    int id;

    public pair(int ts, int id) {
        this.ts = ts;
        this.id = id;
    }

    @Override
    public int compareTo(pair o) {
        if (id == o.id){
            if (ts > o.ts) return 1;
            else if (ts < o.ts) return -1;
            else return 0;
        }
        else return id > o.id ? 1 : -1;
    }
}
