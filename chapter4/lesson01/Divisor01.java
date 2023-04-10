package chapter4.lesson01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Divisor01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int x = scanner.nextInt();
            getDivisor(x);
        }
    }
    static void getDivisor(int x){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= x / i ; i++) {
            if (x % i == 0){
                list.add(i);
                if (i != x / i) list.add(x / i);
            }
        }
        Collections.sort(list);
        for (int i: list
             ) {
            System.out.print(i+" ");
        }
    }
}
