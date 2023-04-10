package 蓝桥杯辅导课.chapter1.Binaray;

import java.io.*;

public class 切巧克力 {
    static int N = 100010;
    static pair[] s = new pair[N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n,k;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        for (int i = 1; i <= n ; i++) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            max = Math.max(a,max);
            int b = Integer.parseInt(s2[1]);
            max = Math.max(b,max);
            s[i] = new pair(a,b);
        }
        int l = 1,r = max;
        int mid;
        while (l < r){
            mid = (l + r + 1) / 2;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        System.out.println(l);
    }
    static boolean check(int mid){
        int t = k;
        for (int i = 1; i <= n ; i++) {//枚举所有的巧克力
            int a = s[i].x / mid;
            int b = s[i].y / mid;
            int sum = a * b;
            t -= sum;
            if (t <= 0) {
                return true;
            }
        }
        return false;
    }
}
class pair{
    int x;
    int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
