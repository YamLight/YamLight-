package chapter2.lesson1;

public class link {
    static int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];//存储下一个元素的下标
    static int head = 0;
    static int idx = 0;
    public static void main(String[] args) {

    }
    static void add(int a){
        e[idx] = a;
        ne[idx] = head;
        head = idx++;
    }
}
