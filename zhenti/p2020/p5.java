package zhenti.p2020;

import java.math.BigInteger;

public class p5 {
    static BigInteger[] f = new BigInteger[2030];
    public static void main(String[] args) {
        f[1] = f[2] = BigInteger.valueOf(1);
        for (int i = 3; i <= 2020 ; i++) {
            f[i] = f[i - 1].add(f[i - 2]);
        }
        System.out.println(f[2020].gcd(f[520]));
    }
    static int gcd(int a,int b){
        return b > 0 ? gcd(b,a % b) : a;
    }
}
