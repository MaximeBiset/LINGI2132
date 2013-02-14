//Modulo.java

package pass;

public class Modulo 
{
	public int modulo(int x, int y)
	{	
		return x % y;
	}
	
	public int priorityLeft(int x, int y, int z)
	{
		return x + y % z;
	}
	
	public int priorityRight(int x, int y, int z)
	{
		return x % y + z;
	}
}
