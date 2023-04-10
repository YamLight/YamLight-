package chapter3.lesson02;

import java.util.Scanner;

public class DFS {
    static int N = 10;
    static int[] path = new int[N];
    static boolean[] use = new boolean[N];
    static int n = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0);
    }
    static void dfs(int x){
        if (x == n){//如果走到了n 就说明已经把数字填完了
            for (int j = 0; j < n; j++) {
                System.out.print(path[j]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <=n ; i++) {
            if (!use[i]) {//找到没有被用过的数字
                path[x] = i;//记录下来
                use[i] = true;//把这个数字改掉 表示已经用过了
                dfs(x + 1);//往深走一层
                use[i] = false;//恢复原样 表示刚才那个数字没有用过
            }
        }
    }
}
