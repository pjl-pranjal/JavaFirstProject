package com.sapient.shapes;

public class Triangle
{
    public double calculateArea(int Sides) {
        double area = 0.433 * Sides * Sides;
        System.out.println("The Area of the Triangle is " + area);
        return area;
    }
}
