package AcWing.week1.day3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class where {
    static int N = 110;
    static int n = 0;
    static String s = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();
        int l = 1,r = n,mid;
        while (l < r){
            mid = (l + r) / 2;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        System.out.println(l);
    }
    static boolean check(int mid){
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i + mid - 1 < n ; i++) {
            //截取子串
            String t = s.substring(i,i + mid);
            //如果有重复字串 那就返回错误
            if (set.contains(t)) return false;
            set.add(t);
        }
        return true;
    }
}
