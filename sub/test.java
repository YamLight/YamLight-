package sub;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{3,2,1};//0-2
        Arrays.sort(a,0,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
