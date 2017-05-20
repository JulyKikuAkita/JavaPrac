/**
Question:
You are given two linked lists representing two non-negative numbers. The digits are
stored in reverse order and each of their nodes contains a single digit. Add the two
numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
package chp3_LinkedList;


public class AddTwoNumbers {

/**
Solution:
Keep track of the carry using a variable and simulate digits-by-digits sum from the head
of list, which contains the least-significant digit.
Take extra caution of the following cases:
- When one list is longer than the other.
- The sum could have an extra carry of one at the end, which is easy to forget. (e.g.,
(9 -> 9) + (1) = (0 -> 0 -> 1))
 * 
 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyhead = new ListNode(0);
		ListNode ptr = dummyhead;
		int carry = 0;

		while(l1 != null || l2 != null){
			int v1 = (l1 == null)? 0 : l1.val; 
			int v2 = (l2 == null)? 0 : l2.val;
			int sum = v1 + v2 + carry;
			
			if(sum >= 10){
				carry = sum / 10;
				sum = sum % 10;
			}
			ptr.next = new ListNode(sum);
			l1 = (l1 == null) ? null : l1.next;
			l2 = (l2 == null) ? null : l2.next;
			ptr = ptr.next;
		}
		
		if(carry > 0){
			ptr.next = new ListNode(carry);
		}
		
		return dummyhead.next;
	}
}
