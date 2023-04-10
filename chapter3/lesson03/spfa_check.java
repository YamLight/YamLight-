package chapter3.lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa_check {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static int[] cnt = new int[N];
    static boolean[] st = new boolean[N];
    static int idx = 0;
    static int n = 0;
    static int m = 0;
    static int max = 0x3f3f3f;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while (m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }

        if (spfa()) System.out.println("Yes");
        else System.out.println("No");
    }

    static boolean spfa() {
//        Arrays.fill(dist, max);
//        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            st[i] = true;
            q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            //错误
            st[t] = false;
            //遍历所有t的出边
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                //错误
                if (dist[j] > dist[t] + w[i])
                {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return true;
                    if (!st[j])
                    {
                        q.add(j);
                        st[t] = true;
                    }
                }
            }
        }
        return false;
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
