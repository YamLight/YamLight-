package zhenti.p2018;

public class p1 {
    public static void main(String[] args) {
//        System.out.println(31 + 29 + 31 + 30 + 4);
        int num = 2000;
        if (num % 4 == 0 && num % 100 != 0 || num % 400 == 0){
            System.out.println(29);
        }
    }
}
