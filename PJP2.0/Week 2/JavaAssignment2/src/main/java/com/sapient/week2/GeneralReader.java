package com.sapient.week2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GeneralReader {
    public ArrayList<String[]> readCSV(String filePath) throws Exception {
        ArrayList<String[]> records = new ArrayList<String[]>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        while (line != null) {
            records.add(line.split(","));
            line = br.readLine();
        }

        return records;
    }
}