package AcWing.week3.day5;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class shop {
    static int N = 50010;
    static int n,m,k,q;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] w = new int[N];
    static int[] ne = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int idx = 0;
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
            add(a,b,c);  add(b,a,c);
        }
        int k = scanner.nextInt();
        while (k-- > 0){
            int num = scanner.nextInt();
            add(0,num,0);
        }
        Dijkstra();
        int q = scanner.nextInt();
        while (q-- > 0){
            int p = scanner.nextInt();
            System.out.println(dist[p]);
        }
    }
    static void Dijkstra(){
        PriorityQueue<PII> q = new PriorityQueue<PII>();
        Arrays.fill(dist,max);
        dist[0] = 0;
        q.add(new PII(0,0));
        while (q.size() > 0){
            PII t = q.poll();
            int ver = t.second;
            int distance = t.first;
            if (st[ver]) continue;
            st[ver] = true;
            for (int i = h[ver]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    q.add(new PII(dist[j],j));
                }
            }
        }
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a]  = idx++;
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
