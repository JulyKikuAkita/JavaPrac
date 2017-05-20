/**
 * 
 */
package chp2_Math;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author iflee
 *
 */
public class PalindromeNumberTest {
	PalindromeNumber solution = new PalindromeNumber();
	int r1 = 123;
	int r2 = 0;
	int r3 = 1;
	int max = Integer.MAX_VALUE;
	int min = Integer.MIN_VALUE;
	
	/**
	 * Test method for {@link chp2_Math.PalindromeNumber#reverse(int)}.
	 * only reverse positive integers
	 */
	@Test
	public final void testReverse() {
	//	System.out.println( max + " " +  min);
		Assert.assertEquals(r1, solution.reverse(321));
		Assert.assertEquals(r2, solution.reverse(0));
		Assert.assertEquals(r3, solution.reverse(1));
		Assert.assertEquals(-1126087180, solution.reverse(max));
	//	Assert.assertEquals(0, solution.reverse(min));
		
	}
	
	@Test
	public final void testIsPalindromeRecursion(){
		Assert.assertTrue(solution.isPalindromeRecursion(0));
		Assert.assertTrue(solution.isPalindromeRecursion(101));
		Assert.assertTrue(solution.isPalindromeRecursion(1221));
		Assert.assertFalse(solution.isPalindromeRecursion(r1));
		Assert.assertFalse(solution.isPalindromeRecursion(-2));
	}
	
	@Test
	public final void testIsPalindrome(){
		Assert.assertTrue(solution.isPalindrome(0));
		Assert.assertTrue(solution.isPalindrome(101));
		Assert.assertTrue(solution.isPalindrome(1221));
		Assert.assertFalse(solution.isPalindrome(r1));
		Assert.assertFalse(solution.isPalindrome(-2));
	}

}
