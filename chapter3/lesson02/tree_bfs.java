package chapter3.lesson02;

import java.util.Arrays;
import java.util.Scanner;

public class tree_bfs {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] q = new int[N];
    static int[] d = new int[N];
    static int n = 0;
    static int m = 0;
    static int idx = 0,hh = 0,tt = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        Arrays.fill(d,-1);
        d[0] = 0; d[1] = 0;
        q[++tt] = 1;
        n = scanner.nextInt(); m = scanner.nextInt();
        while (m-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(b,a);
        }
        System.out.println(bfs());
    }
    static int bfs(){
        while (hh <= tt){
            //错误
            int t = q[hh++];//先将队头取出来 然后出队
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (d[j] == -1){//如果没有被扩展过
                    q[++tt] = j;
                    d[j] = d[t] + 1;
                }
            }
        }
        return d[n];
    }
    static void add(int a,int b){
        e[idx] = a;
        ne[idx] = h[b];
        h[b] = idx++;
    }
}
