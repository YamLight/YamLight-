package AcWing.week3.day4;
import java.util.Arrays;
import java.util.Scanner;

public class top {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] d = new int[N];
    static int n,m,idx;
    static int hh = 0,tt = -1;
    static int[] q = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        Arrays.fill(h,0,h.length,-1);
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
            d[b]++;
        }
        if (top()){
            for (int i = 0; i < n; i++) {
                System.out.print(q[i] + " ");
            }
        }
        else System.out.println("-1");
    }
    static boolean top(){
        for (int i = 1; i <= n ; i++) {//如果有入度为0的点 那就入队
            if (d[i] == 0) q[++tt] = i;
        }
        while (hh <= tt){
            int t = q[hh++];
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) q[++tt] = j;
            }
        }
        return tt == n - 1;
    }
    static void add(int a,int b){//将a链接到b结点之后
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
