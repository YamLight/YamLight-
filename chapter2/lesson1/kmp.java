package chapter2.lesson1;

import java.io.*;

public class kmp {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 100010,M = 1000010;
        int n  = Integer.parseInt(bf.readLine());//输入p字符的长度
        String P =  bf.readLine();//输入p字符串
        char[] p = new char[N];//创建p数组存字符
        for(int i = 1 ; i <= n ; i ++ ) p[i] = P.charAt(i-1);
        int m = Integer.parseInt(bf.readLine());//输入s字符串的长度
        String S = bf.readLine();//输入s字符串
        char[] s = new char[M];//创建s数组存字符
        for(int i = 1 ; i <= m ; i ++ ) s[i]  = S.charAt(i-1);
        int[] ne = new int[N];//kmp核心数组next[];
        //构造ne数组
        //在构造ne数组的时候 j是一个关键指针 可以把它看作一个最大的限度
        for (int i = 2, j = 0; i <= n; i++) {
            //当j并不是退无可退 而且两个串(其实是一个)看不对眼的时候 j指针就要进行后退
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            //如果两个串看对眼了 j指针就可以加 1
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        //匹配的过程和构造非常类似 因为构造ne数组的过程和匹配本质是一样的
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) {
                wt.write((i - n) + " ");
                j = ne[j];
            }
        }
        wt.flush();
        wt.close();
        bf.close();
    }
}
