package AcWing.week1.day2;

import java.util.Scanner;

public class bin {
    static int N = 100010;
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  n = scanner.nextInt();

    }
    static int find(int x){
        if (f[x] != x) return f[x] = find(find(x));
        return f[x];
    }
}
