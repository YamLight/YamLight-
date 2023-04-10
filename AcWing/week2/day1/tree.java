package AcWing.week2.day1;

import java.util.Scanner;

public class tree {
    static int N = 40;
    static int[][] son = new int[N][N];
    static int[] a1 = new int[N];
    static int[] a2 = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a2[i] = scanner.nextInt();
        }
    }
}
