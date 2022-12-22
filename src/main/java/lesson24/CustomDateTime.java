package lesson24;

import java.util.regex.Pattern;

public class CustomDateTime {

    private final int dayOfMonth;
    private final Month month;
    private final int year;
    private final int hour;
    private final int minute;
    private final int second;

    public CustomDateTime(long unixTimestamp) {
        if (unixTimestamp < 0) {
            throw new RuntimeException("Only positive timestamps supported");
        }

        year = calculateYear(unixTimestamp);
        boolean leapYear = isLeapYear(year);
        int dayCountInYear = leapYear ? 366 : 365;

        long remainder = calculateRemainder(unixTimestamp, year);
        long dayOfYear = remainder % dayCountInYear;

        if (dayOfYear == 0) {
            dayOfYear = dayCountInYear;
        }

        int dayOfMonth1 = 0;
        Month month1 = Month.JANUARY;
        int d = (int) dayOfYear;
        for (Month m : Month.values()) {
            int dayCount = (m == Month.FEBRUARY && leapYear) ? 29 : m.dayCount;

            if (d - dayCount <= 0) {
                month1 = m;
                dayOfMonth1 = d;
                break;
            }
            d -= dayCount;
        }

        dayOfMonth = dayOfMonth1;
        month = month1;
        hour = 0;
        minute = 0;
        second = 0;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "2022-12-20T22-49-53";
    }

    public boolean isBefore(CustomDateTime d) {
        return true;
    }

    public boolean isAfter(CustomDateTime d) {
        return true;
    }

    private int calculateYear(long ts) {
        //Mon Apr 12 2010 11:07:55
        //1972
        int secondsInYear = 86_400 * 365;
        int yearCount = 0;
        long remainder = ts;

        while (remainder > secondsInYear) {
            int secondsInCurrentYear = yearCount % 4 != 2 ? secondsInYear + 86_400 : secondsInYear;
            remainder -= secondsInCurrentYear;

            yearCount++;
        }

        return 1970 + yearCount;
    }

    private long calculateRemainder(long ts, int y) {
        int leapYearCount = 0;

        if (y >= 1972) {
            int diff = y - 1972;
            leapYearCount = diff / 4 + 1;
        }

        return ts - (y - 1970) * 365L * 86_400 - leapYearCount * 86_400L;
    }

    private boolean isLeapYear(int y) {
        return (y - 1970) % 4 == 2;
    }


    public enum Month {
        JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31),
        JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31),
        NOVEMBER(30), DECEMBER(31);

        private final int dayCount;

        Month(int dayCount) {
            this.dayCount = dayCount;
        }

        public int getDayCount() {
            return dayCount;
        }
    }
}
