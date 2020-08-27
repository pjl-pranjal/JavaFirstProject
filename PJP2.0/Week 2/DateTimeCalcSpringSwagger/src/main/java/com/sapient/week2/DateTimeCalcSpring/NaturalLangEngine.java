package com.sapient.week2.DateTimeCalcSpring;

import java.util.HashMap;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

@Service
public class NaturalLangEngine {
    public CustomDate result;
    private HashMap<String, Consumer<Integer>> dictionary;
    private Adder adder;
    private Subtractor subtractor;

    public NaturalLangEngine() {
        this.adder = new Adder();
        this.subtractor = new Subtractor();

        this.dictionary = new HashMap<String, Consumer<Integer>>();
        this.dictionary.put("today", (Integer n) -> this.result = new CustomDate());
        this.dictionary.put("tomorrow", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), 1, 0));
        this.dictionary.put("day after tomorrow", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), 2, 0));
        this.dictionary.put("yesterday", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), 1, 0));
        this.dictionary.put("day before yesterday", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), 2, 0));
        this.dictionary.put("last week", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), 1, 1));
        this.dictionary.put("previous week", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), 1, 1));
        this.dictionary.put("next week", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), 1, 1));
        this.dictionary.put("next month", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), 1, 2));
        this.dictionary.put("next year", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), 1, 3));
        this.dictionary.put("last month", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), 1, 2));
        this.dictionary.put("last year", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), 1, 3));
        this.dictionary.put("month after", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), 1, 2));
        this.dictionary.put("month before", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), 1, 2));
        this.dictionary.put("weeks from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 1));
        this.dictionary.put("week from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 1));
        this.dictionary.put("days from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 0));
        this.dictionary.put("day from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 0));
        this.dictionary.put("months from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 2));
        this.dictionary.put("month from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 2));
        this.dictionary.put("years from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 3));
        this.dictionary.put("year from now", (Integer n) -> this.result = this.adder.addByUnit(new CustomDate(), n, 3));
        this.dictionary.put("days earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 0));
        this.dictionary.put("day earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 0));
        this.dictionary.put("weeks earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 1));
        this.dictionary.put("week earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 1));
        this.dictionary.put("months earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 2));
        this.dictionary.put("month earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 2));
        this.dictionary.put("years earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 3));
        this.dictionary.put("year earlier", (Integer n) -> this.result = this.subtractor.subtractByUnit(new CustomDate(), n, 3));
    }

    public void computeFromNLPhrase(String phrase) throws Exception {
        String[] tokens = phrase.split("\\s+", 2);
        if (tokens[0].matches("\\d+") && this.dictionary.containsKey(tokens[1])) {
            this.dictionary.get(tokens[1]).accept(Integer.parseInt(tokens[0]));
            return;
        }
        else if (this.dictionary.containsKey(phrase)) {
            this.dictionary.get(phrase).accept(0);
            return;
        }
        throw new Exception("Couldn't understand phrase.");
    }
}