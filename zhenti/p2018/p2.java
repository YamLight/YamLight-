package zhenti.p2018;

public class p2 {
    static int n = 0;
    public static void main(String[] args) {
        for (int i = 1; i <= 1000 ; i++) {
            for (int j = 1; j <= 1000 ; j++) {
                if (i * i + j * j <= 1000 * 1000){
                    n++;
                }
            }
        }
        System.out.println(n * 4);
    }
}
