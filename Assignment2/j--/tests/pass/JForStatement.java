package pass;

import java.lang.System;

public class JForStatement
{
	public static void main(String[] args)
	{	
		int a = {1, 2, 3};
		for (int i : a) {
			System.out.println(a);
		}
		for (final int j = 0; j > 0; j += 1) {
			System.out.println(j);
		}
	}
}
