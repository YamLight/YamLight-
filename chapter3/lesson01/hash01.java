package chapter3.lesson01;

import java.util.Arrays;
import java.util.Scanner;

public class hash01 {
    static int N = 100003;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx = 0;
    public static void main(String[] args) {
        Arrays.fill(h,-1);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            String opt = scanner.next();
            if (opt.equals("I")){
                int x = scanner.nextInt();
                insert(x);
            }else {
                int x = scanner.nextInt();
                if (find(x)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
    static void insert(int x){
        int k = (x % N + N) % N;
        idx++;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx;
    }
    static boolean find (int x){
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1 ; i = ne[i]) {
            if (x == e[i]) return true;
        }
        return false;
    }
}
