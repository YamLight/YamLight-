package AcWing.week4.day5;

import java.util.Arrays;
import java.util.Scanner;

public class xyl {
    static int N = 510;
    static int M = 100010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] match = new int[N * N];
    static boolean[] st = new boolean[N];
    static int n1,n2,m,idx;
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        m = scanner.nextInt();
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
        }
        for (int i = 1; i <= n1 ; i++) {
            Arrays.fill(st,false);
            if (find(i)) res++;
        }
        System.out.println(res);
    }
    static boolean find(int x){
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]){
                if (match[j] == 0 || find(match[j])){
                    match[j] = x;
                    st[j] = true;
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
