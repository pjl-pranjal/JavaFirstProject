package com.sapient.week4;

import java.io.*; 
import java.util.*;

public class Matrix 
{
    int[][] mat;

    public Matrix() {
        this.mat = new int[3][3];
    }

    public Matrix(int row, int col) {
        this.mat = new int[row][col];
    }

    private void copyMat(int[][] matObj) {
        for (int i = 0; i < matObj.length; i++) {
            for (int j = 0; j < matObj[i].length; j++) {
                this.mat[i][j] = matObj[i][j];
            }
        }
    }

    public Matrix(int[][] matObj) {
        if (matObj.length == 0) {
            System.out.println("Empty Matrix");
            this.mat = new int[0][0];
            return;
        }

        this.mat = new int[matObj.length][matObj[0].length];
        copyMat(matObj);
    }

    public Matrix(Matrix ob) {
        if (ob.mat.length == 0) {
            System.out.println("Empty Matrix");
            this.mat = new int[0][0];
            return;
        }

        this.mat = new int[ob.mat.length][ob.mat[0].length];
        copyMat(ob.mat);
    }

    public void read() {
        if (this.mat.length == 0) {
            this.mat = new int[0][0];
            return;
        }

        System.out.println("Enter values row-wise:");
        for (int i = 0; i < this.mat.length; i++) {
            for (int j = 0; j < this.mat[i].length; j++) {
                this.mat[i][j] = Reader.in.nextInt();
            }
        }
    }

    public void display() {
        for (int[] row : this.mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] addMat(int[][] matObj) {
        /* this.mat treated as "first" */

        int[][] result = new int[this.mat.length][this.mat[0].length];
        for (int i = 0; i < this.mat.length; i++) {
            for (int j = 0; j < this.mat[i].length; j++) {
                result[i][j] = this.mat[i][j] + matObj[i][j];
            }
        }
        return result;
    }

    public int[][] addMat(Matrix ob) {
        return addMat(ob.mat);
    }

    public int[][] mulMat(int[][] matObj) {
        /* this.mat treated as "first" */

        int[][] result = new int[this.mat.length][matObj[0].length];

        int sum = 0;
        for (int i = 0; i < this.mat.length; i++) {
            for (int j = 0; j < matObj[0].length; j++) {
                for (int k = 0; k < matObj.length; k++) {
                    sum += this.mat[i][k] * matObj[k][j];
                }

                result[i][j] = sum;
                sum = 0;
            }
        }

        return result;
    }

    public int[][] mulMat(Matrix ob) {
        return mulMat(ob.mat);
    }

    public Boolean isScalar() {
        if (this.mat.length != this.mat[0].length) {
            return false;
        }

        int diagonalVal = this.mat[0][0];
        for (int i = 0; i < this.mat.length; i++) {
            for (int j = 0; j < this.mat[i].length; j++) {
                if (i == j) {
                    if (diagonalVal != this.mat[i][j])
                        return false;
                }
                else if (this.mat[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main( String[] args ) {
        System.out.println("ob:");
        Matrix ob = new Matrix(3, 2);
        ob.read();
        ob.display();

        System.out.println("ob1:");
        Matrix ob1 = new Matrix(2, 4);
        ob1.read();
        ob1.display();

        System.out.println("Product:");
        Matrix product = new Matrix(ob.mulMat((ob1)));
        product.display();

        System.out.println("Check Scalar:");
        Matrix ob2 = new Matrix();
        ob2.read();
        if (ob2.isScalar())
            System.out.println(("ob2 is scalar!"));
        else
            System.out.println(("ob2 is not scalar!"));
    }
}
