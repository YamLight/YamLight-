package AcWing.week3.day5;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class h_dij {
    static int N = 500010;
    static int M = 2 * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] w = new int[M];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m,idx = 0;
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
        Dijkstra();
        if (dist[n] == max) System.out.println(-1);
        else System.out.println(dist[n]);
    }
    static void Dijkstra(){
        PriorityQueue<pair> q = new PriorityQueue<pair>();
        Arrays.fill(dist,max);
        dist[1] = 0;
        q.add(new pair(0,1));
        while (q.size() > 0){
            pair t = q.poll();
            int ver = t.y;
            int distance = t.x;
            if (st[ver]) continue;
            st[ver] = true;
            for (int i = h[ver]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    q.add(new pair(dist[j],j));
                }
            }
        }
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
class pair implements Comparable<pair>{
    int x;
    int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(pair o) {
        return Integer.compare(x,o.x);
    }
}
