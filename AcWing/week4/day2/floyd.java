package AcWing.week4.day2;

import java.util.Arrays;
import java.util.Scanner;

public class floyd {
    static int N = 210;
    static int[][] d = new int[N][N];
    static int n,m,k;
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(d,max);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = max;
            }
        }
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            d[a][b] = Math.min(d[a][b],c);
        }
        floyd();
        while (k-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (d[a][b] > max / 2) System.out.println("impossible");
            else System.out.println(d[a][b]);
        }
    }
    static void floyd(){
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    d[i][j] = Math.min(d[i][j],d[i][k] + d[k][j]);
                }
            }
        }
    }
}
