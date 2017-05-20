/**
Question:
Given a string S, find the longest palindromic substring in S. You may assume that the
maximum length of S is 1000, and there exists one unique longest palindromic substring.
Hint:
First, make sure you understand what a palindrome means. A palindrome is a string
which reads the same in both directions. For example, â€œabaâ€? is a palindome, â€œabcâ€? is not.

O(n3) runtime, O(1) space â€“ Brute force:
The obvious brute force solution is to pick all possible starting and ending positions for a
substring, and verify if it is a palindrome. There are a total of
such substrings
(excluding the trivial solution where a character itself is a palindrome).
Since verifying each substring takes O(n) time, the run time complexity is O(n3).

 */
package chp1_ArrayAndString;

/**
O(n2) runtime, O(1) space â€“ Simpler solution:
In fact, we could solve it in O(n2) time using only constant space.
We observe that a palindrome mirrors around its center. Therefore, a palindrome can be
expanded from its center, and there are only 2n â€“ 1 such centers.
You might be asking why there are 2n â€“ 1 but not n centers? The reason is the center of a
palindrome can be in between two letters. Such palindromes have even number of letters
(such as â€œabbaâ€?) and its center are between the two â€˜bâ€™s.
Since expanding a palindrome around its center could take O(n) time, the overall
complexity is O(n2).
 */
public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
		int start =0, end =0;
		for(int i =0; i < s.length(); i++){
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if( len > end - start){
				start = i -(len - 1) / 2 ;
				end = i + len /2 ;
			}
			
		}
		return s.substring(start, end+1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right ;
		while( L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
			L--;
			R++;
		}
		return R-L-1;
	}

	
	
	
	
/*
O(n) runtime, O(n) space â€“ Manacherâ€™s algorithm:
There is even an O(n) algorithm called Manacher's algorithm, explained here in detail.
However, it is a non-trivial algorithm, and no one expects you to come up with this
algorithm in a 30 minutes coding session. But, please go ahead and understand it, I
promise it will be a lot of fun.


O(n2) runtime, O(n) space â€“ Dynamic programming:
To improve over the brute force solution from a DP approach, first think how we can
avoid unnecessary re-computation in validating palindromes. Consider the case â€œababaâ€?.
If we already knew that â€œbabâ€? is a palindrome, it is obvious that â€œababaâ€? must be a
palindrome since the two left and right end letters are the same.
Stated more formally below:
Define P[ i, j ] â†? true iff the substring Si â€¦ Sj is a palindrome, otherwise false.
Therefore,
P[ i, j ] â†? ( P[ i+1, j-1 ] and Si = Sj )
The base cases are:
P[ i, i ] â†? true
P[ i, i+1 ] â†? ( Si = Si+1 )
This yields a straight forward DP solution, which we first initialize the one and two
letters palindromes, and work our way up finding all three letters palindromes, and so
onâ€¦
This gives us a runtime complexity of O(n2) and uses O(n2) space to store the table.
 */	

}
