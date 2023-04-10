package AcWing.week2.day2;
import java.io.*;
import java.util.HashMap;

public class fami {
    static int M = 1000010;
    static int[] f = new int[M];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
        while (m-- > 0) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            if (find(a) != find(b)) f[find(a)] = find(b);
        }
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            if (query(a, b)) {
                bw.write("Yes");
                bw.newLine();
            } else {
                bw.write("No");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean query(int a, int b) {
        int s1 = find(a);
        int s2 = find(b);
        if (s1 == s2) return true;
        else return false;
    }

    static int find(int x) {
        if (f[x] != x) f[x] = find(f[x]);
        return f[x];
    }
}
