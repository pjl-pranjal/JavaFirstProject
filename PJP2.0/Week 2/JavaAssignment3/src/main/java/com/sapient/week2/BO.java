package com.sapient.week2;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class BO {
    private HashMap<String, UnaryOperator<Double>> rates;

    public BO() {
        this.rates = new HashMap<String, UnaryOperator<Double>>();
        this.rates.put("inr", d -> d / 66.0);
        this.rates.put("gbp", d -> d / 0.67);
        this.rates.put("sgd", d -> d / 1.5);
        this.rates.put("sgp", d -> d / 1.5);
        this.rates.put("hkd", d -> d / 8.0);
        this.rates.put("usd", d -> d);
    }

    public ArrayList<Income> processIncomes(ArrayList<Income> incomes) {
        HashMap<String, Income> groupedIncomes = new HashMap<String, Income>();

        for (Income i : incomes) {
            i.setAmountUSD(this.rates.get(i.getCurrency()).apply(i.getAmount()));

            String topKey = i.getCountry();
            if (topKey.equals(""))
                topKey = i.getCity();
            topKey += i.getGender();

            Income incomeForRegion = groupedIncomes.get(topKey);
            if (incomeForRegion != null)
                incomeForRegion.setAmountUSD(incomeForRegion.getAmountUSD() + i.getAmountUSD());
            else
                groupedIncomes.put(topKey, i);
        }

        return new ArrayList<Income>(groupedIncomes.values());
    }
}