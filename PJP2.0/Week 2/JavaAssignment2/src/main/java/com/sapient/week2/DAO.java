package com.sapient.week2;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;

public class DAO {
    private ArrayList<Transaction> transactions;
    private GeneralReader reader;
    private DateTimeFormatter dateFormat;

    public DAO() {
        this.reader = new GeneralReader();
        this.transactions = new ArrayList<Transaction>();
        this.dateFormat = DateTimeFormatter.ofPattern("MM/d/yyyy");
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void getReport(String fileName) throws Exception {
        Collections.sort(this.transactions, new CustomComp());
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Transaction t : this.transactions) {
            String record = t.getClientID() + ","+ t.getType() + ","+ t.getDate().format(this.dateFormat);
            if (t.isPriority()) record += ",Y,";
            else record += ",N,";
            record += Double.toString(t.getFee()) + "\n";
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

        this.transactions = new ArrayList<Transaction>();
        for (String[] record : records) {
            Transaction newTransaction = new Transaction();
            newTransaction.setID(record[0]);
            newTransaction.setClientID(record[1]);
            newTransaction.setSecurityID(record[2].toUpperCase());
            newTransaction.setType(record[3].toUpperCase());
            newTransaction.setDate(LocalDate.parse(record[4], this.dateFormat));
            newTransaction.setValue(Double.parseDouble(record[5]));
            newTransaction.setPriority(false);
            if (record[6].equals("Y"))
                newTransaction.setPriority(true);
            this.transactions.add(newTransaction);
        }
    }
}