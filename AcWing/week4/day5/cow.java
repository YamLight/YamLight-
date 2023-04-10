package AcWing.week4.day5;

import java.util.Arrays;
import java.util.Scanner;

public class cow {
    static int N = 210;
    static int M = N * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static boolean[] st = new boolean[N];
    static int[] match = new int[N];
    static int n,m,idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            int k = scanner.nextInt();
            while (k-- > 0){
                int a = scanner.nextInt();
                add(i,a);
            }
        }
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            Arrays.fill(st,false);
            if (find(i)) res++;
        }
        System.out.println(res);
    }
    static boolean find(int x){
        for (int i = h[x]; i != -1 ; i = ne[i]) {
            int j = e[i];
            if (!st[j]){
                st[j] = true;
                if (match[j] == 0 || find(match[j])){
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
