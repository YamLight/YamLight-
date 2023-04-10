package chapter4.lesson01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DivisorSum {
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) {
            int x = scanner.nextInt();
            for (int i = 2; i <= x / i; i++) {
                if (x % i == 0) {
                    x /= i;
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
            if (x > 1) map.put(x, map.getOrDefault(x, 0) + 1);
        }
        long res = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            long t = 1;
            int a = entry.getKey();//底数
            int b = entry.getValue();//指数
            while (b-- > 0) t = (t * a + 1) % mod;
            res = (res * t) % mod;
        }
        System.out.println(res);
    }
}
