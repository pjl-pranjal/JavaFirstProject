package com.sapient.week2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomDate {
    private LocalDate date;

    public CustomDate() {
        this.date = LocalDate.now();
    }

    public CustomDate(LocalDate date) {
        this.date = date;
    }

    public CustomDate(Integer day, Integer month, Integer year) throws DateTimeParseException {
        this.date = LocalDate.of(year, month, day);
    }

    public LocalDate getDate() {
		return this.date;
	}

    public void setDate(LocalDate newDate) {
		this.date = newDate;
	}

	public void setDate(Integer day, Integer month, Integer year) {
		this.date = LocalDate.of(year, month, day);
	}

    @Override
    public boolean equals(Object o) {
        return ((CustomDate)o).getDate().equals(this.getDate());
    }
    
    @Override
    public String toString() {
        return "{" +
            " date='" + this.getDate().toString() + "'" +
            "}";
    }
}
