package AcWing.week2.day2;

import java.util.Scanner;

public class merge {
    static int N = 100010;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
        while (m --> 0){
            String opt = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (opt.equals("M")){
                if (find(a) != find(b)) f[find(a)] = find(b);
            }else {
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
    static int find(int x){
        if (f[x] != x) f[x] = find(f[x]);
        return f[x];
    }
}
