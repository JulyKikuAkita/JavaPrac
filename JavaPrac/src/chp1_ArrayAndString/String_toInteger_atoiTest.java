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
public class String_toInteger_atoiTest {

	/**
	 * Test method for {@link chp1_ArrayAndString.String_toInteger_atoi#atoi(java.lang.String)}.
	 */
	@Test
	public final void testAtoi() {
		String_toInteger_atoi solution = new String_toInteger_atoi();
		String test1 = "-12345";
		String test2 = "000123";
		String test3 = "-0";
		int edgeValue = 214748364 * 10;
		
		System.out.println(Integer.toString(Integer.MAX_VALUE, 2));
		System.out.println(Integer.toString(Integer.MIN_VALUE, 2));
		System.out.println(Integer.toString(edgeValue, 2));
		System.out.println(Integer.toString(edgeValue + 7, 2));
		System.out.println(Integer.toString(edgeValue + 8, 2));
		System.out.println(Integer.toString(Integer.MAX_VALUE + 9, 2));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.parseInt("1100110011001100110011010011", 2));
		System.out.println(Integer.parseInt("-10000000000000000000000000000000", 2));
		System.out.println(Integer.parseInt("-1111111111111111111111111111000", 2));
		
		Assert.assertEquals(-12345, solution.atoi(test1));
		Assert.assertEquals(123, solution.atoi(test2));
		Assert.assertEquals(0, solution.atoi(test3));
	}

}
