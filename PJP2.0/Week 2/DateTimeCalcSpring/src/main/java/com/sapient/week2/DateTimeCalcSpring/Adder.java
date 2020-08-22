package com.sapient.week2.DateTimeCalcSpring;

import org.springframework.stereotype.Service;

@Service
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

        else {
        	System.out.println("Unit Types: Day (0), Week (1), Month (2), Year(3)");
        	return date;
        }
        return newDate;
    }
}