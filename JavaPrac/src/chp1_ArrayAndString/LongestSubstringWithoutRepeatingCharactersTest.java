package chp1_ArrayAndString;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
	LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
	String test1 = "abcabcbb";
	String test2 = "bbbbb";
	@Test
	public final void testLengthOfLongestSubstring() {
		System.out.println(test2.charAt(0));
		assertEquals(3, solution.lengthOfLongestSubstring(test1));
		Assert.assertEquals(1, solution.lengthOfLongestSubstring(test2));
		
		Assert.assertEquals(3, solution.lengthOfLongestSubstringUsingSet(test1));
		Assert.assertEquals(1, solution.lengthOfLongestSubstringUsingSet(test2));
	}

}
