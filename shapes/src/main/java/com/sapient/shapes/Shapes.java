package com.sapient.shapes;

public class Shapes
{
    int numberOfSides;
    
    public static void main( String[] args ) {
        Shapes shapesObj = new Shapes();
        int sideLength;

        // Test 1
        shapesObj.numberOfSides = 3;
        sideLength = 12;
        shapesObj.calculateShapeArea(shapesObj.numberOfSides, sideLength);

        // Test 2
        shapesObj.numberOfSides = 4;
        sideLength = 15;
        shapesObj.calculateShapeArea(shapesObj.numberOfSides, sideLength);

        // Test 3
        shapesObj.numberOfSides = 5;
        sideLength = 15;
        shapesObj.calculateShapeArea(shapesObj.numberOfSides, sideLength);
    }

    public void calculateShapeArea(int numberOfSides, int sideLength) {
        if (numberOfSides == 1) {
            Circle circle = new Circle();
            circle.calculateArea(sideLength);
        }
        else if (numberOfSides == 3) {
            Triangle triangle = new Triangle();
            triangle.calculateArea(sideLength);
        }
        else if (numberOfSides == 4) {
            Square square = new Square();
            square.calculateArea(sideLength);
        }
        else {
            System.out.println("No Shapes Present.");
        }
    }
}
