package pass;

public class ConditionalExpression
{
	public static void main(String[] args)
	{	
		int a = 42;
		int b = 666;
		(a > b) ? a = 42 : b = 42;
		true ? a = 42 : b = 42;
	}

}
