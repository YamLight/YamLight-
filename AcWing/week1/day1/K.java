package AcWing.week1.day1;

import java.util.Scanner;

public class K {
    static int N = 1000010;
    static int[] s = new int[N];
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        s[0] = 0;
        for (int i = 1; i <= n ; i++) {//初始化前缀和数组
            s[i] = s[i - 1] + a[i];
        }
        int sum = 0;//k倍区间的方案
        for (int i = 1; i <= n ; i++) {//枚举起点
            for (int j = i; j <= n ; j++) {//枚举终点
                int num = s[j] - s[i - 1];
                if (num % k == 0) sum++;

            }
        }
        System.out.println(sum);
    }
}
