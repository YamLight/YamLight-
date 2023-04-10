package zhenti.p2021;

public class p2 {
    public static void main(String[] args) {
        int[] card = new int[10];
        for (int i = 0; i < 10; i++) {
            card[i] = 2021;
        }
        for (int i = 1; i <= 5000; i++) {
            int tmp = i;
            while (tmp != 0){
                if (card[tmp % 10] == 0) {
                    System.out.println(i - 1);
                    return;
                }
                else {
                    card[tmp % 10]--;
                    tmp /= 10;
                }
            }
        }
    }
}
