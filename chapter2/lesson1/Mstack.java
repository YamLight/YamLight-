package chapter2.lesson1;

import java.util.Scanner;

public class Mstack {
    private static int N = 100010;
    private static int[] stk = new int[N];
    private static int tt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int x = scanner.nextInt();
            while (tt>0&&stk[tt]>=x) tt--;//核心代码
            //思想就是如果新输入的这个数 比栈顶元素小(因为是新输入所以保证了下标是当前最大的)那么就把栈顶元素弹出直到找到一个
            //比新输入元素小的元素 然后再把这个数字入栈 这样得到的栈就是一个线性的单调栈
            if (tt>0) System.out.print(stk[tt]+ " ");
            else System.out.print("-1 ");
            stk[++tt] = x;
        }
    }
}
