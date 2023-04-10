package chapter3.lesson01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ohash {
    static int N = 200010;
    static int[] h = new int[N];
    static int nulls = 0x3f3f3f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,0x3f3f3f);
        int n = scanner.nextInt();
        while (n-->0){
            String opt = scanner.next();
            int x = scanner.nextInt();
            int k = find(x);
            if (opt.equals("I")){
                h[k] = x;
            }else {
                if (h[k] != nulls) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
    static int find(int x){
        int k = (x % N + N) % N;
        while (h[k] != nulls && h[k] != x){
            k++;
            if (k == N) k = 0;
        }
        return k; //如果找到了就返回下标 没找到就返回x应该存储的位置
    }
}
