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
public class LongestSubstringwithAtMostTwoDistinctCharactersTest {
	LongestSubstringwithAtMostTwoDistinctCharacters solution = new LongestSubstringwithAtMostTwoDistinctCharacters();
	String t1 = "";
	String t2 = "abaac";
	String t3 = "abaa";
	
	/**
	 * Test method for {@link chp1_ArrayAndString.LongestSubstringwithAtMostTwoDistinctCharacters#lengthOfLongestSubstringTwoDistinct(java.lang.String)}.
	 */
	@Test
	public final void testLengthOfLongestSubstringTwoDistinct() {
		Assert.assertEquals(0,solution.lengthOfLongestSubstringTwoDistinct(t1));
		Assert.assertEquals(4,solution.lengthOfLongestSubstringTwoDistinct(t2));
		Assert.assertEquals(4,solution.lengthOfLongestSubstringTwoDistinct(t3));
		
		Assert.assertEquals(4, solution.lengthOfLongestSubstringTwoDistinctSatisfyK(t2));
	}


}
