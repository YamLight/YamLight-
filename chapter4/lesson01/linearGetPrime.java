package chapter4.lesson01;

import java.util.Scanner;

public class linearGetPrime {
    static int N = 100010;
    static boolean[] st = new boolean[N];
    static int[] prime = new int[N];
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        getPrime(n);
        System.out.println(cnt);
    }
    static void getPrime(int x){
        //枚举所有数
        for (int i = 2; i <= x ; i++) {
            //如果是质数那就存下来
            if (!st[i]) prime[cnt++] = i;
            //枚举所有质数
            for (int j = 0; prime[j] <= x / i ; j++) {
                //由于prime是从小到大枚举的所以这个prime[j] 一定是prime[j] * i的最小质因子
                st[prime[j] * i] = true;
                //当i%primes[j]!=0时,说明此时遍历到的primes[j]不是i的质因子，那么只可能是此时的primes[j]<i的
                //最小质因子,所以primes[j]*i的最小质因子就是primes[j];
                //当有i%primes[j]==0时,说明i的最小质因子是primes[j],
                //因此primes[j]*i的最小质因子也就应该是prime[j]
                //之后接着用st[primes[j+1]*i]=true去筛合数时，就不是用最小质因子去更新了,
                //因为i有最小质因子primes[j]<primes[j+1],
                //此时的primes[j+1]不是primes[j+1]*i的最小质因子
                //此时就应该退出循环，避免之后重复进行筛选。
                if (i % prime[j] == 0) break;
            }
        }
    }
}
