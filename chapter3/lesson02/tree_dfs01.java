package chapter3.lesson02;

import java.util.Arrays;
import java.util.Scanner;

public class tree_dfs01 {
    static int N = 100010, M = N * 2;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static boolean[] st = new boolean[N];
    static int idx,n;
    static int ans = N;//    最大值中的最小值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b); add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
    static void add(int a,int b){//把 a 插到 b结点中
        e[idx] = a;
        ne[idx] = h[b];
        h[b] = idx++;
    }
    static int dfs(int u){
        st[u] = true;
        //sum 是 以u为根节点的这棵树的总节点数
        //size 是找去掉重心以后的最大连通字数节点数
        int sum = 1, size = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            //错误
            int j = e[i];
            if (st[j]) continue;
            int s = dfs(j);
            size = Math.max(size,s);
            sum += s;
        }
        size = Math.max(size,n - sum);//以u为重心 去掉u结点以后 找一个最大连通图子树节点数
        ans = Math.min(ans,size);
        return sum;
    }
}
