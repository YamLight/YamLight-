package AcWing.week1.day2;

import java.util.Arrays;
import java.util.Scanner;

public class ele_change {
    static int N = 200010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] V = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//几组数组
        for (int i = 1; i <= n ; i++) {
            int m = scanner.nextInt();//一个数组里有几个元素
            int tt = 0;
            while (m-- > 0){
                int num = scanner.nextInt();//数组中的元素
                V[++tt] = 0;//tt指针严格指向数组当前最后一个元素
                if (num == 0) continue;
                else if (num >= tt) Arrays.fill(V,1,tt + 1,1);
                else Arrays.fill(V,tt - num + 1,tt + 1,1);
            }
            for (int j = 1; j <= tt ; j++) {
                System.out.print(V[j] + " ");
            }
            System.out.println();
            Arrays.fill(V,1,tt + 1,0);
        }
    }
}
