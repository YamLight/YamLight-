package zhenti.p2020;

import java.math.BigInteger;
import java.util.Scanner;

public class p7 {
    static BigInteger mod = BigInteger.valueOf(123456789);
    static int n = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        BigInteger res = BigInteger.ZERO;
        for (int i = 1; i <= n ; i++) {
            BigInteger tmp = BigInteger.valueOf(i).pow(8);
            res = res.add(tmp).mod(mod);
        }
        System.out.println(res);
    }
}
