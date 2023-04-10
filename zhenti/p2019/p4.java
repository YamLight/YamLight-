package zhenti.p2019;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static sun.nio.ch.IOStatus.check;

public class p4 {
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
        long res = 0;
        for (int i = 1; i <= 2019 ; i++) {
            for (int j = i + 1; j + i <= 2019; j++) {
                for (int k = j + 1; i + j + k <= 2019 ; k++) {
                    if (check(i) && check(j) && check(k) && i + j + k == 2019) {
                        res++;
                    }
                }
            }
        }
        pw.print(res);
        pw.close();
    }
    static boolean check(int n){
        int t = n;
        while (t != 0){
            if (t % 10 == 4 || t % 10 == 2) return false;
            t /= 10;
        }
        return true;
    }
}
