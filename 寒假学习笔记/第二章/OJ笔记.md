1. 滑动窗口(本题是用单调队列维护的一个滑动窗口)
   单调栈、单调队列和双指针的共同思路就是先考虑暴力的做法，然后再由性质找出单调性，把没用的元素删掉来降低时间复杂度
   这个优化过的队列也不是经典的朴素队列，它更像是一个双向队列(队尾队首都可以弹出元素)

   ```java
   import java.util.Scanner;
   
   public class Mqueue {
       private static int N = 100010;
       private static int[] a = new int[N];
       private static int[] q = new int[N];
       private static int k = 0;
   
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           int hh = 0, tt = -1;
           int n = scanner.nextInt();
           k = scanner.nextInt();
           for (int i = 0; i < n; i++) {
               a[i] = scanner.nextInt();
           }
           for (int i = 0; i < n; i++) {
               //先判断这个单调队列是否为空 还有当前队头是否已经出队(队列长度大于k)
               //这里的i-k+1意义就是起点
               if (hh <= tt && i - k + 1 > q[hh]) hh++;
               //判断单调队列是否为空   如果存在逆序对就出队列
               while (hh <= tt && a[q[tt]] >= a[i]) tt--;
               //把这个元素入队
               q[++tt] = i;
               //特殊判断一下 如果队列里面元素数量不够就不用输出了
               //为什么是输出的a[q[hh]]而不是a[q[tt]]因为上面的while循环判断完 每个窗口最小的元素应该在hh位置
               if (i >= k - 1) System.out.print(a[q[hh]] + " ");
           }
           System.out.println();
           hh = 0;
           tt = -1;
           for (int i = 0; i < n; i++) {
               if (hh <= tt && i - k + 1 > q[hh]) hh++;
               while (hh <= tt && a[q[tt]] <= a[i]) tt--;
               q[++tt] = i;
               if (i >= k - 1) System.out.print(a[q[hh]] + " ");
           }
       }
   }
   ```

   