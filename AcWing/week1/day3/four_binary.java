package AcWing.week1.day3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class four_binary {
    static int N = (int)5e6 + 10;
    static Sum[] sums = new Sum[N];
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = 0;
        for (int c = 0; c  * c <= n ; c++) {
            for (int d = c; c * c + d * d <= n ; d++) {
                sums[m++] = new Sum(c * c + d * d,c,d);//把cd的哈希表打出来
            }
        }
        Arrays.sort(sums,0,m);
        for (int a = 0; a * a <= n ; a++) {
            for (int b = a; a * a + b * b <=n ; b++) {
                int s = n - a * a - b * b;
                int l = 0,r = m - 1;
                while (l < r){
                    int mid = (l + r) / 2;
                    if (sums[mid].s >= s) r = mid;
                    else l = mid + 1;
                }
                if (sums[l].s == s) {
                    System.out.print(a + " ");
                    System.out.print(b + " ");
                    System.out.print(sums[l].c + " ");
                    System.out.print(sums[l].d + " ");
                    return;
                }
            }
        }
    }
}
class Sum implements Comparable<Sum>{
    int s,c,d;

    public Sum(int s, int c, int d) {
        this.s = s;
        this.c = c;
        this.d = d;
    }

    @Override
    public int compareTo(Sum o) {
        if (s != o.s) return this.s - o.s;
        if (c != o.c) return this.c - o.c;
        return this.d - o.d;
    }
}
