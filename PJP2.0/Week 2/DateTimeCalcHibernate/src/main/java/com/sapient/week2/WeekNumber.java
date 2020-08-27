package com.sapient.week2;

public class WeekNumber {
    // which week in a month is `date` in. Dividing each month in 4 weeks.
    public Integer weekNumber(CustomDate date) {
        Integer dayNumber = date.getDate().getDayOfMonth();
        if (dayNumber <= 7) return 1; // week 1
        else if (dayNumber <= 14) return 2;
        else if (dayNumber <= 21) return 3;
        return 4;
    }
}
