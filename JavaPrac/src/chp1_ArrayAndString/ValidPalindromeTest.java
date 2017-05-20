/**
 * 
 */
package chp1_ArrayAndString;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * @author iflee
 *
 */
public class ValidPalindromeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link chp1_ArrayAndString.ValidPalindrome#isPalindrome(java.lang.String)}.
	 */
	@Test
	public final void testIsPalindrome() {
		String str1 = "";
		String str2 = "race a car";
		String str3 = "A man, a plan, a canal: Panama";
		
		ValidPalindrome test1 = new ValidPalindrome();
		
		Assert.assertTrue(test1.isPalindrome(str1));
		Assert.assertFalse(test1.isPalindrome(str2));
		Assert.assertTrue(test1.isPalindrome(str3));
		
	}

}
