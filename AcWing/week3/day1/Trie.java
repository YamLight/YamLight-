package AcWing.week3.day1;

import java.util.Scanner;

public class Trie {
    static int N = 100010;
    static int[][] son = new int[30][30];
    static int[] cnt = new int[N];
    static int idx = 1;
    //为什么我们用到了idx这个变量 这个就像我们把这个二维数组的每一块拿出来当成了一个链表
    //有了idx这个变量我们就可以保证每一个结点都是唯一的 就可以放心的串成一个链了
    //不用担心上一个结点应该链接下一个字母是a 但是链接到别的串中的a上
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0){
            String opt = scanner.next();
            if (opt.equals("I"))
            {
                String s = scanner.next();
                insert(s.toCharArray());
            }
            else
            {
               String s = scanner.next();
               System.out.println(query(s.toCharArray()) );
            }
        }
    }
    static void insert(char[] c){
        int p = 0;
        for (int i = 0; i < c.length; i++) {
            int u = c[i] - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }
    static int query(char[] c){
        int p = 0;
        for (int i = 0; i < c.length ; i++) {
            int u = c[i] - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
