package chapter3.lesson03;

import java.util.Scanner;

public class floyd {
    static int N = 210;
    static int n = 0;
    static int m = 0;
    static int[][] map = new int[N][N];
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int Q = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = max;
            }
        }
        while (m-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            map[a][b] = Math.min(map[a][b],c);
        }
        floyd();
        while (Q-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int res = map[a][b];
            if (res > max / 2) System.out.println("impossible");
            else System.out.println(res);
        }
    }
    static void floyd(){
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    map[i][j] = Math.min(map[i][j],map[i][k] + map[k][j]);
                }
            }
        }
    }
}
