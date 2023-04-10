package chapter2.lesson1;

import java.util.Scanner;

public class linklist {
    private static int N = 100010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int idx = 1;
    private static int head = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-->0){
            String s = scanner.next();
            char c = s.charAt(0);
            if(c=='H'){
                int x = scanner.nextInt();
                add_to_head(x);
            }else if(c=='D'){
                int k = scanner.nextInt();
                if(k==0) head = ne[head];
                else remove(k);
            }else{
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                add(k ,x);
            }
        }
        //这里是-1跳出循环的原因是 初始化head=-1 此后无论是进行什么操作 尾结点的ne都是-1 （特殊情况也验证过了 如果是清空链表）、
        //最后一个结点的ne依然是-1
        for (int i = head;i!= -1 ; i = ne[i]) {
            System.out.print(e[i]+" ");
        }
    }

    public static void init(){
        head = -1;
        idx = 1;
    }
    public static void add_to_head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    public static void add(int k, int x) {//insert
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    public static void remove(int k) {
        ne[k] = ne[ne[k]];
    }
}
