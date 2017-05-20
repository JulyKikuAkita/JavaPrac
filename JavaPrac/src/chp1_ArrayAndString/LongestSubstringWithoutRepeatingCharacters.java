/**
 Question:
Given a string, find the length of the longest substring without repeating characters. For
example, the longest substring without repeating letters for “abcabcbb” is “abc”, which
the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1. 

Solution:
O(n) runtime, O(1) space – Two iterations:
How can we look up if a character exists in a substring instantaneously? The answer is to
use a simple table to store the characters that have appeared. Make sure you communicate
with your interviewer if the string can have characters other than ‘a’–‘z’. (ie, Digits?
Upper case letter? Does it contain ASCII characters only? Or even unicode character
sets?)
The next question is to ask yourself what happens when you found a repeated character?
For example, if the string is “abcdcedf”, what happens when you reach the second
appearance of ‘c’?
When you have found a repeated character (let’s say at index j), it means that the current
substring (excluding the repeated character of course) is a potential maximum, so update
the maximum if necessary. It also means that the repeated character must have appeared
before at an index i, where i is less than j.
Since you know that all substrings that start before or at index i would be less than your
current maximum, you can safely start to look for the next substring with head which
starts exactly at index i + 1.
Therefore, you would need two indices to record the head and the tail of the current
substring. Since i and j both traverse at most n steps, the worst case would be 2n steps,
which the runtime complexity must be O(n).
Note that the space complexity is constant O(1), even though we are allocating an array.
This is because no matter how long the string is, the size of the array stays the same at
256
 */
package chp1_ArrayAndString;

import java.util.Arrays;

/**
 * @author iflee
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s){
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for(int j =0; j < s.length(); j++){
			while(exist[s.charAt(j)]){
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - i +1, maxLen);
		}
		return maxLen;
	}
	
	
/*
 * What if the character set could contain unicode characters that is out of ascii’s range? We
could modify the above solution to use a Set instead of a simple boolean array of size 256.

Solution:
O(n) runtime, O(1) space – Single iteration:
The above solution requires at most 2n steps. In fact, it could be optimized to require only
n steps. Instead of using a table to tell if a character exists or not, we could define a
mapping of the characters to its index. Then we can skip the characters immediately
when we found a repeated character.  	
 */
	
	public int lengthOfLongestSubstringUsingSet(String s) {
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		
		int index = 0, maxLen = 0;
		
		for(int i =0; i < s.length(); i++){
			//skip repeated char b.c. the repeated character must have appeared before at an index, where is less than current index i.
			if(charMap[s.charAt(i)] >= index){
				index = charMap[s.charAt(i)] + 1;  
												   
			}
			
			//initiate charMap with index
			charMap[s.charAt(i)] = i;
			maxLen = Math.max(i - index +1, maxLen);
		}
		return maxLen;
	}
	

}
