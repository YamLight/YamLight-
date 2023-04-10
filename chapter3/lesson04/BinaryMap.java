package chapter3.lesson04;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryMap {
    static int N = 100010;
    static int M = 200020;
    static int[] e = new int[N];
    static int[] ne = new int[M];
    static int[] h = new int[N];
    static int[] color = new int[N];
    static int n = 0;
    static int m = 0;
    static int idx = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        Arrays.fill(h,0,n + 1,-1);
        while (m-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);  add(b,a);
        }
        boolean flag = true;
        for (int i = 1; i <= n ; i++) {
            //color[i] == 0 才表示没有染过色
            if (color[i] == 0)
            {
                if (! dfs(i,1))
                {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) System.out.println("Yes");
        else System.out.println("No");
    }
    static boolean dfs(int k,int u){
        color[k] = u;//第k号结点染了u色
        for (int i = h[k]; i != -1 ; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0){//如果j号点没有染色
                if (!dfs(j,3 - u)) return false;//那就给j号点染色
            }
            //错误
            else if (color[j] == u) return false;
        }
        return true;
    }
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}