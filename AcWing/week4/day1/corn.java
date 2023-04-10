package AcWing.week4.day1;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class corn {
    static int N = 2010;
    static int M = 200010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static int[] target = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m,k,t,idx;
    static int max = 0x3f3f3f;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);//种子总数
        m = Integer.parseInt(s1[1]);//初始拥有种子数量
        k = Integer.parseInt(s1[2]);//杂交方案
        t = Integer.parseInt(s1[3]);//目标种子
        Arrays.fill(h,-1);
        Arrays.fill(dist,max);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n ; i++) {
            w[i + 1] = Integer.parseInt(s2[i]);
        }
        String[] s3 = br.readLine().split(" ");
        for (int i = 0; i < m ; i++) {
            int x = Integer.parseInt(s3[i]);
            dist[x] = 0;
            q.add(x);
            st[x] = true;
            }
        for (int i = 1; i <= k ; i++) {
            String[] s4 = br.readLine().split(" ");
            int a = Integer.parseInt(s4[0]);
            int b = Integer.parseInt(s4[1]);
            int c = Integer.parseInt(s4[2]);
            add(a,b,c); add(b,a,c);
        }
        spfa();
        out.println(dist[t]);
        out.flush();
    }
    static void spfa(){
        while (q.size() > 0){
            int t = q.poll();
            st[t] = false;
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i]; int z = target[i];
                if (dist[z] > Math.max(dist[j],dist[t]) + Math.max(w[t],w[j])){
                    dist[z] = Math.max(dist[j],dist[t]) + Math.max(w[t],w[j]);
                }
                if (!st[z]){
                    q.add(z);
                    st[z] = true;
                }
            }
        }
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        target[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
