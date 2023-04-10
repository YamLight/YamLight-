package sub;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 整数拆分 {
    static int N = 10;
    static int[] res = new int[N];
    static HashSet<String> set = new HashSet<>();
    static int cnt = 0;
    static int n = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(n,0);
    }
    static void dfs(int sum,int step){
        if (step > n) return;
        if (sum == 0){
            Arrays.sort(res,0,cnt);
            String s = "";
            for (int i = 0; i < cnt; i++) {
                if (i != cnt - 1){
                    s += res[i] + "+";
                }
                else s += res[i] + "";
            }
//            for (int i = 0; i < cnt; i++) {
//                System.out.print(res[i] + " ");
//            }
            if (!set.contains(s)){
                set.add(s);
                System.out.println(s + " " + sum + " " + cnt);
            }
            return;
        }
        for (int i = 1; i < n ; i++) {
            if (sum >= i){
                res[cnt++] = i;
                System.out.println("sum = " + sum + " i = " + i + " cnt = " + cnt);
                dfs(sum - i,step + 1);
                res[--cnt] = 0;
//                System.out.println(sum);
            }
            //不选这个数字
            dfs(sum,step + 1);
            //选这个数字
        }
    }
}
