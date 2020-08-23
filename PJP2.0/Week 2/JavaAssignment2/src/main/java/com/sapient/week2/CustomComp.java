package com.sapient.week2;

import java.util.Comparator;

public class CustomComp implements Comparator<Transaction> {

    @Override
    public int compare(Transaction a, Transaction b) {
        if (a.getClientID().equals(b.getClientID())) {
            if (a.getType().equals(b.getType())) {
                if (a.getDate().equals(b.getDate())) {
                    return a.getPriority().compareTo(b.getPriority());
                }
                return a.getDate().compareTo(b.getDate());
            }
            return a.getType().compareTo(b.getType());
        }
        return a.getClientID().compareTo(b.getClientID());
    }
}