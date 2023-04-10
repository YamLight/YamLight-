package chapter2.lesson1;

import java.util.Scanner;

public class OJ_stack {
    static int N = 100010;
    static int tt = 0;
    static int[] sta = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m-->0){
            String s = scanner.next();
            if (s.equals("pop")){
                pop();
            }else if (s.equals("push")){
                int x = scanner.nextInt();
                push(x);
            }else if (s.equals("empty")){
                if (empty()) System.out.println("YES");
                else System.out.println("NO");
            }else {
                System.out.println(query());
            }
        }
    }
    static void pop(){
        tt--;
    }
    static void push(int x){
        sta[++tt] = x;
    }
    static boolean empty(){
        if (tt>0) return false;
        else return true;
    }
    static int query(){
        return sta[tt];
    }
}
