package com.sapient.week2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HistoryStore {
	private Session session;
	private String sessionID;
	
	public HistoryStore() {
		Configuration cfg = new Configuration().addAnnotatedClass(com.sapient.week2.CalcOperation.class);	
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		this.session = sessionFactory.openSession();
		this.sessionID = this.session.toString();
	}

    public void addRecord(CalcOperation op) throws Exception {
//    	CalcOperation op = new CalcOperation();
//    	
//        for (String key : calc.keySet()) {
//        	String funcKey = key.substring(0, 1).toUpperCase() + key.substring(1);
//        	Statement stmt = new Statement(op, "set" + funcKey, new Object[]{calc.get(key)});
//        	stmt.execute();
//        }

        this.session.beginTransaction();
        this.session.save(op);
		this.session.getTransaction().commit();
    }

    public void showNRecentRecords(Integer numRecordsToShow, Boolean writeToFile) throws Exception {
        String content = "";
        Query q = this.session.createQuery("FROM CalcOperation ORDER BY id DESC").setMaxResults(numRecordsToShow);
        for (Object ob : q.getResultList()) {
        	for (int i = 0; i < 100; i++) System.out.print("#");
        	CalcOperation op = (CalcOperation)ob;
        	System.out.println();
        	System.out.println(op);
        	System.out.println();
        	if (writeToFile)
        		content = op.toCSV() + "\n" + content;
        }
        
        
        if (writeToFile) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a path to store history file at:");
            String path = scan.nextLine();
            
            String fileName = "records" + "_" + this.sessionID +".csv";
            if (!((Character)path.charAt(path.length() - 1)).equals((Character)'/'))
            	fileName = "/" + fileName;
            
            File file = new File(path + fileName);
            if (!file.exists())
            	file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.close();
        }
    }
}
