package AcWing.week1.day3;

import java.util.Scanner;

public class four {
    static int N = 5000010;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int a = 0; a <= n * n ; a++) {
            for (int b = a; a * a + b * b <= n ; b++) {
                for (int c = b; a * a + b * b + c * c <= n ; c++) {
                    int t = n - a * a - b * b - c * c;
                    int d = (int)Math.sqrt(t);
                    if (d * d == t){
                        System.out.print(a + " ");
                        System.out.print(b + " ");
                        System.out.print(c + " ");
                        System.out.println(d + " ");
                        return;
                    }
                }
            }
        }
    }
}
