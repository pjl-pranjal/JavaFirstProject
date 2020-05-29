package com.sapient.week8;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberTest
{
    private com.sapient.week8.Number numberOb = new com.sapient.week8.Number();

    // checking prime case
    @Test
    public void test1() {
        assertEquals(1, numberOb.checkPrime(2));
    }

    // checking non-prime case
    @Test
    public void test2() {
        assertEquals(0, numberOb.checkPrime(20));
    }

    // valid armstrong number
    @Test
    public void test3() {
        assertTrue(numberOb.checkArmstrong(153));
    }

    // inalid armstrong number
    @Test
    public void test4() {
        assertFalse(numberOb.checkArmstrong(154));
    }

    // valid palindrome
    @Test
    public void test5() {
        assertTrue(numberOb.checkPalindrome(11511));
    }

    // invalid palindrome
    @Test
    public void test6() {
        assertFalse(numberOb.checkPalindrome(4143));
    }

    // non-functional reliability, input validity test for prime, "<= 1" case
    @Test
    public void test7() {
        assertEquals(0, numberOb.checkPrime(1));
        assertEquals(0, numberOb.checkPrime(-1));
    }

    // non-functional reliability, output validity test for armstrong
    @Test
    public void test8() {
        assertNotNull(numberOb.checkArmstrong(153));
        assertNotNull(numberOb.checkArmstrong(154));
    }

    // non-functional reliability, output validity test for palindrome
    @Test
    public void test9() {
        assertNotNull(numberOb.checkPalindrome(11511));
        assertNotNull(numberOb.checkPalindrome(4143));
    }
}
