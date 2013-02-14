package junit;

import pass.Priority;

import junit.framework.TestCase;

public class PriorityTest extends TestCase {
	
	
	private Priority priority;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		priority = new Priority();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testPlus()
	{
		// 3 + 6 / 3 => 5 
		this.assertEquals(priority.priorityDivideRight(6, 3, 3), 7);
	}
}
