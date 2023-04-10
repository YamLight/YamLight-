package AcWing.week4.day3;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    static int N = 10010;
    static int n,m;
    static int[] f = new int[N];
    static Edge[] edges = new Edge[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= m ; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();
            edges[i] = new Edge(a,b,w);
        }
        for (int i = 1; i <= n ; i++) {
            f[i] = i;
        }
        Arrays.sort(edges,1,m + 1);
        int res = 0,cnt = 0;
        for (int i = 1; i <= m ; i++) {
            Edge t = edges[i];
            int a = t.a, b = t.b, w = t.w;
            int fa = find(a), fb = find(b);
            if (fa != fb){
                f[fa] = fb;
                res += w;
                cnt++;
            }
        }
        if (cnt == n - 1) System.out.println(res);
        else System.out.println("impossible");
    }
    static int find(int x){
        if (f[x] != x) return f[x] = find(f[x]);
        return f[x];
    }
}
class Edge implements Comparable<Edge>{
    int a;
    int b;
    int w;

    public Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(w,o.w);
    }
}
