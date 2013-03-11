package junit;


import junit.framework.TestCase;
import pass.Primes;
import java.util.Arrays;

public class PrimesTest extends TestCase
{
	private Primes primes;
	
	public void setUp() throws Exception
	{
		super.setUp();
		primes = new Primes();
	}
	
	public void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testPrimes()
	{
		this.assertTrue(Arrays.equals(primes.primes(2), new int[]{2}));
		this.assertTrue(Arrays.equals(primes.primes(0), new int[]{}));
		this.assertTrue(Arrays.equals(primes.primes(-42), new int[]{}));
		this.assertTrue(Arrays.equals(primes.primes(10), new int[]{2, 3, 5, 7}));
	}
	
}
