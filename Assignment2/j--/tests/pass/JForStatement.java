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
		for (int b : a) {
			System.out.println(b);
		}
		
		/*for (final int j = 0; j > 0; j += 1) {
			System.out.println(j);
		}
		
		for(int a,b,c,d = 0; a = 0; b += 1) {
			System.out.println(c);
		}
		for(;;){
			System.out.println("blah");
		}*/
	}
}
