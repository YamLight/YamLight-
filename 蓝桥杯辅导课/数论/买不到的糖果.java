package 蓝桥杯辅导课.数论;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 买不到的糖果 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<pii> q = new LinkedList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int num = n * 4 + m * 7;
        int[] a = new int[num + 10];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                a[i * 4 + j + 7]++;
            }
        }
        for (int i = num; i > 0 ; i--) {
            if (a[i] == 0) System.out.println(i);
            return;
        }
    }
}
class pii{
    int x;
    int y;

    public pii(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
