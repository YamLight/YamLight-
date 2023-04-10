package chapter3.lesson04;

import java.util.Arrays;
import java.util.Scanner;

public class Krustral01 {
    static int N = 200010;
    static int[] p = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Edge01[] edges = new Edge01[N];
        for (int i = 1; i <= n ; i++) {//初始化并查集
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {//有m条边
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            edges[i] = new Edge01(a,b,c);
        }
        Arrays.sort(edges,0,m);
        int res = 0, cnt = 1;
        for (int i = 0; i < m; i++) {
            int a = edges[i].a, b = edges[i].b, c = edges[i].c;
            if (find(a) != find(b)){
                p[find(a)] = b;
                res += c;
                cnt++;
            }
        }
        if (cnt == n) System.out.println(res);
        else System.out.println("impossible");
    }
    static int find(int x){
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
class Edge01 implements Comparable<Edge01>{
    int a;
    int b;
    int c;

    public Edge01(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Edge01 o) {
        return Integer.compare(c,o.c);
    }
}