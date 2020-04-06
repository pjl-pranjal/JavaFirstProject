package com.sapient.week1;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private CheckEven checker = new CheckEven();

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    // @Test
    public void test1()
    {
        assertFalse( checker.check(1) );
    }

    // @Test
    public void test2()
    {
        assertTrue( checker.check(2) );
    }

    // @Test
    public void test3()
    {
        assertFalse( checker.check(3) );
    }

    // @Test
    public void test4()
    {
        assertTrue( checker.check(4) );
    }
}
