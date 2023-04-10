package 蓝桥杯辅导课.chapter1.BFS;

import java.util.Scanner;

public class 交换瓶子 {
    static int[] a = new int[10010];
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            if (a[i] != i){
                for (int j = i + 1; j <= n ; j++) {
                    if (a[j] == i){
                        int t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
//        for (int i = 1; i <= n ; i++) {
//            System.out.print(a[i] + " ");
//        }
    }
}
