package pass;

import java.lang.System;

public class JForStatement
{
	public static void main(String[] args)
	{	int i;
		int a = {1, 2, 3};
		for(i = 0; i < 4; i += 1){
			System.out.println(i);
		}
		for(int j = 0; j < 5; j += 1) {
			System.out.println(j);
		}
		for(int k : a) {
			System.out.println(k);
		}
		for(int a,b,c,d ; i > 2 ; ++a,++b,++c) {
			System.out.println(a*b);
		}
	}
}
