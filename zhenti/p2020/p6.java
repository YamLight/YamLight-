package zhenti.p2020;

import java.util.Scanner;

public class p6 {
    static int di_num = 0;
    static int up_num = 0;
    static int low_num = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 97 && c[i] <= 122) low_num++;
            else if (c[i] >= 65 && c[i] <= 90) up_num++;
            else if (c[i] >= 49 && c[i] <= 57) di_num++;
        }
        System.out.println(up_num);
        System.out.println(low_num);
        System.out.println(di_num);
    }
}
