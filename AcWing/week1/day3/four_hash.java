package AcWing.week1.day3;

import java.util.HashMap;
import java.util.Scanner;

public class four_hash {
    static int N = 5000010;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, int[]> sum = new HashMap<>();
        int n = scanner.nextInt();
        for (int c = 0; c * c <= n; c++) {
            for (int d = c; c * c + d * d <= n; d++) {
                int t = c * c + d * d;
                if (!sum.containsKey(t)) sum.put(t, new int[]{c, d});
            }
        }
        for (int a = 0; a * a <= n ; a++) {
            for (int b = a; a * a + b * b <= n ; b++) {
                int t = n - a * a - b * b;
                if (sum.containsKey(t)){
                    int[] s = sum.get(t);
                    System.out.print(a+" ");
                    System.out.print(b+" ");
                    System.out.print(s[0]+" ");
                    System.out.println(s[1]+" ");
                    return;
                }
            }
        }
    }
}

