package com.sapient.week2;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;

public class DAO {
    private ArrayList<Income> incomes;
    private GeneralReader reader;

    public DAO() {
        this.reader = new GeneralReader();
        this.incomes = new ArrayList<Income>();
    }

    public ArrayList<Income> getIncomes() {
        return this.incomes;
    }

    public void setIncomes(ArrayList<Income> incomes) {
        this.incomes = incomes;
    }

    public void getReport(String fileName) throws Exception {
        Collections.sort(this.incomes, new CustomComp());
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Income i : this.incomes) {
            String record = "";
            if (!i.getCountry().equals("")) record += i.getCountry();
            else record += i.getCity();
            record += "," + i.getGender() + "," + i.getAmountUSD() + "\n";
            writer.write(record);
        }
        writer.close();
    }

    public void readData(String filePath, String fileType, Boolean headerIncluded) throws Exception {
        ArrayList<String[]> records = new ArrayList<String[]>();
        if (fileType.toLowerCase().equals("csv")) {
            records = this.reader.readCSV(filePath);
        }

        if (headerIncluded) records.remove(0);

        this.incomes = new ArrayList<Income>();
        for (String[] record : records) {
            Income newIncome = new Income();
            newIncome.setCity(record[0].toLowerCase());
            newIncome.setCountry(record[1].toLowerCase());
            newIncome.setGender(record[2].toLowerCase());
            newIncome.setCurrency(record[3].toLowerCase());
            newIncome.setAmount(Double.parseDouble(record[4]));
            this.incomes.add(newIncome);
        }
    }
}