### Week1

##### day1. 

1. K倍区间

   ```Java
   import java.util.Scanner;
   
   public class K_pro {
       static int N = 100010;
       static int[] a = new int[N];
       static long[] s = new long[N];
       static long[] cnt = new long[2 * N];
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           int n = scanner.nextInt();
           int k = scanner.nextInt();
           for (int i = 1; i <= n ; i++) {
               a[i] = scanner.nextInt();
           }
           for (int i = 1; i <= n ; i++) {
               s[i] = s[i - 1] + a[i];
           }
           long res = 0;
           //我们cnt[0]中存的是s[]中等于0的数的个数，由于s[0] = 0，所以最初等于0的有1个数，所以cnt[0] = 1。
           cnt[0]++;
           for (int i = 1; i <= n ; i++) {
               int num = (int)(s[i] % k);
               res += cnt[num];
               cnt[num] ++;
           }
   //首先明确 res[sum[i]] 表示的是sum[i]出现过的次数。
   //举个例子，假设 sum[i] = 3，在后边的循环中，又出现了一个 sum[i] = 3，那么此时，这个“3”可以和前边出现过的所有的“3”分别构成一个K倍区间，前边的“3”一共出现过res[sum[i]] 次，所以 此时又新增了res[sum[i]]个K倍区间。
           System.out.println(res);
       }
   }
   ```

##### day3.

1. 二分
   为什么第一个模板找到的是左边界 第二个模板找到的是右边界
   ![数的范围.png](https://cdn.acwing.com/media/article/image/2022/03/19/163130_7260572ca7-%E6%95%B0%E7%9A%84%E8%8C%83%E5%9B%B4.png)
   ![img](https://img-blog.csdnimg.cn/5d7e3fd2c54745c58cd13e49ffa91ef7.png)

   当a[mid]≥x的时候 mid此时此刻可能在右边界处 也可能在子区间里面 所以要动一下r 来缩小范围确定起点
   当a[mid]≤x的时候 mid此时可能在左边界处 也可能在子区间 那么我们就要动一下l来缩小范围确定终点

##### day5

递推

```
小明正在玩一个“翻硬币”的游戏。

桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。

比如，可能情形是：**oo***oooo

如果同时翻转左边的两个硬币，则变为：oooo***oooo

现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,那么对特定的局面，最少要翻动多少次呢？

我们约定：把翻动相邻的两个硬币叫做一步操作。
```

```
n 个砖块排成一排，从左到右编号依次为 1∼n。

每个砖块要么是黑色的，要么是白色的。

现在你可以进行以下操作若干次（可以是 0 次）：

选择两个相邻的砖块，反转它们的颜色。（黑变白，白变黑）

你的目标是通过不超过 3n 次操作，将所有砖块的颜色变得一致。
```

诸如这类的题 其实就可以直接来枚举结果 一个操作可以影响两个字符 那么我们要做的就是这次的操作是否要选择 选择的标准就是是否和结果串匹配 

从第一个字符开始比较 如果一样就不变 如果不一样就要变 **换言之第一个字符是可以影响后边所有字符的操作选择的** **所以这题选择递推的思想**

### Week2

##### day1.

![image-20230304100735757](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230304100735757.png)

```JAVA
import java.util.HashSet;
import java.util.Scanner;

public class cow {
    static HashSet set = new HashSet<Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a1 = scanner.next().toCharArray();//二进制数
        char[] a2 = scanner.next().toCharArray();//三进制数
        for (int i = 0; i < a1.length; i++) {
            a1[i] ^= 1;
            set.add(get(a1,2));
            a1[i] ^= 1;
        }
        for (int i = 0; i < a2.length; i++) {
            char tmp = a2[i];
            for (char j = '0'; j <= '2' ; j++) {
                if (tmp != j){
                    a2[i] = j;
                    int x = get(a2,3);
                    if (set.contains(x)){
                        System.out.println(x);
                        return;
                    }
                }
            }
            a2[i] = tmp;
        }
    }
    static int get(char[] c,int k){
        int res = 0;
        //秦九邵算法
        for (int i = 0; i < c.length ; i++) {
            res = res * k + (c[i] - '0');
            //错误
//            res += (c[i] * k) + (c[i + 1] - '0');
        }
        return res;
    }
}
```

**注意这里的秦九邵算法 它是如何把每一个字符转化为数字的**

**还有 a1[i] ^= 1; 这个算法就是按位取反的 加深一下记忆 以后会经常用到**





![image-20230305192600310](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230305192600310.png)

