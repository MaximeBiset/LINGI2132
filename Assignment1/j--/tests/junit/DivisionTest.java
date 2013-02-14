package junit;

import junit.framework.TestCase;
import pass.Division;

public class DivisionTest extends TestCase
{
	private Division division;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		division = new Division();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testDivide()
	{
		this.assertEquals(division.divide(0, 42), 0);
		this.assertEquals(division.divide(42, 1), 42);
		this.assertEquals(division.divide(128, 3), 42);
		this.assertEquals(division.priorityLeft(3, 5, 5), 4);
		this.assertEquals(division.priorityRight(5, 5, 3), 4);
		try {
			division.divide(42, 0);
			fail();
		}
		catch (Exception e) {
			assertEquals("/ by zero", e.getMessage());
		}
		
	}

}
