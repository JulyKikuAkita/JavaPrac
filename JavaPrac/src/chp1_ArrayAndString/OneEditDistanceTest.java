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
public class OneEditDistanceTest {
	OneEditDistance solution = new OneEditDistance();
	String s1 = "abcde";
	String s2 = "dd";
	String s3 = "xx";
	String t1 = "abXde";
	String t2 = "abcXde";
	String t3 = "abcdeX";

	/**
	 * Test method for {@link chp1_ArrayAndString.OneEditDistance#isOneEditDistance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsOneEditDistance() {
		Assert.assertEquals(true, solution.isOneEditDistance(s1, t1));
		Assert.assertEquals(true, solution.isOneEditDistance(s1, t2));
		Assert.assertEquals(true, solution.isOneEditDistance(s1, t3));
		
		Assert.assertEquals(false, solution.isOneEditDistance(s2, t2));
		Assert.assertEquals(false, solution.isOneEditDistance(s2, s3));
	}

}
