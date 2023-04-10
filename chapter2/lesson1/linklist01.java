package chapter2.lesson1;

import java.util.Scanner;

public class linklist01 {
    private static int N = 100010;
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int idx = 1;
    private static int head = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            String s = scanner.next();
            if(s.equals("H")){
                int x = scanner.nextInt();
                add_to_head(x);
            }else if(s.equals("D")){
                int k = scanner.nextInt();
                if(k==0){
                    head = ne[head];
                }
                else remove(k);
            }else {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                add(k,x);
            }
        }
        for (int i = head; i !=-1 ; i=ne[i]) {
            System.out.print(e[i]+" ");
        }
    }
    public static void remove(int k){
        ne[k] = ne[ne[k]];
    }
    public static void add(int k,int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }
    public static void add_to_head(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }
}
