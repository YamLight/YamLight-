### Week3

#### day1. 

spfa算法：这是一个适用于求带负权边单源最短路径的一个算法 模板和Dijkstra及其类似

但是这里的核心思想是**dist[j] > dist[t] + w[i]**变小一定是dist[t]变小了 那我们每一次用变小的点 来更新这个点的所有出边 就可以得到一个最短路径了

区别：st数组和Dij不同的是 这里的st数组判断当前结点是否在队列中

```Java
package AcWing.week4.day1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa {
    static int N = 500010;
    static int M = 2 * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] w = new int[N];
    static int[] ne = new int[M];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m,idx;
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        Arrays.fill(dist,max);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
        Dijkstra();
        if (dist[n] == max) System.out.println("impossible");
        else System.out.println(dist[n]);
    }
    static void Dijkstra(){
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        st[1] = true;
        q.add(1);
        while (!q.isEmpty()){
            int t = q.poll();
            st[t] = false;
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]) {
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
```



spfa判断是否有负环

**这里为什么要将所有的结点都加入队列 我们可以加入一个虚拟源点 与所有结点连一条权值为0的边 图中有负环再去做一次spfa那么所有的结点就都会加入队列中 后面就是spfa的正常步骤了 我们需要知道的是在什么时候做spfa都是不会错的 晚安 **

```Java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa_check {
    static int N = 500010;
    static int M = 2 * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] w = new int[N];
    static int[] ne = new int[M];
    static int[] cnt = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m,idx;
    static int max = 0x3f3f3f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
        if (spfa()) System.out.println("Yes");
        else System.out.println("No");
    }
    static boolean spfa(){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            q.add(i);
            st[i] = true;
        }
        while (!q.isEmpty()){
            int t = q.poll();
            st[t] = false;
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return true;
                    if (!st[j]) {
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
```

#### day3

Prim最小生成树算法

思想：每次先取出集合外部距离集合最近的一个点 然后再用这个点更新集合外部的其他点，初始化是非常重要的 dist数组 还有二维g数组都要先置max
和Dijkstra很类似 prim中判断i != 0是因为如果i == 0 的话就证明集合里面是没有点的  

```Java
import java.util.Arrays;
import java.util.Scanner;

public class prim {
    static int N = 510;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m;
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                g[i][j] = max;
            }
        }
        while (m-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b],c);
            if (a == b) g[a][b] = g[b][a] = 0;
        }
        int t = prim();
        if (t == max) System.out.println("impossible");
        else System.out.println(t);
    }
    static int prim(){
        Arrays.fill(dist,max);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n ; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) t = j;
            }
            if (i != 0 && dist[t] == max) return max;
            if (i != 0){
                res += dist[t];
            }
            st[t] = true;
            for (int j = 1; j <= n ; j++) {
                dist[j] = Math.min(dist[j],g[t][j]);
            }
        }
        return res;
    }
}
```

#### day4

spfa思想：种子杂交：https://www.acwing.com/problem/content/description/3308/

本题首先是运用了Dp分析法

 x + y ——>z 那么dist[z] = Max(生产x的，生产y的) + Max(w[x],w[y])

权值是固定的 那么要求的就是dist[x] 和dist[y] 以此类推

```Java
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N = 20010;
    static int M = 200010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static int[] target = new int[M];
    static boolean[] st = new boolean[N];
    static int n,m,k,t,idx;
    static int max = 0x3f3f3f;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);//种子总数
        m = Integer.parseInt(s1[1]);//初始拥有种子数量
        k = Integer.parseInt(s1[2]);//杂交方案
        t = Integer.parseInt(s1[3]);//目标种子
        Arrays.fill(h,-1);
        Arrays.fill(dist,max);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n ; i++) {
            w[i + 1] = Integer.parseInt(s2[i]);
        }
        String[] s3 = br.readLine().split(" ");
        for (int i = 0; i < m ; i++) {
            int x = Integer.parseInt(s3[i]);
            dist[x] = 0;
            q.add(x);
            st[x] = true;
            }
        for (int i = 1; i <= k ; i++) {
            String[] s4 = br.readLine().split(" ");
            int a = Integer.parseInt(s4[0]);
            int b = Integer.parseInt(s4[1]);
            int c = Integer.parseInt(s4[2]);
            add(a,b,c); add(b,a,c);
        }
        spfa();
        out.println(dist[t]);
        out.flush();
    }
    static void spfa(){
        while (q.size() > 0){
            int t = q.poll();
            st[t] = false;
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i]; int z = target[i];
                if (dist[z] > Math.max(dist[j],dist[t]) + Math.max(w[t],w[j])){
                    dist[z] = Math.max(dist[j],dist[t]) + Math.max(w[t],w[j]);
                    if (!st[z]){
                        q.add(z);
                        st[z] = true;
                    }
                }
            }
        }
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        target[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
```

#### day5

城市通电：https://www.acwing.com/problem/content/3731/

这题其实让我对prim有了一个更深层次的理解 并且也见识了最小生成树的题型

最先发现的问题就是 我们内部循环的第一次循环是要找一个集合外距离集合最近的点 然后去更新其他点 但是要注意 就只是更新而已 并没有将其他点就加入集合了 这个很小的错误很容易犯

然后就是超级源点的事情 其实我自己认为 在题目中如果是只涉及到某一个点独立花费 就可以建立一个独立的源点来解题 既然建立了独立源点 那么把所有点都加入超级源点的集合就是常规操作了

```Java
import java.util.HashSet;
import java.util.Scanner;

public class city {
    static int N = 2010;
    static int M = 4000010;
    static PII[] p = new PII[N];
    static long[] dist = new long[N];
    static int[] f = new int[N];
    static long[] wc = new long[N];
    static long[] wk = new long[N];
    static boolean[] st = new boolean[N];
    static int n,m;
    static HashSet<Integer> res1 = new HashSet<>();
    static HashSet<PII> res2 = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            p[i] = new PII(a,b);
        }
        for (int i = 1; i <= n ; i++) {
            wc[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            wk[i] = scanner.nextInt();
        }
        System.out.println(prim());
        if (res1.size() > 0){
            System.out.println(res1.size());
            for (int i : res1){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else System.out.println(0);
        if (res2.size() > 0){
            System.out.println(res2.size());
            for (PII t : res2){
                System.out.println(t.a + " " + t.b);
            }
        }
        else System.out.println(0);
    }
    static long prim(){
        long res = 0;
        dist[0] = 0;
        st[0] = true;
        for (int i = 1; i <= n ; i++) {
            dist[i] = wc[i];
        }
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n ; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) t = j;
            }
            res += dist[t];
            st[t] = true;
            if (f[t] == 0) res1.add(t);
            else res2.add(new PII(f[t],t));
            for (int j = 1; j <= n ; j++) {
                if (dist[j] > get_dist(t,j)){
                    dist[j] = get_dist(t,j);
                    f[j] = t;
                }
            }
        }
        return res;
    }
    static long get_dist(int a,int b){
        int da = Math.abs(p[a].a - p[b].a);
        int db = Math.abs(p[a].b - p[b].b);
        return (da + db) * (wk[a] + wk[b]);
    }
}
class PII{
    int a;
    int b;

    public PII(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
```

