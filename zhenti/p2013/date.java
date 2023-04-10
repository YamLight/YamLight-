package zhenti.p2013;

public class date {
    static int res = 0;
    static int[] a = new int[6];
    static int idx = 1;
    static boolean[] st = new boolean[10];
    public static void main(String[] args) {
        dfs(1);
        System.out.println(res);
    }
    static void dfs(int f){
        if (f == 6){
            int t1 = (a[1] * 10 + a[2]) * (a[3] * 100 + a[4] * 10 + a[5]);
            int t2 = (a[1] * 100 + a[4] * 10 + a[2]) * (a[3] * 10 + a[5]);
            if (t1 == t2) res++;
            return;
        }
        for (int i = 1; i <= 9 ; i++) {
            if (!st[i]) {
                a[idx] = i;
                idx++;
                st[i] = true;
                dfs(f + 1);
                a[--idx] = 0;
                st[i] = false;
            }
        }
        return;
    }
}
