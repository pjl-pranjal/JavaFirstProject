package com.sapient.shapes;

public class Circle
{
    public double calculateArea(int Radius) {
        double area = 3.14 * Radius * Radius;
        System.out.println("The Area of the Circle is " + area);
        return area;
    }
}
