package AcWing.week1.day5;

import java.util.Scanner;

public class coin {
    static int size = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        size = s1.length();
        check(s1.toCharArray(),s2.toCharArray());
    }
    static void check(char[] s1,char[] s2){
        int res = 0;
        for (int i = 0; i + 1 < size ; i++) {
            if (s1[i] != s2[i]){
                update(s1,i);
                update(s1,i + 1);
                res++;
            }
        }
        System.out.println(res);
    }
    static void update(char[] s,int idx){
        if (s[idx] == '*') s[idx] = 'o';
        else s[idx] = '*';
    }
}
