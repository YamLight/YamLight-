package AcWing.week5.day4;

import java.util.Scanner;

public class col1 {
    static int N = 2010;
    static int[][] c = new int[N][N];
    static int mod = (int)1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init();
        int n = scanner.nextInt();
        while (n-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(c[a][b]);
        }
    }
    static void init(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) c[i][j] = 1;
                else c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
            }
        }
    }
}
