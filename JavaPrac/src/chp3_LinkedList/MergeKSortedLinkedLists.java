package chp3_LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Question:
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
complexity.

O(nk2) runtime, O(1) space – Brute force:
The brute force approach is to merge a list one by one. For example, if the lists = [l1, l2,
l3, l4], we first merge l1 and l2, then merge the result with l3, and finally l4.
To analyze its time complexity, we are going to assume there are a total of k lists, and
each list is of size n. There will be a total of k – 1 merge operations. The first merge
operation will be two lists of size n, therefore in the worst case there could be n + n
comparisons. The second merge operation will be two lists of size 2n and n. Notice that
each merge increase the size of the merged lists by n. Therefore, the total number of
comparisons required is 2n + 3n + 4n + … + kn = n(k(k+1)/2 -1) = O(nk2).

O(nk log k) runtime, O(k) space – Heap(Priority Queue):
We could use a min heap of size k. The heap is first initialized with the smallest element
from each list. Then as we extract the nodes out from the heap, we must remember to
insert its next node into the heap. As each insert operation into the heap costs log(k) and
there are a total of nk elements, the total runtime complexity is O(nk log k).  
Binary heap: http://en.wikipedia.org/wiki/Binary_heap
-> Please see priority queue practice if not familiar with it
http://www.programcreek.com/2009/02/using-the-priorityqueue-class-example/
Priority queue doc: http://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html

Ignoring the extra space that is used to store the output list, we only use extra space of
O(k) due to the heap.

O(nk log k) runtime, O(1) space – Divide and conquer using two way merge:
If you still remember how merge sort works, we can use a divide and conquer mechanism
to solve this problem. Here, we apply the merge two lists algorithm from Question [20.
Merge Two Sorted Lists].
Basically, the algorithm merges two lists at a time, so the number of lists reduces from:
k -> k/2 -> k/4 -> ... -> 2 -> 1
Similarly, the size of the lists increases from (Note that the lists could subdivide itself at
most log(k) times):
n -> 2n -> 4n -> ... 2^(logk)n
Therefore, the runtime complexity is:
k*n + k/2 * 2n + k/4 * 4n + ... + 2^(logk)n * 1
= nk + nk + ... + nk
= nklogk
Since we are implementing this divide and conquer algorithm iteratively, the space
complexity is constant at O(1), yay!

 */

/***
 * 
 */
public class MergeKSortedLinkedLists {

	// O(nk log k) runtime, O(k) space – Heap:
	public ListNode mergeKListsMinHeap(List<ListNode> lists){
		if(lists.isEmpty()){ return null;}
		ListNode dummyhead = new ListNode(0);
		ListNode ptr = dummyhead;
		
		// initiate priority queue
		Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), listComparator );
		for(ListNode node : lists){
			// Add head of each list to priority queue
			if(node != null) pq.offer(node);
		}
		
		// merge list from priority queue
		while( !pq.isEmpty()){
			//System.out.println("peek into pq " + pq.peek().val);
			ListNode node = pq.poll();
			if(node.next != null) pq.offer(node.next); // without this, only head of each list was added in pq
			ptr.next = node;
			ptr = ptr.next;
		}
		
		
		return dummyhead.next;
	}
	
	
	private static final Comparator<ListNode> listComparator = new Comparator<ListNode>(){
		  ///*
		public int compare(ListNode a, ListNode b) {
			return a.val - b.val;
		}
		  //*/
		
		   /*
		public int compare(ListNode x, ListNode y){
			if(x.val < y.val) 
				return -1;
			else if(x.val > y.val) 
				return 1;
			else 
				return 0;
		}
		  */
	};
	
	
	//O(nk log k) runtime, O(1) space – Divide and conquer using two way merge
	public ListNode mergeKListsMergeSort(List<ListNode> lists){
		if(lists.isEmpty()) return null;
		
		int end = lists.size() -1;
		while(end > 0){
			int begin = 0;
			while(begin < end ){
				lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
				begin ++;
				end --;
			}
		}
		return lists.get(0);
			
		
	}
	
	// should declare as private, use public in order for junit to run
	public ListNode merge2Lists(ListNode l1, ListNode l2) {
		ListNode dummyhead= new ListNode(0);
		ListNode ptr = dummyhead;
		
		while( l1 != null && l2 != null){
			if(l1.val <= l2.val){ // fails if l1 or l2 == null (null pointer exception)
				ptr.next = l1;
				l1 = l1.next;
			}else{
				ptr.next = l2;
				l2 = l2.next;
			}
			ptr = ptr.next;
		}
		ptr.next = (l1 != null)? l1: l2 ;

		return dummyhead.next;
	}
	
}
