package AcWing.week3.day2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class web {
    static int N = 1010;
    static int[] h = new int[N];
    static int[] u = new int[2 * N];
    static int[] ne = new int[2 * N];
    static int n,k,l,idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        l = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            k = scanner.nextInt();
            while (k-- > 0){
                int a = scanner.nextInt();
                add(a,i);
            }
        }
        int q = scanner.nextInt();
        while (q-- > 0){
            int num = scanner.nextInt();
            System.out.println(bfs(num));
        }
    }
    static int bfs(int num){
        boolean[] st = new boolean[N * 2];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,num));
        st[num] = true;
        int res = 0;
        while (!q.isEmpty()){
            pair t = q.poll();
            int flr = t.floor;
            int pot = t.point;
//            System.out.println(flr + " " + pot + " " + res);
            if (flr > l) break;
            for (int i = h[pot]; i != -1 ; i = ne[i]) {
                int j = u[i];
                if (st[j]) continue;
                if (flr + 1 <= l){
                    q.add(new pair(flr + 1,j));
                    st[j] = true;
                    res++;
                }
            }
        }
        return res;
    }
    static void add(int a,int b){
        u[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
class pair{
    int floor;
    int point;

    public pair(int floor, int point) {
        this.floor = floor;
        this.point = point;
    }
}
