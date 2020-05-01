package com.sapient.week4;

import java.io.*; 
import java.util.*;
import java.lang.reflect.*;

public class Calc 
{
    interface Num_Process {
        int cal(int a, int b);
    }

    public int executeOp(int a, int b, Num_Process op) {
        return op.cal(a, b);
    }

    public Num_Process add() {
        Num_Process exp = (x, y) -> x + y;
        return exp;
    }

    public Num_Process subtract() {
        Num_Process exp = (x, y) -> x - y;
        return exp;
    }

    public Num_Process multiply() {
        Num_Process exp = (x, y) -> x * y;
        return exp;
    }

    public Num_Process divide() {
        Num_Process exp = (x, y) -> x / y;
        return exp;
    }

    public static void main( String[] args ) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Calc ob = new Calc();

        System.out.println("Enter the two integers (a, then b):");
        int a = Integer.parseInt(Reader.in.nextLine());
        int b = Integer.parseInt(Reader.in.nextLine());

        System.out.println("For addition: enter add.");
        System.out.println("For subtraction: enter subtract.");
        System.out.println("For multiplication: enter multiply.");
        System.out.println("For division: enter divide.");

        System.out.println("Enter choice:");
        String op = Reader.in.nextLine();
        Num_Process opObj = (Num_Process) Calc.class.getMethod(op).invoke(ob);
        System.out.println("Answer: " + ob.executeOp(a, b, opObj));
    }
}
