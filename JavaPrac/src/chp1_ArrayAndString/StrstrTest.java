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
public class StrstrTest {

	/**
	 * Test method for {@link chp1_ArrayAndString.Strstr#strStr(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testStrStr() {
		Strstr solution = new Strstr();
		String none = "";
		String str1 = "aaaba";
		String str2 = "ba";
		
		String str3 = "mississippi";
		String str4 = "issi";
		
		Assert.assertEquals(1, solution.strStr(str3, str4));
		Assert.assertEquals(-1, solution.strStr(str1, none));
		Assert.assertEquals(3, solution.strStr(str1, str2));
	}

}
