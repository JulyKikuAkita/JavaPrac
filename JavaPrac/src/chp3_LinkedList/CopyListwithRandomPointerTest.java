package chp3_LinkedList;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class CopyListwithRandomPointerTest {
	CopyListwithRandomPointer solution = new CopyListwithRandomPointer();
	
	RandomListNode l1 = RandomListNode.createListNodefromArr(new int[]{1,2,8});
	RandomListNode l2 = RandomListNode.createListNodefromArr(new int[]{4,5,6,9});  //return null
	//RandomListNode l3 = RandomListNode.createListNodefromArr(new int[]{-19,-9,9});
	

	// how to verify random node matches? 
	// option 1) loop through list and cmp if random node is the same?
	@Test
	public final void testCopyRandomListl2() {
		RandomListNode r2 = RandomListNode.createRandomListNodeToPrev(l2);
		//RandomListNode t2 = solution.copyRandomList(r2);
		
				
		//Assert.assertEquals(Arrays.asList(new Integer[]{4,5,6,9}), RandomListNode.printListNodeValue(t2));
		//Assert.assertEquals(RandomListNode.printRandomListNodeRandomValue(r2), RandomListNode.printRandomListNodeRandomValue(t2));
		
	}
	
	@Test
	public final void testCopyRandomListl1() {
		RandomListNode r1 = RandomListNode.createRandomListNodeToPrev(l1);
		//RandomListNode t1 = solution.copyRandomList(r1);
	
		
		//Assert.assertEquals(Arrays.asList(new Integer[]{1,2,8}), RandomListNode.printListNodeValue(t1));
	    //Assert.assertEquals(RandomListNode.printRandomListNodeRandomValue(r1), RandomListNode.printRandomListNodeRandomValue(t1));
		
	}
	
	@Test
	public final void testCopyRandomListl3() {
		RandomListNode l3 = new RandomListNode(-19);
		RandomListNode l31 = new RandomListNode(-9);
		RandomListNode l32 = new RandomListNode(9);
		
		l3.next = l31;
		l3.random = null;
		l31.next = l32;
		l31.random = l3;
		l32.random = l31;
		
		RandomListNode t3 = solution.copyRandomList(l3);
		Assert.assertEquals(Arrays.asList(new Integer[]{-19, -9, 9}), RandomListNode.printListNodeValue(t3));
	    Assert.assertEquals(RandomListNode.printRandomListNodeRandomValue(l3), RandomListNode.printRandomListNodeRandomValue(t3));
		
	}
	
	@Test
	public final void testCopyRandomListClonedNodel3() {
		RandomListNode l3 = new RandomListNode(-2);
		RandomListNode l31 = new RandomListNode(-1);
		RandomListNode l32 = new RandomListNode(0);
		
		l3.next = l31;
		l3.random = null;
		l31.next = l32;
		l31.random = l3;
		l32.random = l31;
		
		RandomListNode t3 = solution.copyRandomListClonedNodes(l3);
		Assert.assertEquals(Arrays.asList(new Integer[]{-2,-1,0}), RandomListNode.printListNodeValue(t3));
	    Assert.assertEquals(RandomListNode.printRandomListNodeRandomValue(l3), RandomListNode.printRandomListNodeRandomValue(t3));
		
	}

}
