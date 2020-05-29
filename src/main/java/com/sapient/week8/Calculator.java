package com.sapient.week8;

import java.util.Scanner;

public class Calculator 
{
    private int x, y, result;

    // Single Responsibility classes
    private Addition adder = new Addition();
    private Subtraction subtractor = new Subtraction();
    private Multiplication multiplier = new Multiplication();
    private Division divider = new Division();

    public void getInput() {
        Scanner read = new Scanner(System.in);

        System.out.println("Enter x and y:");
        this.x = Integer.parseInt(read.nextLine());
        this.y = Integer.parseInt(read.nextLine());
        // read.close();
    }

    public void showResult() {
        System.out.println("X = " + this.x + ", Y = " + this.y);
        System.out.println("Current result: " + this.result);
    }

    public void add() {
        this.result = this.adder.add(this.x, this.y);
        this.showResult();
    }

    public void subtract() {
        this.result = this.subtractor.subtract(this.x, this.y);
        this.showResult();
    }

    public void multiply() {
        this.result = this.multiplier.multiply(this.x, this.y);
        this.showResult();
    }

    public void divide() {
        this.result = this.divider.divide(this.x, this.y);
        this.showResult();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
