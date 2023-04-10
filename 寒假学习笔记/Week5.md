### Week5

#### day1

筛质数：https://www.acwing.com/problem/content/870/

```Java
import java.util.Scanner;

public class line {
    static int N = 100010;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        boolean[] st = new boolean[N];
        int[] primes = new int[N];
        for (int i = 2; i <= n ; i++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; primes[j] <= n / i ; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
        System.out.println(cnt);
    }
}
```

#### day2

最大公约数：https://www.acwing.com/problem/content/874/

```Java
import java.util.Scanner;

public class gcd {
    static int N = 10010;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(gcd(a,b));
        }
    }
    static int gcd(int a,int b){
        return b > 0 ? gcd(a,a % b) : a;
    }
}
```

#### day3

快速幂

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0){
            int a = scanner.nextInt();
            int k = scanner.nextInt();
            int p = scanner.nextInt();
            System.out.println(qmi(a,k,p));
        }
    }
    static long qmi(long a,long k,long p){
        long res = 1;
        while (k != 0){
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}

```

#### day4

求组合数1 ： 

组合数的递推公式：![image-20230319170022257](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230319170022257.png)

这里为什么不会越界呢？因为i == 0 的时候 j也只能等于0 j <= i是因为ab可以相等 

```Java
import java.util.Scanner;

public class col1 {
    static int N = 2010;
    static int[][] c = new int[N][N];
    static int mod = (int)1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init();
        int n = scanner.nextInt();
        while (n-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(c[a][b]);
        }
    }
    static void init(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) c[i][j] = 1;
                else c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
            }
        }
    }
}
```

吃水果：https://www.acwing.com/problem/content/4499/

动态规划时间复杂度可以减小的原因是因为它每个集合的划分都代表了一类情况而不是一种情况

像需要取模的这类题 最好开一个long数组防止爆掉

状态划分不能过于死板 它是依靠不同的性质来划分的 首要原则就是不重不漏 如果按照一种思想去分出来一种集合 得到的结果还需要继续去细分 那么就该换一个

![QQ截图20230316162212.png](https://cdn.acwing.com/media/article/image/2023/03/16/61195_ab8b00abc3-QQ%E6%88%AA%E5%9B%BE20230316162212.png)

```java
import java.util.Scanner;

public class fruit {
    static int N = 2010;
    static long[][] c = new long[N][N];
    static int mod = 998244353;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= k ; i++) {
            c[1][i] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            c[i][0] = m;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= k && j < i; j++) {
                if (j == 0) c[i][j] = m;
                else c[i][j] = (c[i - 1][j - 1] * (m - 1) % mod + c[i - 1][j]) % mod;
            }
        }
        System.out.println(c[n][k]);
    }
}
```

