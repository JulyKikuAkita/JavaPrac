package chp3_LinkedList;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class MergeKSortedLinkedListsTest {
	MergeKSortedLinkedLists solution = new MergeKSortedLinkedLists();
	
	ListNode l1 = ListNode.createListNodefromArr(new int[]{1,2,8});
	ListNode l2 = ListNode.createListNodefromArr(new int[]{4,5});
	ListNode l22 = ListNode.createListNodefromArr(new int[]{6,9});
	
	ListNode l3 = ListNode.createListNodefromArr(new int[]{-19,-9});
	ListNode l31 = ListNode.createListNodefromArr(new int[]{9,9,9});
	ListNode l32 = ListNode.createListNodefromArr(new int[]{19});
	ListNode l4 = ListNode.createListNodefromArr(new int[]{1,1,1});
	ListNode l5 = ListNode.createListNodefromArr(new int[]{});
	
	List<Integer> a1 = Arrays.asList(new Integer[]{1,2,4,5,6,8,9});
	List<Integer> a2 = Arrays.asList(new Integer[]{-19, -9, 1,1,1,9, 9, 9, 19});
	
	
	@Test
	public final void testMergeKListsMinHeap_a1() {
		List<ListNode> klists = new LinkedList<ListNode>();
		klists.add(l1);
		klists.add(l2);
		klists.add(l22);
		//System.out.println(klists.size());
		
		Assert.assertEquals(a1, ListNode.printListNodeValue(solution.mergeKListsMinHeap(klists)));
		
	}
	
	@Test
	public final void testMergeKListsMinHeap_a2() {
		List<ListNode> k1 = new LinkedList<ListNode>();
		k1.add(l3); k1.add(l31);  k1.add(l32); k1.add(l4); k1.add(l5);
		//System.out.println(klists.size());
		Assert.assertEquals(a2, ListNode.printListNodeValue(solution.mergeKListsMinHeap(k1)));
		
	}
	
	@Test
	public final void testMerge2Lists() {
		Assert.assertEquals(Arrays.asList(new Integer[]{1,2,4,5,8}), ListNode.printListNodeValue(solution.merge2Lists(l1, l2)));
		Assert.assertEquals(Arrays.asList(new Integer[]{-19, -9}), ListNode.printListNodeValue(solution.merge2Lists(l3, l5)));
	}
	
	 // /*
	@Test
	public final void testmergeKListsMergeSort_a1() {
		List<ListNode> klists = new LinkedList<ListNode>();
		klists.add(l1);
		klists.add(l2);
		klists.add(l22);
		//System.out.println(klists.size());
		Assert.assertEquals(a1, ListNode.printListNodeValue(solution.mergeKListsMergeSort(klists)));
		
	}
	// */
	
	@Test
	public final void testmergeKListsMergeSort_a2() {
		List<ListNode> k1 = new LinkedList<ListNode>();
		k1.add(l3); k1.add(l31);  k1.add(l32); k1.add(l4); k1.add(l5);
		//System.out.println(klists.size());
		Assert.assertEquals(a2, ListNode.printListNodeValue(solution.mergeKListsMergeSort(k1)));
		
	}

}
