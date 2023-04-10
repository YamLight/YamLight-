package zhenti.p2018;

import java.io.*;
import java.util.Arrays;

public class p5 {
    static int N = 1000010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] c = new int[N];
    static int res = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n ; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n  ; i++) {
            b[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(a,0,n);
        Arrays.sort(b,0,n);
        Arrays.sort(c,0,n);
        for (int i = 0; i < n; i++) {
            int xa = a[i];
            int lb = 0,rb = n - 1;
            int mid = 0;
            while (lb < rb){
                mid = (lb + rb) >> 1;
                if (b[mid] > xa) rb = mid;
                else lb = mid + 1;
            }
            int ans_b = lb;//找到b数组大于a[i]的位置
            int xb = b[lb];
            int lc = 0,rc = n - 1;
            while (lc < rc){
                mid = (lc + rc) >> 1;
                if (c[mid] > xb) rc = mid;
                else lc = mid + 1;
            }
            int ans_c = lc;//找到c数组大于b[l]的位置
            if (b[lb] <= xa || c[lc] <= xb) continue;
            res += (n - ans_b) * (n - ans_c);
        }
        pw.println(res);
        pw.close();
    }
}
