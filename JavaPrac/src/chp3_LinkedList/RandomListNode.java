/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package chp3_LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class RandomListNode extends ListNode {
	int label;
	RandomListNode next, random;
	//int value;
	
	public RandomListNode(int x) {
		super(x);
		this.label = x;
		this.random = null;
	}
	
	public static <T extends ListNode> T createListNodefromArr( int[] x ) {
		RandomListNode dummyhead = new RandomListNode(0);
		RandomListNode ptr = dummyhead;
		for(int i=0; i < x.length ; i++){
			ptr.next = new RandomListNode(x[i]);
			ptr = ptr.next;
			//System.out.println(ptr.val +" " + ptr.label);
		}
		return (T) dummyhead.next;
	}

	public static <T extends ListNode> T createRandomListNodeToPrev( RandomListNode x ) {
		RandomListNode dummyhead = new RandomListNode(0);
		dummyhead.next = x;
		RandomListNode ptr = dummyhead;
		RandomListNode sec = x.next;
		while(sec != null){
			sec.random = ptr.next;
			sec = sec.next;
			ptr = ptr.next;
		}
		return (T) dummyhead.next;
		
	}
	
	/* If calls ListNode.printListNodeValue( ListNode x) method, only print the first node;
	 * Other node gets casting exception and returns null
	 * 
	 * Solution is create ListNode generic class
	 * ex: http://code.stephenmorley.org/articles/java-generics-type-erasure/
	 */
	public static List<Integer> printListNodeValue( RandomListNode x){
		List<Integer> result = new ArrayList<Integer>();
		while(x != null){
			result.add(x.val);
			x = x.next;
		}
		//	/*
		System.out.println("The list contains: ");
		// different ways to iterate 
		// Iterator or List iterator : for(Iterator<Integer> iter = result.listIterator(); iter.hasNext(); ){}  
		// basic for loop: for(int i =0 ; i < result.size(); i++ ){ for(Interger element = result.get(i)){} }
		// enhanced for loop:
		
			
		for(Integer item : result){
			System.out.print(item + " -> ");
		}
		   
		System.out.println("null");
		//	*/
		return result;
	}
	
	
	public static List<Integer> printRandomListNodeRandomValue(RandomListNode x){
		List<Integer> result = new ArrayList<Integer>();
		int index = 0;
		
		while(x != null){
			if(x.random == null){
				result.add(null);
			}
			else{
				result.add(x.random.val);
			}
			x = x.next;
		}
		//	/*
		System.out.println("The RNL list Random node value: ");
		// different ways to iterate 
		// Iterator or List iterator : for(Iterator<Integer> iter = result.listIterator(); iter.hasNext(); ){}  
		// basic for loop: for(int i =0 ; i < result.size(); i++ ){ for(Interger element = result.get(i)){} }
		// enhanced for loop:
		
			
		for(Integer item : result){
			System.out.print( "[ " + index+ " ] : "+ item + " -> ");
			index ++;
		}
		   
		System.out.println("null");
		//	*/
		return result;
	}

}
