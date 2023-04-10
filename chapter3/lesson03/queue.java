package chapter3.lesson03;

import java.util.Scanner;

public class queue {
    static int N = 100010;
    static int[] q = new int[N];//queue
    static int hh = 0;
    static int tt = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a =scanner.nextInt();
        int b = scanner.nextInt();
        push(a);
        push(b);
        pop();
        while (hh<=tt){
            System.out.println(q[hh++]);
        }
    }
    static void push(int a){
        q[++ tt] = a;
    }
    static void pop (){
        hh++;
    }
}
