package zhenti.p2019;

import java.io.*;

public class p6 {
    static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int n = 0;
    static long res = 0;
    public static void main(String[] args) throws IOException {
        st.nextToken();
        n = (int)st.nval;
        System.out.println(get_res());
    }
    static long get_res(){
        for (int i = 1; i <= n ; i++) {
            int t = i;
            while (t != 0){
                int num = t % 10;
                if (num == 2 || num == 0 || num == 1 || num == 9){
                    res += i;
                    break;
                }
                t /= 10;
            }
        }
        return res;
    }
}
