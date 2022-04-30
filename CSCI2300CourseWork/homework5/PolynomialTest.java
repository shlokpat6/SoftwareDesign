import org.junit.*;
import static org.junit.Assert.*;
public class PolynomialTest
{
	//Declare all polynomial objects
	Polynomial polynomial1;
	Polynomial polynomial2;
	Polynomial polynomial3;
	Polynomial polynomial4;
	Polynomial polynomial5;
	Polynomial polynomial6;
	private double val;

	@Before
	public void setUp()
	{
		double[] arrayPositiveCoefficients = {3,2,9,0};
		double[] arrayNegativeCoefficients = {-3,-2,9,0};
		double[] arrayPositiveDecimalCoefficients = {3.7,2.2,9.6,2.7};
		double[] array4 = {3.7,0,9.6,2.7};
		
		int[] arrayPositiveExponents = {2,7,3,1};
		int[] arrayPositiveExponentsWithZero = {2,7,3,0};
		
		//Instantiate all the different polynomial objects used for the tests
		polynomial1 = new Polynomial(arrayPositiveCoefficients,arrayPositiveExponents);
		polynomial2 = new Polynomial(arrayNegativeCoefficients,arrayPositiveExponents);
		polynomial3 = new Polynomial(arrayPositiveDecimalCoefficients,arrayPositiveExponents);
		polynomial4 = new Polynomial(arrayPositiveDecimalCoefficients, arrayPositiveExponentsWithZero);
		polynomial5 = new Polynomial(array4,arrayPositiveExponents);
		polynomial6 = new Polynomial(arrayPositiveCoefficients,arrayPositiveExponents);
	}
	
	/* Checks to see if the polynomial is evaluted correctly when 
	 * there are positive coefficients
	 *
	*/
	@Test
	public void evalTest1()
	{
		val = 340;
		assertEquals("Evaluated incorrectly.", val, polynomial1.eval(2), .00000001);
	}
	
	/* Checks to see if the polynomial is evaluated correctly 
	 * when there are negative coeffiecients
	*/ 
	@Test
	public void evalTest2()
	{
	    val = -196;
		assertEquals("Evaluated incorrectly.", val, polynomial2.eval(2), .00000001);
	}
	
	/* Checks to see if polynomial is evaluated to zero when the x value
	 * is zero
	*/
	@Test
	public void evalTest3()
	{
		val = 0;
		assertEquals("Evaluated incorrectly.", val, polynomial1.eval(0), .00000001);
	}
	
	/* Checks to see if polynomial is evaluated correctly when the x 
	 * value is negative
	 */
	@Test
	public void evalTest4()
	{
		val = -316;
		assertEquals("Evaluated incorrectly.", val, polynomial1.eval(-2), .00000001);
	}
	
	/* Checks to see if polynomial is evaluated correctly when decimal 
	 * coefficients are used
	 */
	@Test
	public void evalTest5()
	{
		val = 378.6;
		assertEquals("Evaluated incorrectly.", val, polynomial3.eval(2), .00000001);
	}
	 
	/* Checks to see if the coefficient of the highest degree can be
	 * found 
	 */
	@Test
	public void getCoefficientTest1()
	{
        val = 2.2;
		assertEquals("Wrong Coefficient.", val, polynomial4.getCoefficient(7), .00000001);
	}
	
	/* Checks to see if the Coefficient of the lowest degree can be 
	 * found
	 */
	@Test
	public void getCoefficientTest2()
	{
		val = 2.7;
		assertEquals("Wrong Coefficient.", val, polynomial4.getCoefficient(0), .00000001);
	}
	
	/* Checks to see if the correct coefficient can be found when the largest
	 * exponent is paired with a coefficient of zero
	 */ 
	@Test
	public void getMaxDegreeTest1()
	{
		int val = 3;
		assertEquals("Not the largest exponent with a nonzero coeffiecient.", val, polynomial5.getMaxDegree(), .00000001);
	}
	
	/* Checks to see if the correct coefficient can be found when the largest
	 * exponent is not paried with a coefficient of zero
	 */
	@Test
	public void getMaxDegreeTest2()
	{
		int val = 7;
		assertEquals("Not the largest exponent with a nonzero coeffiecient.", val, polynomial6.getMaxDegree(), .00000001);
	}
	
	
	
	
	
}
