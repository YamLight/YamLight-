package zhenti.p2021;

import java.util.Arrays;

public class p4 {
    static int[] a = new int[4];
    static long N = 2021041820210418L;
    static long[] primes = new long[(int)1e6];
    static boolean[] st = new boolean[(int)1e6];
    static int cnt = 0;
    static int res = 0;
    public static void main(String[] args) {
        get_primes();
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                for (int k = 0; k < cnt; k++) {
                    if (primes[i] * primes[j] * primes[k] == N) res++;
                }
            }
        }
        System.out.println(res);
    }
    static void get_primes(){
        long num = (long)Math.sqrt(N);
        for (long i = 1; i <= num ; i++) {
            if (N % i == 0){
                primes[cnt++] = i;
                primes[cnt++] = N / i;
            }
        }
        Arrays.sort(primes,0,cnt);
    }
}
