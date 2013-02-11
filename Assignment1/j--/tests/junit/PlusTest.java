package junit;

import pass.Plus;
import junit.framework.TestCase;

public class PlusTest extends TestCase
{
	private Plus plus;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		plus = new Plus();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testPlus()
	{
		this.assertEquals(plus.plus(0), 0);
		this.assertEquals(plus.plus(42), 42);
		this.assertEquals(plus.plus(-42), -42);
	}
}
