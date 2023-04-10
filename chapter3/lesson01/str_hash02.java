package chapter3.lesson01;

import java.util.Scanner;

public class str_hash02 {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] p = new int[N];
    static int P = 131;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String str = scanner.next();
        char[] chars = str.toCharArray();
        p[0] = 1; h[0] = 0;
        //核心代码
        for (int i = 1; i <= n ; i++) {
            h[i] = h[i - 1] * P +chars[i - 1];
            p[i] = p[i - 1] * P;
        }
        while (m-->0){
            int l1,r1,l2,r2;
            l1 = scanner.nextInt();
            r1 = scanner.nextInt();
            l2 = scanner.nextInt();
            r2 = scanner.nextInt();
            if (get(l1,r1) == get(l2,r2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
    static int get(int l,int r){
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
