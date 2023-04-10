package AcWing.week1.day3;

import java.util.Scanner;

public class binary{
    static int N = 100010;
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        while (q-- > 0){
            int num = scanner.nextInt();
            int l = 0,r = n - 1,mid;
            while (l < r){
                mid = (l + r) / 2;
                if (a[mid] >= num) r = mid;//mid此时可能是左边界 也可能在合法区间中
                else l = mid + 1;
            }
            if (a[l] != num) System.out.println("-1 -1");
            else {
                System.out.print(l+" ");
                l = 0;r = n - 1;
                while (l < r){
                    mid = (l + r + 1) / 2;
                    if (a[mid] <= num) l = mid;//mid此时有可能是右边界 也可能在子区间中
                    //check(mid)
                    else r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }
}
