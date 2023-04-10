package chapter4.lesson01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class divisorNum {
    static long mod = (long)1e9 + 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        while (n-->0){
            int x = scanner.nextInt();
            for (int i = 2; i <= x / i ; i++) {
                while (x % i == 0){
                    x /= i;
                    map.put(i,map.getOrDefault(i,0) + 1);
                }
            }
            if (x > 1) map.put(x,map.getOrDefault(x,0) + 1);
        }
        long res = 1;
        for (int i: map.values()
        ) {
            res = res * (i + 1) % mod;
        }
        System.out.println(res);
    }
}
