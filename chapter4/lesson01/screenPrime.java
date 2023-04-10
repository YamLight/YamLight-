package chapter4.lesson01;

import java.util.Scanner;

public class screenPrime {
    static int N = 1000010;
    static boolean[] st = new boolean[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getPrime(n));
    }
    static int getPrime(int x){
        int cnt = 0;
        for (int i = 2; i <= x ; i++)
        {
            //如果是质数
            if (!st[i])
            {
                cnt++;
                //删掉所有质数的倍数
                for (int j = i + i; j <= x ; j += i)
                {
                    st[j] = true;
                }
            }
        }
        return cnt;
    }
}
