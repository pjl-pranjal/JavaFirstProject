package com.sapient.week1;

/**
 * Hello world!
 *
 */
public class CheckEven 
{
    public static void main( String[] args )
    {
        CheckEven checker = new CheckEven();
        if (checker.check(2))
            System.out.println( "Even number found!" );
        else
            System.out.println( "Even number not found!" );
    }

    public Boolean check( int n )
    {
        if (n % 2 == 0)
            return true;
        return false;
    }
}
