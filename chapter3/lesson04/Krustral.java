package chapter3.lesson04;

import java.util.Arrays;
import java.util.Scanner;

public class Krustral {
    static int M = 200010;
    static int[] p = new int[M];
    static Edge[] edges = new Edge[M];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //初始化并查集
        for (int i = 1; i <= n ; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            edges[i] = new Edge(a,b,c);
        }
        Arrays.sort(edges,0,m);
        int res = 0, cnt = 0;
        for (int i = 0; i < m ; i++) {
            int a = edges[i].a; int b = edges[i].b; int c = edges[i].c;
            if (find(a) != find(b)) {
                p[find(a)] = b;
                res += c;
                cnt ++;
            }
        }
        if (cnt == n - 1) System.out.println(res);
        else System.out.println("impossible");
    }

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int c;

    public Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int compareTo(Edge o) {
        return Integer.compare(c, o.c);
    }
}
