/**
 * 
 */
package chp3_LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 */
public class ListNode {
	int val;
	ListNode next;
	/**
	 * 
	 */
	public ListNode( int x ) {
		val = x;
		next = null;
	}
	
	public static <T extends ListNode> T createListNodefromArr( int[] x ) {
		ListNode dummyhead = new ListNode(0);
		ListNode ptr = dummyhead;
		for(int i=0; i < x.length ; i++){
			ptr.next = new ListNode(x[i]);
			ptr = ptr.next;
			System.out.println(ptr.val);
		}
		return (T) dummyhead.next;
	}
	
	
	public static List<Integer> printListNodeValue( ListNode x){
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

}
