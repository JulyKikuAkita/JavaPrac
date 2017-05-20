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
public class ReadNCharactersGivenRead4Test {

	/**
	 * Test method for {@link chp1_ArrayAndString.ReadNCharactersGivenRead4#read(char[], int)}.
	 */
	@Test
	public final void testRead() {
		ReadNCharactersGivenRead4 solution = new ReadNCharactersGivenRead4();
		ReadNCharactersGivenRead4Callmultipletimes solution2 = new ReadNCharactersGivenRead4Callmultipletimes();
		char[] buffer = new char[100];
		char[] answer = "file_content".toCharArray() ;
		assertEquals(3, solution.read(buffer, 3));
		assertEquals(8, solution.read(buffer, 8));
		
		assertEquals(3, solution2.read(buffer, 3));
		assertEquals(8, solution2.read(buffer, 8));
		
		//Assert.assertEquals(answer[3], buffer[3]);
		solution.read(buffer, 12);
		for(int i = 0; i < buffer.length;i++){
			//System.out.print( buffer[i]);
			//System.out.println(" :");
			//System.out.print( answer[i]);
		}
		
	}

}
