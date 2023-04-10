package zhenti.p2019;

import java.math.BigInteger;

public class p3 {
    static int N = 20199000;
    static BigInteger[] f = new BigInteger[N];
    static BigInteger[] res = new BigInteger[4];
    public static void main(String[] args) {
        f[1] = f[2] = f[3] = BigInteger.valueOf(1);
        f[4] = BigInteger.valueOf(3);
        f[5] = BigInteger.valueOf(5);
        for (int i = 6; i <= 20190324 ; i++) {
            f[i] = f[i - 1].add(f[i - 2]).add(f[i - 3]).mod(BigInteger.valueOf(10000));
        }
        BigInteger tmp = f[20190324];
        BigInteger mod = BigInteger.TEN;
        System.out.println(tmp);
        for (int i = 3; i >= 0 ; i--) {
            res[i] = tmp.mod(mod);
            tmp = tmp.divide(mod);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(res[i]);
        }
    }
}
