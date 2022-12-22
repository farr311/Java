package lesson24;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.Locale;

public class DateAndTimePractice {

    public static void main(String[] args) {
        /*Date d = new Date();
        System.out.println(d.getTime());

        System.out.println(d);*/

        /*LocalDate d = LocalDate.of(2022, 2, 10);

        System.out.println(d.get(ChronoField.DAY_OF_YEAR));
        System.out.println(d.isLeapYear());
        System.out.println(LocalDate.of(2024, 2, 28).isLeapYear());
        System.out.println(d.isAfter(LocalDate.of(2022, 2, 9)));

        System.out.println(d);*/

       // LocalDateTime t = LocalDateTime.of(2022, 2, 10, 22, 48);
        //System.out.println(t.withHour(12).withMinute(6).withSecond(24));
        //System.out.println(t);

        /*System.out.printf("%tD\n%n", t);
        System.out.printf("%tF\n%n", t);
        System.out.printf("%tr\n%n", t);*/
        /*System.out.printf(Locale.US, "%tz\n%n", t);
        System.out.printf(Locale.US, "%tZ\n%n", t);*/

        var d = new CustomDateTime(1271070475);
    }
}
