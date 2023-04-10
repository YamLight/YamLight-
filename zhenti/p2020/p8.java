package zhenti.p2020;

import java.util.Scanner;

public class p8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        char[] b = a.toCharArray();
        int[] tmp = new int[b.length];
        char[] res = new char[b.length];
        for (int i = 0; i < b.length; i++) {
            tmp[i] = Integer.parseInt(b[i] + "");
        }
        int i = 0;
        int cnt = 0;
        while (i != tmp.length){
            int n = tmp[i];
            int m = tmp[i + 1];
            int ans = n * 10 + m;//组成两位数
            if (ans <= 26){
                res[cnt++] = (char) (ans + 64);
                i += 2;
            }
            else {
                res[cnt++] = (char) (n + 64);
                i += 1;
            }
        }
        for (int j = 0; j < cnt; j++) {
            System.out.print(res[j]);
        }
    }
}
