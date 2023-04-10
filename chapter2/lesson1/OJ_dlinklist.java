package chapter2.lesson1;

import java.util.Scanner;

public class OJ_dlinklist {
    private static int N = 100010;
    //    private static int head = 0;
//    private static int tail = 1;
    private static int idx = 2;
    private static int[] e = new int[N];
    private static int[] l = new int[N];
    private static int[] r = new int[N];
    public static void main(String[] args) {
        r[0] = 1;l[1] = 0;
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m-- > 0) {
            String opt = scanner.next();
            char s = opt.charAt(0);
            if (s == 'L') {
                int x = scanner.nextInt();//插入最左端
                add(0, x);
            } else if (s == 'R') {
                int x = scanner.nextInt();//插入最右端
                add(l[1], x);
            } else if (s == 'D') {
                int k = scanner.nextInt();//删除元素
                delete(k + 1);
            } else if (opt.equals("IL")) {
                int k = scanner.nextInt();//将新元素插入到第k个元素的左边
                int x = scanner.nextInt();
                add(l[k + 1], x);
            } else {
                int k = scanner.nextInt();//将新元素插入到第k个元素的右边
                int x = scanner.nextInt();
                add(k + 1, x);
            }
        }
        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }
    private static void add(int k, int x) {
        e[idx] = x;
        l[r[k]] = idx;
        r[idx] = r[k];
        l[idx] = k;
        r[k] = idx++;
    }

    private static void delete(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
//    private static void add_to_head(int x){
//        e[idx] = x;
//        l[head] = idx;
//        r[idx] = head;
//        head = idx++;
//    }
//    private static void add_to_tail(int x){
//        e[idx] = x;
//        r[tail] = idx;
//        l[idx] = tail;
//        tail = idx++;
//    }
//    private static void ins_to_left(int k,int x){
//        e[idx] = x;
//        l[r[k-1]] = idx;
//        r[idx] = r[k-1];
//        l[idx] = k-1;
//        r[k-1] = idx++;
//    }

}
