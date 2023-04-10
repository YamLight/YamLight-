package AcWing.week2.day4;

import java.util.Scanner;

public class slipWindow {
    static int N = 100010;
    static int[] a = new int[N];
    static int INF = (int)1e9;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - k + 1 ; i++) {
            int max = -INF;
            for (int j = i;j - i + 1 <= 3 ; j++) {
                max = Math.max(max,a[j]);
            }
            System.out.print(max + " ");
        }
        System.out.println();
        for (int i = 0; i < n - k + 1 ; i++) {
            int min = INF;
            for (int j = i;j - i + 1 <= 3 ; j++) {
                min = Math.min(min,a[j]);
            }
            System.out.print(min + " ");
        }
    }
}
