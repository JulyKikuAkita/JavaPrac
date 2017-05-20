package chp3_LinkedList;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class SwapNodesinPairsTest {
	SwapNodesinPairs solution = new SwapNodesinPairs();
	
	ListNode l1 = ListNode.createListNodefromArr(new int[]{1,2,8});
	ListNode l2 = ListNode.createListNodefromArr(new int[]{4,5,6,9});
	ListNode l3 = ListNode.createListNodefromArr(new int[]{1});
	
	List<Integer> a1 = Arrays.asList(new Integer[]{2,1,8});
	List<Integer> a2 = Arrays.asList(new Integer[]{5,4,9,6});
	List<Integer> a3 = Arrays.asList(new Integer[]{1});

	@Test
	public final void testSwapPairs() {
		Assert.assertEquals(a1, ListNode.printListNodeValue(solution.swapPairs(l1)));
		Assert.assertEquals(a2, ListNode.printListNodeValue(solution.swapPairs(l2)));
		Assert.assertEquals(a3, ListNode.printListNodeValue(solution.swapPairs(l3)));
		
	}

}
