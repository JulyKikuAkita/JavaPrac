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
public class LongestPalindromicSubstringTest {

	/**
	 * Test method for {@link chp1_ArrayAndString.LongestPalindromicSubstring#longestPalindrome(java.lang.String)}.
	 */
	@Test
	public final void testLongestPalindrome() {
		LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
		String t1 = "abacdgfdcaba";
		String t2 = "abac";
		
		Assert.assertEquals("aba", solution.longestPalindrome(t1));
		Assert.assertEquals("aba", solution.longestPalindrome(t2));
		
	}

}
