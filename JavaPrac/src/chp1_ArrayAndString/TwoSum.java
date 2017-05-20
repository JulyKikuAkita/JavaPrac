package chp1_ArrayAndString;
/***************************************
 * Chapter 1: Array/String
 * Two Sum
Given an array of integers, find two numbers such that they add up to a specific target
number.
The function twoSum should return indices of the two numbers such that they add up to
the target, where index1 must be less than index2. Please note that your returned answers
(both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.

Naive: O(n2) runtime, O(1) space – Brute force
The brute force approach is simple. Loop through each element x and find if there is
another value that equals to target – x. As finding another value requires looping through
the rest of array, its runtime complexity is O(n2).
***************************************/
import java.util.HashMap;
import java.util.Map;
public class TwoSum {

	
/*O(n) runtime, O(n) space – Hash table
 * We could reduce the runtime complexity of looking up a value to O(1) 
 * using a hash map that maps a value to its index
*/
	public int[] twoSum(int[] numbers, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i =0; i < numbers.length ; i++){
			int x = numbers[i];
			if (map.containsKey(target - x)){
				return new int[]{i+1, map.get(target - x)+ 1};
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum Solution");	
	}

	// O(n log n) runtime, O(1) space – Binary search:
	public int[] twoSumSortedArr(int[] numbers, int target){
		//assume numbers is sorted
		for (int i=0; i<numbers.length; i++){
			int j =bserach(numbers, target - numbers[i], i+1);
			if(j != -1){
				return new int[]{j+1, i+1};
			}
		}throw new IllegalArgumentException("No two sum solution");
		
	}

	private int bserach(int[] A, int key, int start){
		int left = start;
		int right = A.length - 1;
		while (left < right){
			int mid = (left + right) / 2;
			if(A[mid] < key){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		return (left == right && A[left] == key)?left:-1;
		
	}
	
	// O(n) runtime, O(1) space – Two pointers:
	public int[] twoSumTwoPointers(int[] numbers, int target){
		// Assume input is already sorted.
		int i =0, j = numbers.length - 1;
		while (i < j){
			int sum = numbers[i] + numbers[j];
			if (sum < target){
				i++;
			} else if (sum > target){
				j--;
			} else {
				return new int[]{i+1, j+1};
			}
			
		}
		throw new IllegalArgumentException("No two sum solution");	
		
		
	}
		


}
