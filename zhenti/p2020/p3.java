package zhenti.p2020;

public class p3 {
    public static void main(String[] args) {
        double min = 999;
        int ans = 0;
        for (int k = 1; k <= 100 ; k++) {
            int num = 0;//有多少组
            if (100 % k == 0) num = 100 / k;
            else num = 100 / k + 1;
            double res = num + (num * 0.01 + k);//耗费检测数
            if (res < min){
                min = res;
                ans = k;
            }
        }
        System.out.println(ans);
    }
}
