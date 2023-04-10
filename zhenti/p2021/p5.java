package zhenti.p2021;

import java.util.Arrays;

public class p5 {
    static int N = 2030;
    static int[][] map = new int[N][N];
    static int[] dist = new int[N];
    static int max = (int)1e9;
    //以后的max一律用1e9
    static boolean[] st = new boolean[N];
    public static void main(String[] args) {
        for (int i = 1; i <= 2021 ; i++) {
            map[i][i] = 0;
            for (int j = i + 1; j <= 2021 ; j++) {
                int g = Math.abs(i - j);
                if (g > 21) map[i][j] = map[j][i] = max;
                else map[i][j] = map[j][i] = get_Num(i,j);
            }
        }
        Dijkstra();
        for (int i = 1; i <= 2021 ; i++) {
            System.out.println(dist[i]);
        }
        System.out.println(dist[2021]);
    }
    static void Dijkstra(){
        Arrays.fill(dist,max);
        dist[1] = 0;
        for (int i = 1; i < 2021; i++) {
            int t = -1;
            for (int j = 1; j <= 2021 ; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) t = j;
            }
            st[t] = true;
            for (int j = 1; j <= 2021 ; j++) {
                if (map[t][j] == max) continue;
                dist[j] = Math.min(dist[j],dist[t] + map[t][j]);
            }
        }
    }
    static int get_Num(int a,int b){
        int res = 0;
        for (int i = a; ; i += a) {
            if (i % b == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}
