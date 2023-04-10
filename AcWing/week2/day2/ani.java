package AcWing.week2.day2;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ani {
    static int N = 50010;
    static int[] f = new int[N + 10];
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int cnt = 0;
        for (int i = 0; i <= n ; i++) {
            f[i] = i;
        }
        while (k-- > 0){
            int D = scanner.nextInt();
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            if (D == 1){
                if (X > n || Y > n) {//假话
                    cnt++;
                    continue;
                }
                f[find(X)] = find(Y);//真话
            }
            else if (D == 2){
                if (X > n || Y > n) {//假话
                    cnt++;
                    continue;
                }
                if (X == Y) {
                    cnt++;
                    continue;
                }
                if (find(X) == find(Y)){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static int find(int x){
        if (f[x] != x) f[x] = find(f[x]);
        return f[x];
    }
}
