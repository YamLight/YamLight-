package 蓝桥杯辅导课.chapter1.递归搜索;

import java.io.*;
import java.util.Scanner;

public class 回文日期 {
    static int[] a = new int[10];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        boolean flag = true;
        for (int i = n + 1;; i++) {
            if (check1(i) && flag){
                pw.println(i);
                flag = false;

            }
            else if (check2(i)){
                pw.println(i);
                pw.close();
                return;
            }
        }
    }
    static boolean check2(int num){
        for (int i = 0; i < 8; i++) {
            a[i] = num % 10;
            num /= 10;
        }
        if (a[0] == a[7] && a[1] == a[6] && a[2] == a[5] && a[3] == a[4] && a[0] == a[2] && a[1] == a[3]){
            return true;
        }
        else return false;
    }
    static boolean check1(int num){
        for (int i = 0; i < 8; i++) {
            a[i] = num % 10;
            num /= 10;
        }
        if (a[0] == a[7] && a[1] == a[6] && a[2] == a[5] && a[3] == a[4]) return true;
        else return false;
    }
}
