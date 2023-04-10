package AcWing.week4.day1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa_check {
    static int N = 500010;
    static int M = 2 * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] w = new int[N];
    static int[] ne = new int[M];
    static int[] cnt = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m,idx;
    static int max = 0x3f3f3f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
        if (spfa()) System.out.println("Yes");
        else System.out.println("No");
    }
    static boolean spfa(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            q.add(i);
            st[i] = true;
        }
        while (!q.isEmpty()){
            int t = q.poll();
            st[t] = false;
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return true;
                    if (!st[j]) {
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
