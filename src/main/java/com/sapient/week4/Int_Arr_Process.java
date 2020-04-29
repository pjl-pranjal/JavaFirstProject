package com.sapient.week4;

import java.io.*; 
import java.util.*;

public class Int_Arr_Process 
{
    int[] arr;

    public Int_Arr_Process() {
        this.arr = new int[10];
    }

    public Int_Arr_Process(int arrSize) {
        this.arr = new int[arrSize];
    }

    public Int_Arr_Process(int[] intArr) {
        this.arr = new int[intArr.length];

        for (int i = 0; i < intArr.length; i++) {
            this.arr[i] = intArr[i];
        }
    }

    public Int_Arr_Process(Int_Arr_Process obj) {
        this.arr = new int[obj.arr.length];

        for (int i = 0; i < obj.arr.length; i++) {
            this.arr[i] = obj.arr[i];
        }
    }

    public void read() {
        System.out.println("Enter size of array:");
        int n = Reader.in.nextInt();

        System.out.println("Enter values:");
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Reader.in.nextInt();
        }
    }

    public void display() {
        System.out.println("Display how? (1 = Vertical, 0 = Horizontal)");
        int decision = Reader.in.nextInt();

        System.out.println("Array:");
        if (decision == 1) {
            for (int i = 0; i < this.arr.length; i++){
                System.out.println(this.arr[i]);
            }
        }
        else {
            System.out.println(Arrays.toString(this.arr));
        }
    }

    public void sortArr() {
        Arrays.sort(this.arr);
    }

    public void findMinMax() {
        if (this.arr.length == 0) {
            System.out.println("No elements in array!");
            return;
        }

        int min = this.arr[0];
        int max = this.arr[0];
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] < min) {
                min = this.arr[i];
            }

            if (this.arr[i] > max) {
                max = this.arr[i];
            }
        }
        
        System.out.println("Max = " + max + ", Min = " + min);
    }

    public int findSum() {
        if (this.arr.length == 0) {
            System.out.println("No elements in array!");
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < this.arr.length; i++) {
            sum += this.arr[i];
        }

        return sum;
    }

    public Boolean hasSecondBiggest() {
        if (this.arr.length == 0) {
            System.out.println("No elements in array!");
            return false;
        }

        int max = this.arr[0];
        int maxIndex = 0;
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] > max) {
                max = this.arr[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < this.arr.length; i++) {
            if (i == maxIndex) {
                continue;
            }
            if (this.arr[i] == max) {
                return true;
            }
        }
        return false;
    }

    public static void main( String[] args ) {
        System.out.println("Ob:");
        Int_Arr_Process ob = new Int_Arr_Process();
        ob.read();
        ob.display();
        ob.findMinMax();
        ob.sortArr();
        ob.display();
        if (ob.hasSecondBiggest())
            System.out.println("Has second biggest!");
        else
            System.out.println("No second biggest!");
        System.out.println(ob.findSum());

        System.out.println("Ob1:");
        Int_Arr_Process ob1 = new Int_Arr_Process(ob);
        ob1.display();
    }
}
