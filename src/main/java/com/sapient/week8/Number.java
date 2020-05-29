package com.sapient.week8;

public class Number 
{
    public int checkPrime(int x) {
        if (x <= 1) return 0;

        for (int i = 2; i <= x/2; i++) {
            if (x%i == 0) return 0;
        }
        return 1;
    }

    public Boolean checkArmstrong(int x) {
        int copyX = x;
        int orderOfX = Integer.toString(x).length();

        int armstrongValue = 0, currentDigit;
        while (x != 0) {
            currentDigit = x%10;
            armstrongValue += Math.pow(currentDigit, orderOfX);
            x = x/10;
        }

        if (armstrongValue == copyX) return true;
        return false;
    }

    public Boolean checkPalindrome(int x) {
        String stringX = Integer.toString(x);

        int i = 0, j = stringX.length() - 1;
        while (i < j) {
            if (stringX.charAt(i) != stringX.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
