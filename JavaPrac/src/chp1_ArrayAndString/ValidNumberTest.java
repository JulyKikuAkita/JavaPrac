/**
 * 
 */
package chp1_ArrayAndString;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

/**
 * @author iflee
 *
 */
public class ValidNumberTest {
	ValidNumber solution = new ValidNumber();
	String test1 = " -0.1 ";
	String test2 = "0000e1";
	String test3 = "";
	String test4 = "0.12$%^123";
	
	/**
	 * Test method for {@link chp1_ArrayAndString.ValidNumber#isNumber(java.lang.String)}.
	 */
	@Test
	public final void testIsNumber() {
		Assert.assertEquals(true, solution.isNumber(test1));
		Assert.assertEquals(true, solution.isNumberExponent(test2));
		Assert.assertEquals(false, solution.isNumber(test3));
		Assert.assertEquals(false, solution.isNumber(test4));
	}

	

}
