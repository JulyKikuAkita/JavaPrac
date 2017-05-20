package chp3_LinkedList;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class MergeTwoSortedListsTest {
	MergeTwoSortedLists solution = new MergeTwoSortedLists();
	ListNode l1 = ListNode.createListNodefromArr(new int[]{1,2,8});
	ListNode l2 = ListNode.createListNodefromArr(new int[]{4,5,6,9});
	List<Integer> a1 = Arrays.asList(new Integer[]{1,2,4,5,6,8,9});
	
	ListNode l3 = ListNode.createListNodefromArr(new int[]{-19,-9,9,9,9,19});
	ListNode l4 = ListNode.createListNodefromArr(new int[]{1,1,1});
	List<Integer> a2 = Arrays.asList(new Integer[]{-19, -9, 1,1,1,9, 9, 9, 19});

	@Test
	public final void testMergeTwoLists() {
		Assert.assertEquals(a1, ListNode.printListNodeValue(solution.mergeTwoLists(l1, l2)));		
		Assert.assertEquals(a2, ListNode.printListNodeValue(solution.mergeTwoLists(l3, l4)));	
	}

}
