package zhenti.p2020;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class p2_1 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = format.parse("1921-07-23 12:00:00");
        Date end = format.parse("2020-07-01 12:00:00");
        System.out.println((end.getTime() - start.getTime()) / 1000 / 60);
    }
}
