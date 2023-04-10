package AcWing.week2.day3;

import java.util.HashSet;
import java.util.Scanner;

public class cow {
    static HashSet set = new HashSet<Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a1 = scanner.next().toCharArray();//二进制数
        char[] a2 = scanner.next().toCharArray();//三进制数
        for (int i = 0; i < a1.length; i++) {
            a1[i] ^= 1;
            set.add(get(a1,2));
            a1[i] ^= 1;
        }
        for (int i = 0; i < a2.length; i++) {
            char tmp = a2[i];
            for (char j = '0'; j <= '2' ; j++) {
                if (tmp != j){
                    a2[i] = j;
                    int x = get(a2,3);
                    if (set.contains(x)){
                        System.out.println(x);
                        return;
                    }
                }
            }
            a2[i] = tmp;
        }
    }
    static int get(char[] c,int k){
        int res = 0;
        //秦九邵算法
        for (int i = 0; i < c.length ; i++) {
            res = res * k + (c[i] - '0');
            //错误
//            res += (c[i] * k) + (c[i + 1] - '0');
        }
        return res;
    }
}
