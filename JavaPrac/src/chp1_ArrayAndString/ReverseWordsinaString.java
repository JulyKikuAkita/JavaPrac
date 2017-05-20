/**
Question:
Given an input string s, reverse the string word by word.
For example, given s = "the sky is blue", return "blue is sky the".
Example Questions Candidate Might Ask:
Q: What constitutes a word?
A: A sequence of non-space characters constitutes a word.
Q: Does tab or newline character count as space characters?
A: Assume the input does not contain any tabs or newline characters.
Q: Could the input string contain leading or trailing spaces?
A: Yes. However, your reversed string should not contain leading or trailing spaces.
Q: How about multiple spaces between two words?
A: Reduce them to a single space in the reversed string.

Solution:
O(n) runtime, O(n) space:
One simple approach is a two-pass solution: First pass to split the string by spaces into an
array of words, then second pass to extract the words in reversed order.
We can do better in one-pass. While iterating the string in reverse order, we keep track of
a word’s begin and end position. When we are at the beginning of a word, we append it.
 */
package chp1_ArrayAndString;

/**
 * @author iflee
 *
 */
public class ReverseWordsinaString {
	
	public String reverseWords(String s){
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() -1 ; i >=0 ; i--){
			if(s.charAt(i) == ' '){
				j = i;
			}else if( i == 0 || s.charAt( i - 1) == ' '){
				if(reversed.length() != 0 ){
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
		
	}
/*
 * Question:
Similar to Question [6. Reverse Words in a String], but with the following constraints:
“The input string does not contain leading or trailing spaces and the words are always
separated by a single space.”
Could you do it in-place without allocating extra space?	

Solution:
O(n) runtime, O(1) space – In-place reverse: by reversing each individual word first, and then reverse the
entire string.
 */
	public void reverseWords(char[] s){
		reverse(s, 0, s.length);
		for(int i = 0, j =0; j <= s.length ; j++){
			if (j == s.length || s[j] == ' '){
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}
	
	public void reverse(char[] s, int begin, int end){
		for( int i = 0; i < (end - begin) / 2 ; i ++){
			char temp = s[begin + i];
			s[begin + i] = s[end -i -1];
			s[end - i -1] = temp;
		}
	}
/*
Challenge 1:
Implement the two-pass solution without using the library’s split function.

Challenge 2:
Rotate an array to the right by k steps in-place without allocating extra space. For
instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is rotated to [4, 5, 6, 0, 1, 2, 3].	
 */

}
