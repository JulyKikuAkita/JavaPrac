/**
Question:
Determine whether an integer is a palindrome. Do this without extra space.
-> cannot convert int to string as it requires additional space

Example Questions Candidate Might Ask:
Q: Does negative integer such as –1 qualify as a palindrome?
A: For the purpose of discussion here, we define negative integers as non-palindrome
 */
package chp2_Math;

/**
The most intuitive approach is to first represent the integer as a string, since it is more
convenient to manipulate. Although this certainly does work, it violates the restriction of
not using extra space. (ie, you have to allocate n characters to store the reversed integer as
string, where n is the maximum number of digits). I know, this sound like an
unreasonable requirement (since it uses so little space), but don’t most interview
problems have such requirements?

Another approach (as reversed() ) is to first reverse the number. If the number is the same as its reversed,
then it must be a palindrome. You could reverse a number by doing the following:

This seemed to work too, but did you consider the possibility that the reversed number
might overflow? If it overflows, the behavior is language specific (For Java the number
wraps around on overflow, but in C/C++ its behavior is undefined). Yuck.
Of course, we could avoid overflow by storing and returning a type that has larger size
than int (ie, long long). However, do note that this is language specific, and the larger
type might not always be available on all languages.

We could construct a better and more generic solution. One pointer is that, we must start
comparing the digits somewhere. And you know there could only be two ways, either
expand from the middle or compare from the two ends.

 */
public class PalindromeNumber {
	
	// flaw: the reversed number might overflow
	public int reverse(int num) {
		assert num >= 0; //for non-negative integers only
		int reversed = 0;
		while(num > 0){
			reversed = reversed * 10 + (num % 10);
			num /= 10;
		}
		return reversed;
	}
	
/*
* It turns out that comparing from the two ends is easier. First, compare the first and last
digit. If they are not the same, it must not be a palindrome. If they are the same, chop off
one digit from both ends and continue until you have no digits left, which you conclude
that it must be a palindrome.
*/
	// Time: O(n) : total iterate though n digits in num
	// Space: O(1)
	public boolean isPalindromeRecursion(int num){
		while( num >= 0){
			int div = 1;
			while( num / div >= 10){ div *= 10; }
			//loop to the 2nd tier if last and first digit matches
			if( (int)(num / div) == (num %10)){
				num = (num % div) / 10 ;
				if( num == 0 ){ return true;}  // ex: 101 -> 0
				else{isPalindromeRecursion(num);}			
			}else{
				return false;
			}
		}
		return false;
	}
	
	
	public boolean isPalindrome(int num){
		if( num < 0){ return false;}
		int div = 1;
		while( num / div >= 10){ div *= 10;}
		
		while(num != 0){
			int l = num / div;
			int r = num % 10;
			if( l != r) return false;
			
			num = (num % div) / 10;
			div /= 100;
		}
		return true;
	}

}
