package zhenti.p2020;

public class p4 {
    static int[] a = new int[]{9090400,8499400,5926800,8547000,4958200,4422600,5751200,4175600,6309600,5865200,6604400,4635000,10663400,8087200,4554000};
    static boolean[] st = new boolean[15];
    static int res = (int)1e9;
    public static void main(String[] args) {
        dfs(0,0,0);
        System.out.println(res);
    }
    static void dfs(int sum_a,int sum_b,int use){
        if (use == 15){
            res = Math.min(res,Math.abs(sum_a - sum_b));
            return;
        }
        else {
            dfs(sum_a + a[use],sum_b,use + 1);
            dfs(sum_a,sum_b + a[use],use + 1);
        }
    }
}
