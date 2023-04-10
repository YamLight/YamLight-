package chapter3.lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class heap_Dijkstra {
    static int N = 150010;
    static int[] h = new int[N];
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int idx = 0;
    static int n = 0;
    static int max = 0x3f3f3f;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        Arrays.fill(h, -1);
        while(m -- > 0)
        {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            add(a,b,c);
        }
        System.out.println(h_Dijkstra());
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static int h_Dijkstra(){
        PriorityQueue<PII> queue = new PriorityQueue<PII>();
        queue.add(new PII(0,1));
        Arrays.fill(dist,max);
        //漏掉
        dist[1] = 0;
        while (!queue.isEmpty()){
            PII t = queue.poll();//取出队头
            int num = t.getSecond();//取出点编号
            int distance = t.getFirst();//取出距离值
            //进行这样一个操作是因为 堆优化版的Dijkstra算法会有冗余的存在 所以需要再特殊判断一下
            if (st[num]) continue;
            st[num] = true;//
            for (int i = h[num]; i != -1 ; i = ne[i]) {//用t点更新其他边
                int j = e[i];
                //错误
//                if (dist[j] > distance + w[j]){
//                    dist[j] = distance + w[j];
//                    queue.add(new PII(dist[j],j));
//                }
                if (dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    queue.add(new PII(dist[j],j));
                }
            }
        }
        if (dist[n] == max) return -1;
        else return dist[n];
    }
}
class PII implements Comparable<PII>{
    int first;//距离值
    int second;//编号

    public PII(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }

    @Override
    public int compareTo(PII o) {
        return Integer.compare(first,o.first);
    }
}
