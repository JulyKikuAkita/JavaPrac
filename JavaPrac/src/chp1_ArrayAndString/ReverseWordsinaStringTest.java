/**
 * 
 */
package chp1_ArrayAndString;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author iflee
 *
 */
public class ReverseWordsinaStringTest {

	@Test
	public final void test() {
		ReverseWordsinaString solution = new ReverseWordsinaString();
		String test1 = " the   sky is   blue ";
		String test2 = "Reverse Words in a String II";
		String test3 = "Hi there";
		char[] test4 = test3.toCharArray();
		char[] ans4 = new String("there Hi").toCharArray(); 
		solution.reverseWords(test4);		
	//	System.out.println(solution.reverseWords(test1) ); 
	//	System.out.println(solution.reverseWords(test2) );
		System.out.println(test4 );
		
		Assert.assertEquals(new String("blue is sky the"), solution.reverseWords(test1) );
		Assert.assertEquals(new String("II String a in Words Reverse"), solution.reverseWords(test2) );
		Assert.assertArrayEquals(ans4, test4);
		
	}

}
