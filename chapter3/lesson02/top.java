package chapter3.lesson02;

import java.util.Arrays;
import java.util.Scanner;

public class top {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] q = new int[N];
    static int[] d = new int[N];
    static int idx = 0;
    static int n = 0;
    static int hh = 0, tt = -1;

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        while (m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a, b);
            d[b]++;
        }
        if (topsort()) {
            for (int i = 0; i < n; i++) {
                System.out.print(q[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    static boolean topsort() {
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }
        return tt == n - 1;
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
