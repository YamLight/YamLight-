package zhenti.p2013;

public class zxzh {
    static int[][] map = new int[][]{
        {1,2,3,4,5}, {2,3,4,5,6},{3,4,5,6,7}, {4,5,6,7,8}
    };
    static int[][] dir = new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
    };
    static int[] a = new int[8];
    static boolean[][] st = new boolean[4][5];
    static int res = 0;
    public static void main(String[] args) {
        dfs(0,0,1);
        System.out.println(res);
    }
    static void dfs(int x,int y,int idx){
        if (idx == 9){
            boolean flag = true;
            for (int i = 1; i < idx; i++) {
                if (a[i] != i) flag = false;
            }
            if (flag) res++;
            return;
        }
        else {
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[0][i];
                if (dx >= 0 && dx < 4 && dy >= 0 && dy < 5){
                    a[idx++] = map[dx][dy];
                    st[dx][dy] = true;
                    dfs(dx,dy,idx);
                    a[--idx] = 0;
                    st[dx + x][dy + y] = false;
                }
            }
        }
        return;
    }
}
