package zhenti.p2018;

import java.io.*;
import java.util.Arrays;

public class p5_01 {
    static int N = 1000010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] c = new int[N];
    static long res = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }
        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(s1[i - 1]);
        }
        String[] s2 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            c[i] = Integer.parseInt(s2[i - 1]);
        }
        Arrays.sort(a, 1, n + 1);
        Arrays.sort(b, 1, n + 1);
        Arrays.sort(c, 1, n + 1);
        for (int i = 1; i <= n; i++) {
            int xb = b[i];
            int la = 0,ra = n + 1;
            while (la < ra){
                int mid = (la + ra) >> 1;
//                if (a[mid] <= xb) la = mid;
                if (a[mid] >= xb) ra = mid;
                else la = mid + 1;
            }
            int lc = 0,rc = n + 1;
            while (lc < rc){
//                int mid = (lc + rc) >> 1;
//                if (c[mid] >= xb) rc = mid;
//                else lc = mid + 1;
                int mid = (lc + rc + 1) >> 1;
                if (c[mid] <= xb) lc = mid;
                else rc = mid - 1;
            }
            if (la == 0 || lc == n + 1) continue;
            res += (long) (la - 1) * (n - lc);
        }
        pw.println(res);
        pw.close();
    }
}