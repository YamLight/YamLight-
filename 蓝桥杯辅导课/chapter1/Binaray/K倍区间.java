package 蓝桥杯辅导课.chapter1.Binaray;

import java.io.*;

public class K倍区间 {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] s = new int[N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n,k;
    public static void main(String[] args) throws IOException {
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        for (int i = 1; i <= n ; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }
        for (int i = 1; i <= n ; i++) {
            s[i] = s[i - 1] + a[i];
        }
        int cnt = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; i + j <= n ; j++) {
                int num = s[i + j] - s[i - 1];
                if (num % k == 0) cnt++;
            }
        }
        pw.println(cnt);
        pw.close();
    }
}
