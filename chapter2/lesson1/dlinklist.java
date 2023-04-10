package chapter2.lesson1;

public class dlinklist {
    private static int N = 100010;
    private static int[] e = new int[N];
    private static int[] l = new int[N];
    private static int[] r = new int[N];
    private static int idx = 2;
    public static void main(String[] args) {

    }
    public static void remove(int k){
        r[l[k]] = l[k];
        l[r[k]] = r[k];
    }
    public static void add(int k,int x){
        e[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx;
        r[k] = idx++;
    }
    public static void init(){
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }
}
