### week6

### day1

01背包、完全背包

01背包代码

```Java
import java.util.Scanner;

public class dp01 {
    static int N = 1010;
    static int[][] dp = new int[N][N];
    static int[] v = new int[N];//体积
    static int[] w = new int[N];//价值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= c ; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[n][c]);
    }
}
```

01背包优化：

```Java
import java.util.Scanner;

public class Main {
    static int N = 1010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = m; j >= v[i] ; j--) {
                f[j] = Math.max(f[j],f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
```

完全背包代码：

```Java
import java.util.Scanner;

public class cdp {
    static int N = 2010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] dp = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            dp[0] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = v[i]; j <= m ; j++) {
                dp[j] = Math.max(dp[j],dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
```

**总结：01背包和完全背包优化后的状态转移方程相同 但是要注意的是**

**01背包是从大到小遍历 因为它的f[j - v[i]]是由i - 1层得来的 但维以后就是第i层得来的了 所以要从大到小更新**

![image-20230321203156556](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230321203156556.png)

**完全背包优化的时候我们从小到大更新是因为f[j - v[i]]是第i层得来的 那么降维以后也就不用担心更新的层数对不上了**



整数拆分：https://www.acwing.com/problem/content/3385/

这题其实我看出来它是一个完全背包问题 但是在细节的处理上还是太死板做题太少了

这题的状态转移方程可以直接就存方案数 f[0] = 1就代表0这个数只能拆分成0一种方案 

既然存的是方案数 也就不存在价值这个变量了 定论就是如果涉及到有限容积的问题 先定下就是背包问题 如果求种类数/方案数 那就不要价值 求最大值/最小值就要价值

不是背包问题那就不能硬套背包的模板

```Java
import java.util.Scanner;

public class Main {
	static int N = 21;
	static int M = (int)1e6 + 10;
	static int[] f = new int[M];
	static int mod = (int)1e9;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		f[0] = 1;
		for (int v = 1; v <= n; v *= 2) {
			for (int j = v; j <= n; j++) {
				f[j] = (f[j] + f[j - v]) % mod;
			}
		}
		System.out.println(f[n]);
	}
}
```

### day3

区间dp

石子合并：https://www.acwing.com/problem/content/284/

区间合并顾名思义就是从区间的角度来进行动态规划 f[i] [j]表示从i到j这个区间合并石子的最小代价
因为到最后一步的时候我们一定是把两堆石子合成一堆直接加上整个区间的代价就可以 所以我们就可以直接去看上一步的结果就是f[i,k] + f[k + 1,j] + s[r] - s[l - 1]  k就是i到j区间中的断点 左边合并完右边合并完最后一步合并

```Java
import java.util.Scanner;

public class stone {
    static int N = 310;
    static int[][] f = new int[N][N];
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            a[i] = scanner.nextInt();
        }
        s[0] = 0;
        for (int i = 1; i <= n ; i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i,r = i + len - 1;
                f[l][r] = (int)1e8;
                for (int k = l; k < r ; k++) {
                    f[l][r] = Math.min(f[l][r],f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
```

