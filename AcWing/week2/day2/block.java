package AcWing.week2.day2;

import java.util.Scanner;

public class block {
    static int N = 100010;
    static int[] f = new int[N];
    static int[] cnt = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            f[i] = i;
            cnt[i] = 1;
        }
        while (m-- > 0){
            String opt = scanner.next();
            if (opt.equals("C")){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (find(a) != find(b)) {
                    int tmp1 = cnt[find(a)];
                    int tmp2 = cnt[find(b)];
                    cnt[find(b)] += tmp1;
                    cnt[find(a)] += tmp2;
                    f[find(a)] = find(b);
                }
            } else if (opt.equals("Q1")) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }else {
                int a = scanner.nextInt();
                System.out.println(cnt[find(a)]);
            }
        }
    }
    static int find(int x){
        if (f[x] != x) f[x] = find(f[x]);
        return f[x];
    }
}
