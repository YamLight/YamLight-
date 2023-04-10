package chapter3.lesson04;

import java.util.Arrays;
import java.util.Scanner;

public class Hun {
    static int N = 510;
    static int M = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];
    static int idx = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int m = scanner.nextInt();
        Arrays.fill(h,-1);
        while (m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
        }
        int res = 0;
        for (int i = 1; i <= n1 ; i++) {
            Arrays.fill(st,false);
            if (find(i)) res++;
        }
        System.out.println(res);
    }

    static boolean find(int x) {
        for (int i = h[x]; i != -1; i = ne[i]) {//遍历心仪的女孩儿
            int j = e[i];
            if (!st[j]) {//如果这个女孩儿没有被考虑过
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    st[j] = true;
                    return true;
                }
            }
        }
        return false;
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
