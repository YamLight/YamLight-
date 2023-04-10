package chapter3.lesson02;

import java.util.Arrays;
import java.util.Scanner;

public class tree_dfs {
    static int N = 100010;
    static int n = 0;
    static int[] h = new int[N];
    static int[] e = new int[N * 2];
    static int[] ne = new int[N * 2];
    static boolean[] st = new boolean[N];
    static int ans = N;
    static int idx = 1;
    //难点
    static int dfs(int u) { //几号结点
        st[u] = true;//表示结点被遍历过了
        int sum = 0, size = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {//遍历这条链
            int j = e[i];
            if (st[j]) continue;//如果被遍历过那就执行下一次循环
            int s = dfs(j); //递归寻找以j为重心的最大连通子图节点数
            size = Math.max(size, s); //然后比较 取最大的
            sum += s;//以u的孩子为根节点的子树 也是以u为根节点的字数的一部分 所以要加进去
        }
        size = Math.max(size, n - sum - 1);//删掉u结点之后 求最大连通图节点数
        ans = Math.min(ans, size); // 连通块中的最大值最小
        return sum + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Arrays.fill(h,-1);
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        System.out.println(ans);
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
