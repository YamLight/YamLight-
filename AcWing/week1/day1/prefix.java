package AcWing.week1.day1;

import java.util.Scanner;

public class prefix {
    static int N = 100010;
    static int[] s = new int[N];
    static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {//初始化前缀和
            s[i] = s[i - 1] + a[i];
        }
        while (q-- > 0){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
