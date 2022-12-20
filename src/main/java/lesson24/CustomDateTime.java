package lesson24;

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

        dayOfMonth = 0;
        month = Month.JANUARY;
        year = 0;
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

    }

    public boolean isAfter(CustomDateTime d) {

    }

    public static enum Month {
        JANUARY
    }
}
