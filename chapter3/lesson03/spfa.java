package chapter3.lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa{
    static int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] h = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N]; //是否在队列中
    static int idx = 0;
    static int n = 0;
    static int m = 0;
    static int max = 0x3f3f3f;
    public static void main(String[] args) throws IOException {
        Arrays.fill(h, -1);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] cur = in.readLine().split(" ");
        n = Integer.parseInt(cur[0]);
        int m = Integer.parseInt(cur[1]);

        while(m-->0){
            String[] arr = in.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);

            add(a, b, c);
        }
        int t = spfa();
        if (dist[n] == max) System.out.println("impossible");
        else System.out.println(dist[n]);
    }
    static int spfa(){
        Arrays.fill(dist,max);
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        st[1] = true;
        while (!q.isEmpty()){
            int t = q.poll();
            //取出队头元素 并且删掉队头元素
            st[t] = false;
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                //错误
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if (!st[j]){
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

