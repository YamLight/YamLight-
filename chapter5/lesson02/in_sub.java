package chapter5.lesson02;

import java.util.Scanner;

public class in_sub {
    static int N  = 1010;
    static int[] f = new int[N];
    static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //首先循环读入数组
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            f[i] = 1;//这里的f[i] = 1意思就是如果这组只有一个元素那么长度就是 1
            for (int j = 1; j < i; j++) {
             //状态划分的时候 我们可以直接用一维划
             //f[i]存以第i个数为结尾的上升子序列长度 然后我们取一个max就可以了
             //以第i个字母结尾 这是确定的 所以我们可以通过f[j]来求得f[i]
             //那就是 如果a[j] < a[i] 那就取一个max 这也是有一个迭代的思想
                if (a[j] < a[i]){
                    f[i] = Math.max(f[i],f[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1 ; i <= n ; i++) {
            res = Math.max(res,f[i]);
        }
        System.out.println(res);
    }
}
