package AcWing.week4.day5;

import java.util.Arrays;
import java.util.Scanner;

public class ranse {
    static int N = 100010;
    static int[] e = new int[N];
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] color = new int[N];
    static int n,m,idx;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b); add(b,a);
        }
        boolean flag = true;
        for (int i = 1; i <= n ; i++) {
            if (color[i] == 0){
                if (!dfs(i,1)){
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) System.out.println("Yes");
        else System.out.println("No");
    }
    static boolean dfs(int k,int x){
        color[k] = x;
        for (int i = h[k]; i != -1 ; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0){//代表可以染色
                if (!dfs(j,3 - x)) return false;
            }
            if (color[j] == x) return false;
        }
        return true;
    }
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
