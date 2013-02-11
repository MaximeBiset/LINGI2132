import java.lang.System;
import java.lang.Integer;

public class Primes
{
    public static void main(String[] args)
    {
        if(args.length == 0)
            System.out.println("Usage : java Primes n");
        else if(args.length > 1)
            System.out.println("Usage : java Primes n");
        else {
            int n = Integer.parseInt(args[0]);
            System.out.println("The "+n+" first primes numbers are :");
        }
    }
}
