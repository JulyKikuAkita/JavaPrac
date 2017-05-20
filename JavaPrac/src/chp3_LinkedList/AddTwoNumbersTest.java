package chp3_LinkedList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {
	AddTwoNumbers solution = new AddTwoNumbers();
	ListNode l1 = ListNode.createListNodefromArr(new int[]{1,2,8});
	ListNode l2 = ListNode.createListNodefromArr(new int[]{4,5,6,9});
	List<Integer> a1 = Arrays.asList(new Integer[]{5,7,4,0,1});
	
	ListNode l3 = ListNode.createListNodefromArr(new int[]{9,9,9,9,9,9});
	ListNode l4 = ListNode.createListNodefromArr(new int[]{1,1,1});
	List<Integer> a2 = Arrays.asList(new Integer[]{0,1,1,0,0,0,1});
	
	
	
	@Test
	public final void testAddTwoNumbers() {
		ListNode try1 = solution.addTwoNumbers(l1, l2);
		Assert.assertEquals(a1, ListNode.printListNodeValue(try1));
		
		ListNode try2 = solution.addTwoNumbers(l3, l4);
		Assert.assertEquals(a2, ListNode.printListNodeValue(try2));
		
	}
	
	
	
	
	

}
