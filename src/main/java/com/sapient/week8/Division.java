package com.sapient.week8;

public class Division 
{
    public int divide(int x, int y) {
        try {
            return x / y;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
}
