package pass;

public class ConditionalExpression
{
	public static void main(String[] args)
	{	
		int a = 42;
		int b = 666;
		
		a = ((a > b) ? (b = 666) : (b = 42));
	}

}
