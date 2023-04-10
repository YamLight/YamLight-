package chapter2.lesson1;

import java.io.*;

public class kmp01 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = 100010,M = 1000010;
//        int n  = Integer.parseInt(br.readLine());//输入p字符的长度
//        String P =  br.readLine();//输入p字符串
//        char[] p = new char[N];//创建p数组存字符
//        for(int i = 1 ; i <= n ; i ++ ) p[i] = P.charAt(i-1);
//        int m = Integer.parseInt(br.readLine());//输入s字符串的长度
//        String S = br.readLine();//输入s字符串
//        char[] s = new char[M];//创建s数组存字符
//        for(int i = 1 ; i <= m ; i ++ ) s[i]  = S.charAt(i-1);
//        int[] ne = new int[N];//kmp核心数组next[];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 100010;
        int M = 1000010;
//        int n = br.read();
        int n = Integer.parseInt(br.readLine());
        String P = br.readLine();
        char[] p = new char[N];
//        int m = br.read();
        int m = Integer.parseInt(br.readLine());
        String S = br.readLine();
        char[] s = new char[M];
        for (int i = 1; i <= n; i++) {
            p[i] = P.charAt(i - 1);
        }
        for (int i = 1; i <= m; i++) {
            s[i] = S.charAt(i - 1);
        }
        int[] ne = new int[N];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) {
                bw.write((i - n) + " ");
                j = ne[j];
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
