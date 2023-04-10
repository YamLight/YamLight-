package chapter3.lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int m;
    static int N = 2010;
    static int M = 10010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] w = new int[M];
    static int idx = 0;
    static int[] dist = new int[N];//记录虚拟点到x的最短距离
    static int[] cnt = new int[N];//从虚拟点到x经过的边数
    static boolean[] st = new boolean[N];

    public static void add(int a,int b,int c)
    {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;

    }
    public static boolean spfa()
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        //将所有点进入队列
        for(int i = 1;i <= n;i++)
        {
            queue.add(i);
            st[i] = true;
        }
        while(!queue.isEmpty())
        {
            int t = queue.poll();
            st[t] = false;
            for(int i = h[t]; i != -1;i = ne[i])
            {
                int j = e[i];
                if(dist[j] > dist[t] + w[i])
                {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;

                    if(cnt[j] >= n) return true;
                    if(!st[j])
                    {
                        queue.add(j);
                        st[j] = true;
                    }


                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        Arrays.fill(h, -1);
        while(m -- > 0)
        {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            add(a,b,c);
        }
        if(spfa()) System.out.println("Yes");
        else System.out.println("No");
    }

}
