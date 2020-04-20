package com.sapient.problems;
import java.util.Scanner;
import java.util.Arrays;

public class KeyRead_Line2 
{
    public int[] Read()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter numbers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        return arr;
    }
    
    public void sort(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Sorted!");
    }

    public int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }

        return -1;
    }

    public void display(int[] arr) {
        System.out.println("Displaying Data...");
        System.out.printf(Arrays.toString(arr));
        System.out.println("");
    }
}
