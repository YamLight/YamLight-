package 蓝桥杯辅导课.chapter1.Binaray;

import java.io.*;
import java.util.Scanner;

public class 机器人跳跃{
    static int N = 100010;
    static int[] h = new int[N];
    static int n = 0;
    static int max = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(s[i - 1]);
            max = Math.max(max,h[i]);
        }
        int l = 0,r = max;
        while (l < r){
            int mid = (l + r) >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        System.out.println(l);
    }
    static boolean check(int x){
        long res = x;
        for (int i = 1; i <= n; i++) {
            if (h[i] > res) res -= (h[i] - res);
            else res += (res - h[i]);
            if (res < 0) return false;
            if (res > max) return true;
        }
        return true;
    }
}
