package zhenti.p2018;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;

public class 复数幂 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("ans.txt");
        BigInteger a = new BigInteger("2");
        BigInteger b = new BigInteger("3");
        BigInteger ans_shi = new BigInteger("2");
        BigInteger ans_xu = new BigInteger("3");
        for (int i = 1; i <= 123456 ; i++) {
            BigInteger t = ans_shi;
            ans_shi = (ans_shi.multiply(a)).subtract(b.multiply(ans_xu));
            ans_xu = (t.multiply(b)).add(a.multiply(ans_xu));
        }
        System.setOut(ps);
        System.out.println(ans_shi.toString() + "+" + ans_xu.toString() + "i");
//        System.setOut(System.out);
//        System.out.println(a.toString() + b.toString() + "i");
    }
}
