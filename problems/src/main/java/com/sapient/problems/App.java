package com.sapient.problems;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        System.out.println("Running Command_Line1...");
        Command_Line1 obj = new Command_Line1();
        int[] arr = obj.setData(args);
        obj.displayData(arr);
        obj.calData(arr);
        System.out.println("");

        System.out.println("Running KeyRead_Line2...");
        KeyRead_Line2 obj1 = new KeyRead_Line2();
        int[] arr1 = obj1.Read();
        obj1.display(arr1);
        System.out.println("Finding 4: " + obj1.find(arr1, 4));
        obj1.sort(arr1);
        obj1.display(arr1);
        System.out.println("");

        System.out.println("Running FigToWord...");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(FigToWord.fig_to_words(x));
    }
}
