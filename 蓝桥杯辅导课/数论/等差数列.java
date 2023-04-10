package 蓝桥杯辅导课.数论;

import java.io.*;
import java.util.Arrays;

public class 等差数列 {
    static int N = 100010;
    static int[] a = new int[N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int min = (int)1e9;
        Arrays.sort(a,0,n);
        for (int i = 0; i < n; i++) {
            min = gcd(min,a[i]);
        }
        if (min == 0) System.out.println(n);
        else System.out.println((a[n - 1] - a[0]) / min + 1);
    }
    static int gcd(int a,int b){
        return b > 0 ? gcd(b,a % b) : a;
    }
}
