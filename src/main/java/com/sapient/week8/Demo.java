package com.sapient.week8;

public class Demo 
{
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.getInput();
        calc.add();
        calc.subtract();
        calc.multiply();
        calc.divide();

        // Liskov: can replace superclass with subclass without breaking application
        // Here, we can use BetterCalculator instead of Calculator and all previous
        // functionality will still work.
        BetterCalculator calc1 = new BetterCalculator();
        calc1.getInput();
        calc1.add();
        calc1.subtract();
        calc1.multiply();
        calc1.divide();
        calc1.getPow();
    }
}
