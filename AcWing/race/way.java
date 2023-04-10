package AcWing.race;

import java.io.*;
import java.util.*;

public class way {
    static int N = 500010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static ArrayList<Integer>[] set = new ArrayList[N];
    static int idx = 0;
    static int n,m;
    static int max = 0x3f3f3f;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.fill(dist,max);
        Arrays.fill(h,-1);
        String[] split = in.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        while (m-- > 0){
            String[] split2 = in.readLine().split(" ");
            int a = Integer.parseInt(split2[0]);
            int b = Integer.parseInt(split2[1]);
            int c = Integer.parseInt(split2[2]);
            add(a, b, c);
            add(b, a, c);
        }
        for (int i = 0; i <= n ; i++) {
            set[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n ; i++) {
            String[] split2 = in.readLine().split(" ");
            int k = Integer.parseInt(split2[0]);
            for (int j = 1; j <= k; j++)//注意:此处得从 1 号开始读,0 号点已经被读了
            {
                set[i].add(Integer.parseInt(split2[j]));
            }
        }
        Dijkstra();
        if (dist[n] != max) System.out.println(dist[n]);
        else System.out.println(-1);
    }
    static void Dijkstra(){
        PriorityQueue<PII> q = new PriorityQueue<PII>();
        q.add(new PII(0,1));//错误1
        dist[1] = 0;//错误2
        while (q.size() > 0){
            PII t = q.poll();
            int ver = t.second;
            int distance = t.first;
            if (st[ver]) continue;
            st[ver] = true;
            distance = get_delay(ver,distance);
            for (int i = h[ver]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    q.add(new PII(dist[j],j));
                }
            }
        }
    }
    static int get_delay(int ver,int distance){
        for (int t : set[ver]){
            if (t == distance) distance++;
            else if (t > distance) break;
        }
        return distance;
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
class PII implements Comparable<PII>{
    int first;
    int second;

    public PII(int first, int second) {
        this.first = first;//距离
        this.second = second;//编号
    }

    @Override
    public int compareTo(PII o) {
        return Integer.compare(first,o.first);
    }
}
