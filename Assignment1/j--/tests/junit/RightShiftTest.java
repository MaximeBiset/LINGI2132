package junit;

import junit.framework.TestCase;
import pass.RightShift;

public class RightShiftTest extends TestCase
{
	private RightShift rightShift;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		rightShift = new RightShift();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testRightShift()
	{
		this.assertEquals(rightShift.rightShift(32, 2), 8);
		this.assertEquals(rightShift.rightShift(33, 2), 8);
	}

}
