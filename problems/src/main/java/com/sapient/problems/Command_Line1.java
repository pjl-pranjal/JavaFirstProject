package com.sapient.problems;
import java.util.Scanner;
import java.util.Arrays;

public class Command_Line1 
{
    public int[] setData(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        return arr;
    }

    public void displayData(int[] arr) {
        System.out.println("Displaying Data...");
        System.out.printf(Arrays.toString(arr));
        System.out.println("");
    }

    public void calData(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        float avg = (float)sum/arr.length;
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + avg);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
