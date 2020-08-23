package com.sapient.week2;

import java.util.HashMap;
import java.util.ArrayList;

public class BO {
    private HashMap<String, Transaction> history;
    private HashMap<String, Integer> charges;
    
    public BO() {
        this.history = new HashMap<String, Transaction>();

        this.charges = new HashMap<String, Integer>();
        this.charges.put("HighPriority", 500);
        this.charges.put("SellWithdraw", 100);
        this.charges.put("BuyDeposit", 50);
        this.charges.put("IntraDay", 10);
    }

    public void processFees(ArrayList<Transaction> transactions) {
        for (Transaction t : transactions) {
            if (t.isPriority())
                t.setFee(this.charges.get("HighPriority"));
            else if (t.getType().equals("SELL") || t.getType().equals("WITHDRAW"))
                t.setFee(this.charges.get("SellWithdraw"));
            else
                t.setFee(this.charges.get("BuyDeposit"));

            String superKey = t.getClientID() + t.getSecurityID() + t.getDate().toString();
            this.history.put(superKey + t.getType(), t);

            String oppType = null;
            if (t.getType().equals("BUY")) oppType = "SELL";
            else if (t.getType().equals("SELL")) oppType = "BUY";
            if (oppType == null) continue;

            if (this.history.containsKey(superKey + oppType)) {
                Transaction intra = this.history.get(superKey + oppType);
                intra.setFee(intra.getFee() + this.charges.get("IntraDay"));
                t.setFee(t.getFee() + this.charges.get("IntraDay"));
            }
        }
    }
}