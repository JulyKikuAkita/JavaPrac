package chp1_ArrayAndString;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TwoSumTest {

	@Test
	public void testTwoSum() {
		TwoSum solution = new TwoSum();
		TwoSumDataStructureDesign solution2 = new TwoSumDataStructureDesign();
		int[] arr = {1,2,3,4,5};
		int[] test = {1,2,3,4};
		
		int[] ans1 = solution.twoSum(arr, 5);
		int[] ans2 = solution.twoSumSortedArr(arr, 3);
		int[] ans3 = solution.twoSumTwoPointers(arr, 4);
		
		solution2.add(arr);
		solution2.add(5);
		boolean ans4 = solution2.find(4);
		boolean ans5 = solution2.find(1);
				
		assertArrayEquals(new int[]{3,2}, ans1);  //{2,3} fail
		assertArrayEquals(new int[]{2,1}, ans2);  //{1,2} fail
		assertArrayEquals(new int[]{1,3}, ans3);  //{3,1} fail
		Assert.assertTrue(ans4);
		Assert.assertFalse(ans5);
		
	}
	
	
}
