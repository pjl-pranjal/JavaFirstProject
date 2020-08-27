package com.sapient.week2;

import java.time.Period;
import java.util.HashMap;

public class DateTimeCalculator {
    private CustomDate inputDate;
    private Adder adder;
    private Subtractor subtractor;
    private NaturalLangEngine nlEngine;
    private DayOfWeekName dayName;
    private WeekNumber weekFinder;

    private HistoryStore historyStore;

    public DateTimeCalculator() {
        this.setCurrentDate();
        this.adder = new Adder();
        this.subtractor = new Subtractor();
        this.nlEngine = new NaturalLangEngine();
        this.dayName = new DayOfWeekName();
        this.weekFinder = new WeekNumber();
        this.historyStore = new HistoryStore();
    }

    public void showCurrentStoredDate() {
        System.out.println("Date you're currently operating on -> " + this.inputDate);
    }

    public void setCurrentDate() {
        this.inputDate = new CustomDate();
        this.showCurrentStoredDate();
    }

    public void setCurrentDate(Integer day, Integer month, Integer year) {
        try {
            this.inputDate = new CustomDate(day, month, year);
        } catch (Exception e) {
            System.out.println("Exception! " + e.getMessage());
            return;
        }
        this.showCurrentStoredDate();
    }

    public void computeFromNLPhrase(String phrase) {
        HashMap<String, String> record = new HashMap<String, String>();
        record.put("type", "nl");
        record.put("input", this.inputDate.toString());
        record.put("phrase", phrase);

        try {
            this.nlEngine.computeFromNLPhrase(phrase.toLowerCase());
            this.inputDate = this.nlEngine.result;
            System.out.println(phrase + ":");
        } catch (Exception e) {
            System.out.println("Exception! " + e.getMessage());
            return;
        }
        this.showCurrentStoredDate();

        record.put("output", this.inputDate.toString());
        try {
        	this.historyStore.addRecord(record);
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void add(Integer valueToAdd, Integer unitType) {
        HashMap<String, String> record = new HashMap<String, String>();
        record.put("type", "add");
        record.put("input", this.inputDate.toString());
        record.put("value", Integer.toString(valueToAdd));
        record.put("unitType", Integer.toString(unitType));

        if (unitType <= 3 && unitType >= 0)
            this.inputDate = this.adder.addByUnit(this.inputDate, valueToAdd, unitType);
        else return;
        this.showCurrentStoredDate();

        record.put("output", this.inputDate.toString());
        try {
        	this.historyStore.addRecord(record);
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void subtract(Integer valueToSubtract, Integer unitType) {
        HashMap<String, String> record = new HashMap<String, String>();
        record.put("type", "subtract");
        record.put("input", this.inputDate.toString());
        record.put("value", Integer.toString(valueToSubtract));
        record.put("unitType", Integer.toString(unitType));

        if (unitType <= 3 && unitType >= 0)
            this.inputDate = this.subtractor.subtractByUnit(this.inputDate, valueToSubtract, unitType);
        else return;
        this.showCurrentStoredDate();

        record.put("output", this.inputDate.toString());
        try {
        	this.historyStore.addRecord(record);
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void subtract(CustomDate date) {
        HashMap<String, String> record = new HashMap<String, String>();
        record.put("type", "subtract-duration");
        record.put("input", this.inputDate.toString());
        record.put("input1", date.toString());

        Period timeBetween = this.subtractor.subtractDate(this.inputDate, date);
        System.out.println("Between " + this.inputDate + " and " + date + " there are:");
        System.out.println(Integer.toString(timeBetween.getDays()) + " days or " + Double.toString(timeBetween.getDays()/7.0) + " weeks");
        System.out.println(Integer.toString(timeBetween.getMonths()) + " months");
        System.out.println(Integer.toString(timeBetween.getYears()) + " years");
        this.showCurrentStoredDate();

        record.put("output", timeBetween.toString());
        try {
        	this.historyStore.addRecord(record);
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void getDayName() {
        HashMap<String, String> record = new HashMap<String, String>();
        record.put("type", "day-name");
        record.put("input", this.inputDate.toString());

        String name = this.dayName.getDayName(this.inputDate);
        System.out.println(name);
        this.showCurrentStoredDate();

        record.put("output", name);
        try {
        	this.historyStore.addRecord(record);
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void getWeekOfMonth() {
        HashMap<String, String> record = new HashMap<String, String>();
        record.put("type", "week-num");
        record.put("input", this.inputDate.toString());

        Integer weekNum = this.weekFinder.weekNumber(this.inputDate);
        System.out.println("Week number: " + Integer.toString(weekNum));
        this.showCurrentStoredDate();

        record.put("output", Integer.toString(weekNum));
        try {
        	this.historyStore.addRecord(record);
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void showNRecentRecords(Integer n, Boolean writeToFile) {
        try {
            this.historyStore.showNRecentRecords(n, writeToFile);
        } catch (Exception e) {
            System.out.println("Exception! " + e.getMessage());
            return;
        }
        System.out.println("Done.");
    }
}
