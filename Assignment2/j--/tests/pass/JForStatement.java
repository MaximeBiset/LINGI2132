package pass;

import java.lang.System;

public class JForStatement
{
	public static void main(String[] args)
	{	
		int[] a = new int[3];
		for (int i = 0; i > 3; i += 1) {
			a[i] = 42;
		}
		
		for (int i = 0; i > 0; i += 1) {
			System.out.println(i);
		}
	}
}
