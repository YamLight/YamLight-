package chapter3.lesson01;

import java.util.Arrays;
import java.util.Scanner;

public class hash_open {
    static int N = 200003;
    static int[] h = new int[N];
    static int nulls = 0x3f3f3f;
    public static void main(String[] args) {
        Arrays.fill(h,nulls);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            String opt = scanner.next();
            int x =scanner.nextInt();
            int k = find(x);
            if (opt.equals("I")) h[k] = x;
            else  {
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
        return k;
    }
}
