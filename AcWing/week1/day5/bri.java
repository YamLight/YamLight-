package AcWing.week1.day5;

import java.util.Scanner;

public class bri {
    static int n = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0){
            n = scanner.nextInt();
            String s = scanner.next();
            char[] c = s.toCharArray();
            if (!check(c,'W') && !check(c,'B')){
                System.out.println("-1");
            }
        }
    }
    static boolean check(char[] s,char c){
        int[] res = new int[n * 3];
        char[] tmp = new char[n];
        //先把s数组复制过来
        for (int i = 0; i < n; i++) {
            tmp[i] = s[i];
        }
        int k = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (tmp[i] != c){
                update(tmp,i);
                update(tmp,i + 1);
                res[k++] = i;//记录操作
            }
        }
        if (tmp[0] != tmp[n - 1]) return false;
        System.out.println(k);
        for (int i = 0; i < k; i++) {
            System.out.print((res[i] + 1) + " ");
        }
        if (k != 0) System.out.println();
        return true;
    }
    static void update(char[] s,int idx){
        if (s[idx] == 'B') s[idx] = 'W';
        else s[idx] = 'B';
    }
}
