package chapter3.lesson03;

import java.util.Arrays;
import java.util.Scanner;

public class Bellman_Ford implements Cloneable{
    static int N = 10010;
    static int M = 510;
    static int k = 0;
    static int m = 0;
    static int n = 0;
    static int[] dist = new int[N];
    static int[] backup = new int[N];
    static Three[] three = new Three[M];
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        for (int j = 0; j < m; j++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            three[j] = new Three(a,b,c);
        }
        bellman_ford();
        if (dist[n] > max / 2) System.out.println("impossible");
        else System.out.println(dist[n]);
    }
    public static void bellman_ford(){
        Arrays.fill(dist,max);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            backup = Arrays.copyOf(dist,n + 1);
            for (int j = 0; j < m; j++) {
                Three t = three[j];
                //防止串联 用刚才备份的距离来更新
                int a = t.a;
                int b = t.b;
                int c = t.c;
                dist[b] = Math.min(dist[b],backup[a] + c);
            }
        }
    }
}
class Three{
    int a,b,c;

    public Three(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
