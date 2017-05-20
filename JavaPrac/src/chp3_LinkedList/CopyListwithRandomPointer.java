/**
Question:
A linked list is given such that each node contains an additional random pointer that
could point to any node in the list or null.
Return a deep copy of the list.

Solution:
Cloning a linked list without an additional random pointer is easy to solve. The trickier
part however, is to clone the random list node structure.

O(n2) runtime, O(n) space – Brute force:
To get started, it is helpful to label each individual node with an index. According to the
above list, node 0’s random points to node 1, node 1’s random point to node 0, and node
2’s random points to itself, node 2.
We could rebuild the structure assume we have the above connections. As we know that
node 0 random points to node 1, we need to connect the cloned version from node 0' to
node 1'. We would have to iterate over the list each time to link the nodes and it takes
O(n), making the overall time complexity O(n2).
How do we represent the connection? We can build a map that maps the original node to
its indices. Having this map will allow us to clone the structure. If we know that node 0’s
random points to node 1, we just have to connect them, right? The only issue is
connecting them takes O(n) complexity, because we have to traverse the cloned list to
find the node to connect.

O(n) runtime, O(n) space – Hash table:
It is now natural to lead to a mapping so we can quickly lookup the node to connect. We
can easily build the map of indices to cloned nodes. Therefore, we have reduced the
complexity to O(1) when connecting the random nodes.
This had got us started, although it requires two maps. On closer inspection, it turns out
that the two maps could be shortened into one single map. We just need to map the
original node to its random node directly.

O(n) runtime, O(1) space – Modify original structure:
The above algorithm uses extra space O(n), can we not use extra space? What if we
eliminate the map? The only way is to modify the original structure. Imagine if we
modify the next node of the original node to point to its own copy.

Now, assume we have the above configuration we could assign the random node pointers
of each copy easily with the following code:

node.next.random = node.random.next;

To summarize, we need three iterations over the list:
i. Create a copy of each of the original node and insert them in between two
original nodes in an alternate fashion.
ii. Assign random pointer of each node copy.
iii. Restore the input to its original configuration.
We have achieved O(n) runtime complexity with using only constant extra space.

 */
package chp3_LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
	
	// O(n) runtime, O(n) space – Hash table:
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode cur = head;
		RandomListNode dummyhead = new RandomListNode(0);
		RandomListNode ptr = dummyhead;
		
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		
		while(cur != null){
			ptr.next = new RandomListNode(cur.label);
			map.put(cur, ptr.next);  //if put(cur, ptr), head val = dummyhead.val
			ptr= ptr.next;
			cur = cur.next;
		}
		
		ptr = dummyhead;
		cur = head;
		
		while(cur != null){
			ptr.next.random = map.get(cur.random);
			ptr = ptr.next;
			cur = cur.next;
		}
		return dummyhead.next;
	}
	
	//O(n) runtime, O(1) space – Modify original structure:
	public RandomListNode copyRandomListClonedNodes(RandomListNode head) {
		RandomListNode ptr = head;
		
		// create a list of array of copied nodes
		while(ptr != null){
			RandomListNode clone = new RandomListNode(ptr.label);
			clone.next = ptr.next;
			ptr.next = clone;
			ptr = ptr.next.next;
					
		}
		
		//assign random node that node.next.random = node.random.next
		ptr = head;
		while(ptr != null){
			ptr.next.random = (ptr.random != null ) ? ptr.random.next : null;
			ptr = ptr.next.next;
		}
		
		
		//Generate the cloned list
		ptr = head;
		RandomListNode headCopy = (ptr != null) ? ptr.next : null ;
		while(ptr != null){
			RandomListNode cur = ptr.next;
			ptr.next = cur.next;
			ptr = ptr.next;
			cur.next = (ptr != null) ? ptr.next :null;
		}
		
		return headCopy;
		
	}
	

}
