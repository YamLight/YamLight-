package AcWing.race;

import java.util.Scanner;

public class c1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        int x = scanner.nextInt();
        if (x <= 5) System.out.println(1);
        else {
            if (x % 5 != 0){
                res = (int)(x / 5 + 1);
                System.out.println(res);
            }
            else System.out.println(x / 5);
        }
    }
}
