package certtest.rule00;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class IDS06J {
    static Calendar c = new GregorianCalendar(1995, GregorianCalendar.MAY, 23);
    public static void main(String[] args) {
        System.out.format(args[0] + " did not match! HINT: It was issued on $1$terd of some month", c);
    }
}
// 뭔소린지 모르겠음