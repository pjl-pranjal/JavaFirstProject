package com.sapient.week2;

public class App {
    public static void main(String[] args) {
        try {
            DAO dao = new DAO();
            dao.readData(args[0], args[0].substring(args[0].length() - 3), Boolean.parseBoolean(args[2]));

            BO bo = new BO();
            bo.processFees(dao.getTransactions());

            dao.getReport(args[1]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}