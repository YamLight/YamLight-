package sub;

import java.util.Scanner;

public class a1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.print(Math.min(a,b) + " ");
        int num = Math.abs(a - b);
        System.out.print(num / 2);
    }
}
