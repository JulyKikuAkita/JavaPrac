/**
Question:
Merge two sorted linked lists and return it as a new list. The new list should be made by
splicing together the nodes of the first two lists.
 */
package chp3_LinkedList;

/**
Solution:
We insert a dummy head before the new list so we don’t have to deal with special cases
such as initializing the new list’s head. Then the new list’s head could just easily be
returned as dummy head’s next node.
Using dummy head allows you to write simpler code and adds as a powerful tool to your
interview arsenal. To see more examples of dummy head usage, please see these
questions: [21. Add Two Numbers], [22. Swap Nodes in Pairs], and [23. Merge K Sorted
Linked Lists].
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dummyhead = new ListNode(0);
		ListNode ptr = dummyhead;
		// loop though l1 & l2
		while(l1 != null && l2 != null ){
			if(l1.val <= l2.val ){
				ptr.next = l1;
				ptr = l1;
				l1 = l1.next;
			}else{
				ptr.next = l2;
				ptr = l2;
				l2 = l2.next;
			}
	
		}
		if(l1 == null) ptr.next = l2;
		if(l2 == null) ptr.next = l1;
		return dummyhead.next;
		
		
	}

}
