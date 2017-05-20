/**
Question:
Given a number represented as an array of digits, plus one to the number.
ex: integer 99 saved in array  arr[0] = 9 and arr[1] = 9, add 1 to the number

Example Questions Candidate Might Ask:
Q: Could the number be negative?
A: No. Assume it is a non-negative number.
Q: How are the digits ordered in the list? For example, is the number 12 represented by [1,2] or
[2,1]?
A: The digits are stored such that the most significant digit is at the head of the list.
Q: Could the number contain leading zeros, such as [0,0,1]?
A: No.
 */
package chp2_Math;

import java.util.List;

/**
Solution:
Iterate from the least significant digit, and simulate by adding one to it. Adding one to a
digit less than nine is straightforward – Add one to it and we are done.
On the other hand, adding one to a digit of 9 brings it to 10, so we set the digit to 0 and
continues with a carry digit of one to its left digit. Notice this recursive behavior? Yes,
we are adding one again to its left digit and this behavior continues until the most
significant digit.
Finally, be sure that you handle the edge case where each digit of the number is 9.
 */
public class PlusOne {
	public void plusOne(List<Integer> digits) {
		for(int i = digits.size() - 1 ; i >= 0 ; i--){
			int digit = digits.get(i);
			if(digit < 9){
				digits.set(i, digit+1) ;
				return;
			}else{
				digits.set(i , 0);
			}	
		}
		/*
		 * When all digits are 9, we did something slightly strange (See line 11). We append the
digit 0 and modify the most significant digit to 1. Some of you might ask why not insert 1
to the front of list? Assume that the list is implemented as an ArrayList, appending an
element is far more efficient than inserting to the front, because all elements have to be
shifted one place to the right otherwise.
		 */
		digits.add(0);
		digits.set(0, 1);
	}
	
	

}
