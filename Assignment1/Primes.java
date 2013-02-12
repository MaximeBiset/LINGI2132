import java.lang.System;
import java.lang.Integer;
import java.util.ArrayList;

public class Primes
{
    // Search for primes number below n
    // @param n the upper value
    // @return an array containing the resulting primes numbers
       
    public static int[] compute(int n)
    {
        int[] a = new int[n-1];
        int[] marks = new int[n-1];
        int i = 0;
        int p = 2;
        int l = 0;
        int j = 0;
        //init
        while(i < n - 1) {
            a[i] = i+2;
            marks[i] = 0;
            i += 1; 
        }
        //Mark multiples of p
        while(p <= n) {
            marks = mark(a, marks, p);
            p += 1;
        }
        //Compute the size of primes number to return
        i = 0;
        while(i < n - 1) {
            if(marks[i] == 0)
                l += 1;
            i += 1;
        }
        //Build the primes tab
        int[] result = new int[l];
        i = 0;
        j = 0;
        while(i < marks.length) {
            if(marks[i] == 0) {
                result[j] = a[i];
                j += 1;
            }
            i += 1;
        }
        return result;
    }

    // Marks the multiples of p presents in the array a. 
    // For 2<i<n, if i*p == a[i] then marks[j] = 1 
    //     
    // @param a the array containing the numbers
    // @param marks the array containing the marking of the values inside a.
    // @param p the value to test
    
    public static int[] mark(int[] a, int[] marks, int p)
    {   
        int i = 0;
        int value = 2 * p;
        while(i < a.length) {
            if(value == a[i]) {
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
            int[] a = compute(n);
            System.out.println("The primes numbers <= "+n+" are :");
            int i = 0;
            while(i < a.length) {
                System.out.println(a[i]);
                i += 1;
            }
        }
    }
}
