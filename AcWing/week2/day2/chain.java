package AcWing.week2.day2;

import java.util.Scanner;

public class chain {
    static int N = 500010;
    static int[] f = new int[N];
    static int[] d = new int[N];
    static int n = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            f[i] = i;
        }
        int res = 0;
        while (k-- > 0){
            int T = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x > n || y > n) res++;
            int fx = find(x), fy = find(y);
            if (T == 1){//x y是同类
                if (fx == fy && (d[x] - d[y]) % 3 != 0) res++;//如果说他们是同类 但是余数不相同
                else if (fx != fy){
                    f[fx] = fy;
                    d[fx] = d[y] - d[x];
                }
            }else {//x 吃 y
                if (fx == fy && (d[x] - d[y] - 1) % 3 != 0) res++;
                else if (fx != fy){
                    f[fx] = fy;
                    d[fx] = d[y] - d[x] + 1;
                }
            }
        }
        System.out.println(res);
    }
    static int find(int x){
        if (f[x] != x){
            int u = find(f[x]);
            d[x] += d[f[x]];
            f[x] = u;
        }
        return f[x];
    }
}
