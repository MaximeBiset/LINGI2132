package junit;

import junit.framework.TestCase;
import pass.Modulo;

public class ModuloTest extends TestCase
{
	private Modulo modulo;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		modulo = new Modulo();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testModulo()
	{
		this.assertEquals(modulo.modulo(128, 43), 42);
		this.assertEquals(modulo.modulo(6, 2), 0);
		this.assertEquals(modulo.modulo(1, 42), 1);
		this.assertEquals(modulo.priorityLeft(1, 1, 42), 2);
		this.assertEquals(modulo.priorityRight(1, 42, 1), 2);
	}
}
