### Week3

#### day2. 

全球变暖：https://www.acwing.com/problem/content/1235

这个题其实和常规搜索地图的bfs解法差不多 需要注意的就是这里的total 和 bound 在本题中的应用就是用一个点来搜索连通块 一个点如果上下左右任一方向有海那么就会被淹没 以此来给bound计数 那total自然就是用来统计连通块的了 

如果当前的total == bound那就代表所有连通块都临海 那么它就一定会被淹没了 cnt++

而过程中的限制：防止搜索越界 防止重复计算连通块 都要记下来 是我们以前学过的很常规的宽搜题目

```Java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class warm {
    static int N = 1010;
    static int n = 0;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[][] dir = new int[][]{
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!st[i][j] && g[i][j] == '#'){
                    if (dfs(i,j)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static boolean dfs(int x,int y){
        Queue<PII> q = new LinkedList<>();
        q.add(new PII(x,y));//将当前这个点入队
        st[x][y] = true;
        int total = 0,bound = 0;
        while (!q.isEmpty()){
            PII t = q.poll();
            total++;
            int tx,ty;
            boolean is_bound = false;
            for (int i = 0; i < 4; i++) {
                tx = t.x + dir[i][0] ; ty = t.y + dir[i][1];
                if (tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                if (st[tx][ty]) continue;
                if (g[tx][ty] == '.') {
                    is_bound = true;
                    continue;
                }
                q.add(new PII(tx,ty));
                st[tx][ty] = true;
            }
            if (is_bound) bound++;
        }
        return total == bound;
    }
}
class PII{
    int x;
    int y;

    public PII(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

#### day4

拓扑排序
这里需要注意一下 **如何去处理重边和自环**
重边的入度是不可能减到1的 所以不可能入队列 而自环是没有点可以入队的 所以也入不了队列 tt != n - 1所以就找不到拓扑序列了

```Java
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
```

