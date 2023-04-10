package AcWing.week2.day3;

import java.io.*;

public class hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        int[] a1 = new int[s1.length()];
        int[] a2 = new int[s2.length()];
        int k1 = 0;
        while (n1 != 0){
            a1[k1++] = n1 % 10;
            n1 /= 10;
        }
        int k2 = 0;
        while (n2 != 0){
            a2[k2++] = n2 % 10;
            n2 /= 10;
        }
        while (true){
            for (int i = 0; i < k1; i++) {
                update1(a1,i);
                for (int j = 0; j < k2; j++) {
                    update2(a2,j);
                    if (getSum(a1,k1,2) == getSum(a2,k2,3)) {
                        System.out.println(getSum(a1,k1,2));
                        return;
                    }
                    update2(a2,j);
                }
                update1(a1,i);

            }
        }
    }
    static int getSum(int[] a,int k,int m){
        int sum = 0;
        for (int i = k - 1,j = 0; i >= 0; i--,j++) {
            sum += a[i] * Math.pow(m,j);
        }
        return sum;
    }
    static void update1(int[] a,int idx){
        int[] tmp = new int[a.length];
        tmp[idx] = 1 - a[idx];
    }
    static void update2(int[] a,int idx){
        int[] tmp = new int[a.length];
        tmp[idx] = 3 - a[idx];
    }
}
