import java.lang.System;
import java.lang.Integer;
import java.util.ArrayList;

public class Primes
{
    // Search for primes number below n
    // @param n the upper value
    // @return an array containing the resulting primes numbers
       
    public static int[] primes(int n)
    {
        int[] marks = new int[n-1];
        int i = 0;
        int p = 2;
        int j = 0;
        //init
        while(i < n - 1) {
            if(i == 0)
                marks[i] = 1;
            else if(i == 1)
                marks[i] = 1;
            else 
                marks[i] = 0;
            i += 1; 
        }
        //Mark multiples of p for each p < n
        while(p <= n) {
            marks = mark(marks, p);
            p += 1;
        }
        //primes the # of primes number to return
        i = 0;
        j = 0;
        while(i < n - 1) {
            if(marks[i] == 0)
                j += 1;
            i += 1;
        }
        //Build the primes tab
        int[] result = new int[j];
        i = 0;
        j = 0;
        while(i < marks.length) {
            if(marks[i] == 0) {
                result[j] = i;
                j += 1;
            }
            i += 1;
        }
        return result;
    }

    // Marks the multiples of p 
    // For j : 2 <= j < N, if j * p == i then marks[i] = 1 
    //     
    // @param marks the array containing the corresponding marks.
    // @param p the value to test
    
    public static int[] mark(int[] marks, int p)
    {   
        int i = 0;
        int value = 2 * p;
        while(i < marks.length) {
            if(value == i) {
                marks[i] = 1;
                value = value + p;
            }
            i += 1;
            
        }
        return marks;
        
    }
    public static void main(String[] args)
    {
        if(args.length == 0)
            System.out.println("Usage : java Primes n");
        else if(args.length > 1)
            System.out.println("Usage : java Primes n");
        else {
            int n = Integer.parseInt(args[0]);
            int[] a = primes(n);
            System.out.println("The primes numbers <= "+n+" are :");
            int i = 1;
            System.out.print("["+a[0]);
            while(i < a.length) {
                System.out.print(", "+a[i]);
                i += 1;
            }
            System.out.print("]\n");
        }
    }
}
