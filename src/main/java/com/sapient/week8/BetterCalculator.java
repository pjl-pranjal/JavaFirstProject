package com.sapient.week8;

import java.util.Scanner;

public class BetterCalculator extends Calculator
{
    // Liskov: can replace superclass with subclass without breaking application
    // Here, we can use BetterCalculator instead of Calculator and all previous
    // functionality will still work.
    
    private Power powOb = new Power();

    public void getPow() {
        this.setResult(this.powOb.getPow(this.getX(), this.getY()));
        this.showResult();
    }
}
