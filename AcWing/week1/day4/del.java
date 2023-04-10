package AcWing.week1.day4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class del {
    static int N = 210;
    static char[] c = new char[N];
    static int[] q = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        c = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            if (c[i] != 'x') continue;
            while (j < n && c[j] == 'x') j++;
            cnt += Math.max(0,j - i- 2);
            i = j - 1;
        }
        System.out.println(cnt);
    }
}
