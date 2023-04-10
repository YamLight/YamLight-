package chapter5.lesson01;

import java.util.Scanner;

public class mdp_pro {
    static int N = 25000;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int cnt = 0; //cnt代表组别
        while (n-->0){
            int a = scanner.nextInt();//体积
            int b = scanner.nextInt();//价值
            int s = scanner.nextInt();//数量
            int k = 1;   //k代表这个组中有几个物品
            while (k <= s){
                cnt++;
                v[cnt] = a * k;
                w[cnt] = b * k;
                s -= k;
                k *= 2;
            }
            if (s > 0){
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }
        n = cnt;
        for (int i = 1; i <= n ; i++) {
            for (int j = m; j >= v[i] ; j--) {
                f[j] = Math.max(f[j],f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
