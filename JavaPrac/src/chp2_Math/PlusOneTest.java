/**
 * 
 */
package chp2_Math;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author iflee
 *
 */
public class PlusOneTest {
	PlusOne solution = new PlusOne();
	Integer[] i1 = new Integer[] {1,2,3,4,5};
	Integer[] i2 = new Integer[] {9, 9, 9};
	Integer[] i3 = new Integer[] {0};
	
	Integer[] ai1 = new Integer[] {1,2,3,4,6};
	Integer[] ai2 = new Integer[] {1, 0, 0, 0};
	Integer[] ai3 = new Integer[] {1};
	
	List<Integer> t1 = new ArrayList<Integer>(Arrays.asList(i1));
	List<Integer> t2 = new ArrayList<Integer>(Arrays.asList(i2));
	List<Integer> t3 = new LinkedList<Integer>(Arrays.asList(i3));
	
	List<Integer> a1 = new ArrayList<Integer>(Arrays.asList(ai1));
	List<Integer> a2 = new ArrayList<Integer>(Arrays.asList(ai2));
	List<Integer> a3 = new LinkedList<Integer>(Arrays.asList(ai3));
	
	
	/**
	 * Test method for {@link chp2_Math.PlusOne#plusOne(java.util.List)}.
	 */
	@Test
	public final void testPlusOne() {
		solution.plusOne(t1);
		solution.plusOne(t2);
		solution.plusOne(t3);
		
		assertEquals(a1, t1);
		assertEquals(a2, t2);
		assertEquals(a3, t3);
	}

}
