package sub;

import java.util.Scanner;

public class a2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bx = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int by = scanner.nextInt();
        int[] y = new int[n];
        for (int i = 0; i < m; i++) {
            y[i] = scanner.nextInt();
        }
        long res1 = 0,res2 = 0;
        for (int i = 0; i < n; i++) {
            res1 += x[i] * Math.pow(bx,n - i - 1);
        }
        for (int i = 0; i < m; i++) {
            res2 += y[i] * Math.pow(by,m - i - 1);
        }

        if (res1 == res2) System.out.println("=");
        else if (res1 > res2) System.out.println(">");
        else System.out.println("<");
    }
}
