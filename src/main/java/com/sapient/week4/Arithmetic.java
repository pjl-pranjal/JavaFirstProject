package com.sapient.week4;

import java.io.*; 
import java.util.*;

public class Arithmetic 
{
    interface Num_Process {
        int cal(int a, int b);
    }

    public int executeOp(int a, int b, Num_Process op) {
        return op.cal(a, b);
    }

    public int run(int a, int b, int choice) {
        Num_Process exp = (x, y) -> x + y;
        return executeOp(a, b, exp);
    }

    public int run(int a, int b, float choice) {
        Num_Process exp = (x, y) -> x - y;
        return executeOp(a, b, exp);
    }

    public int run(int a, int b, Boolean choice) {
        Num_Process exp = (x, y) -> x * y;
        return executeOp(a, b, exp);
    }

    public int run(int a, int b) {
        Num_Process exp = (x, y) -> x / y;
        return executeOp(a, b, exp);
    }

    public static void main( String[] args ) {
        Arithmetic ob = new Arithmetic();

        System.out.println("Enter the two integers (a, then b):");
        int a = Reader.in.nextInt();
        int b = Reader.in.nextInt();

        System.out.println("For addition: enter an int.");
        System.out.println("For subtraction: enter a float.");
        System.out.println("For multiplication: enter a Boolean.");
        System.out.println("For division: enter anything else.");

        try {
            System.out.println("Answer: " + ob.run(a, b, Reader.in.nextInt()));
        } catch (InputMismatchException e) {
            try {
                System.out.println("Answer: " + ob.run(a, b, Reader.in.nextFloat()));
            } catch (InputMismatchException e1) {
                try {
                    System.out.println("Answer: " + ob.run(a, b, Reader.in.nextBoolean()));
                } catch (InputMismatchException e2) {
                    System.out.println("Answer: " + ob.run(a, b));
                }
            }
        }
    }
}
