package com.sapient.week2;

public class Adder {
    public CustomDate addByUnit(CustomDate date, Integer valueToAdd, Integer unitType) {
        CustomDate newDate = new CustomDate();
        
        // days
        if (unitType == 0)
            newDate.setDate(date.getDate().plusDays(valueToAdd));

        // weeks
        else if (unitType == 1)
            newDate.setDate(date.getDate().plusWeeks(valueToAdd));

        // months
        else if (unitType == 2)
            newDate.setDate(date.getDate().plusMonths(valueToAdd));

        // years
        else if (unitType == 3)
            newDate.setDate(date.getDate().plusYears(valueToAdd));

        // else throw new Exception("Invalid temporal unit for operation. Allowed: days(0), weeks(1), months(2) and years(3) only.");
        return newDate;
    }
}
