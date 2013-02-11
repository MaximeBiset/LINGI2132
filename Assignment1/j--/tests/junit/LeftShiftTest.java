package junit;

import pass.LeftShift;
import junit.framework.TestCase;


public class LeftShiftTest extends TestCase
{
	private LeftShift leftShift;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		leftShift = new LeftShift();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testLeftShift()
	{
		this.assertEquals(leftShift.leftShift(42, 1), 84);
		this.assertEquals(leftShift.leftShift(2147483632, 1), -32);
	}
}
