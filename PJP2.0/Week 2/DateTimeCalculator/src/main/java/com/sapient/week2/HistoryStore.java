package com.sapient.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Timestamp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class HistoryStore {
    // each calculation stored as a hashmap
    private ArrayList<HashMap<String, String>> history;
    private Integer capacity;
    private Timestamp timestamp;

    public HistoryStore() {
        this.history = new ArrayList<HashMap<String, String>>();
        this.capacity = 100;

        // timestamp for a session
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public void addRecord(HashMap<String, String> calc) {
        if (this.history.size() >= this.capacity) {
            this.history.remove(this.history.size() - 1);
        }
        this.history.add(0, calc);
    }

    public void showNRecentRecords(Integer numRecordsToShow, Boolean writeToFile) throws Exception {
        String content = "";
        for (int i = 0; i < Math.min(this.capacity, numRecordsToShow); i++) {
            if (i >= this.history.size()) break;

            if (writeToFile) {
            	content += this.history.get(i).toString() + "\n";
//                content += String.join(",", this.history.get(i).values()) + '\n';
            }
            else
                System.out.println(this.history.get(i));
        }

        if (writeToFile) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a path to store history file at:");
            String path = scan.nextLine();

            File file = new File(path + "/records" + "_" + this.timestamp +".txt");
            file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.close();
        }
    }
}
