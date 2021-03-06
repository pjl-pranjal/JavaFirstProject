package com.sapient.week2;

import java.time.Period;

public class Subtractor {
    public CustomDate subtractByUnit(CustomDate date, Integer valueToSubtract, Integer unitType) {
        CustomDate newDate = new CustomDate();
        
        // days
        if (unitType == 0)
            newDate.setDate(date.getDate().minusDays(valueToSubtract));

        // weeks
        else if (unitType == 1)
            newDate.setDate(date.getDate().minusWeeks(valueToSubtract));

        // months
        else if (unitType == 2)
            newDate.setDate(date.getDate().minusMonths(valueToSubtract));

        // years
        else if (unitType == 3)
            newDate.setDate(date.getDate().minusYears(valueToSubtract));
        
        // else throw new Exception("Invalid temporal unit for operation. Allowed: days(0), weeks(1), months(2) and years(3) only.");
        return newDate;
    }

    public Period subtractDate(CustomDate date1, CustomDate date2) {
        if (date1.getDate().isBefore(date2.getDate()))
            return Period.between(date1.getDate(), date2.getDate());
        return Period.between(date2.getDate(), date1.getDate());
    }
}
