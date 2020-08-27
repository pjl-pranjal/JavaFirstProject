package com.sapient.week2;

public class App {
    public static void main(String args[]) {
        DateTimeCalculator dtc = new DateTimeCalculator();
        dtc.computeFromNLPhrase("1 year from now");
        dtc.computeFromNLPhrase("today");
        dtc.computeFromNLPhrase("tomorrow");
        dtc.computeFromNLPhrase("last month");
        dtc.showNRecentRecords(4, false);

        dtc.setCurrentDate(31, 1, 2020); // 31 Jan 2020
        // days(0), weeks(1), months(2) and years(3)
        dtc.subtract(1, 2); // subtract 1 month from current stored date
        dtc.add(1, 0); // add 1 day to current stored date
        dtc.subtract(new CustomDate()); // subtract to get duration b/w current stored date and a given date

        dtc.getDayName();
        dtc.getWeekOfMonth();

        dtc.showNRecentRecords(102, true);
    }
}
