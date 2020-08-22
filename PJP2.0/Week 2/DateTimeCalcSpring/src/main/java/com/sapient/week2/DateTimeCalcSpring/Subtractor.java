package com.sapient.week2.DateTimeCalcSpring;

import java.time.Period;

import org.springframework.stereotype.Service;

@Service
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
        
        else {
        	System.out.println("Unit Types: Day (0), Week (1), Month (2), Year(3)");
        	return date;
        }
        return newDate;
    }

    public Period subtractDate(CustomDate date1, CustomDate date2) {
        if (date1.getDate().isBefore(date2.getDate()))
            return Period.between(date1.getDate(), date2.getDate());
        return Period.between(date2.getDate(), date1.getDate());
    }
}