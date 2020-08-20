package com.sapient.week2;

import java.util.Locale;
import java.time.format.TextStyle;

public class DayOfWeekName {
    public String getDayName(CustomDate date) {
        return date.getDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
