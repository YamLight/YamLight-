package AcWing.week2.day4;

import java.util.Scanner;

public class Mstack {
    static int N = 50010;
    static int[] stk = new int[N];
    static int tt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0){
            int x = scanner.nextInt();
            while (tt > 0 && stk[tt] >= x) tt--;
            if (tt > 0) System.out.print(stk[tt] + " ");
            else System.out.print("-1 ");
            stk[++tt] = x;
        }
    }
}
