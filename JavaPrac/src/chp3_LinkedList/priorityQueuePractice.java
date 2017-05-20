/**
In Java, the PriorityQueue class is implemented as a priority heap. 
# ppt for varies heap : http://www.eecs.wsu.edu/~ananth/CptS223/Lectures/heaps.pdf
# http://www.programcreek.com/2009/02/using-the-priorityqueue-class-example/

 */
package chp3_LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author iflee
 *
 */
public class priorityQueuePractice {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> d1 = Arrays.asList(new Integer[]{1,6,4,3,2,7,9,290,-123});
		List<Integer> d2 = Arrays.asList(new Integer[]{78, -23, -14, 0});
		List<Integer> d3 = Arrays.asList(new Integer[]{1, 5, 5, 2,});
		
		priorityQueuePractice test = new priorityQueuePractice();
		test.pqInitiateM1(d1);
		test.pqInitiateM2(d2);
		test.pqInitiateM2(d3);
		
		System.out.println();
		System.out.println("PQ function calls:");
		test.diffPQCalls(d1);

	}
	
	public void pqInitiateM1(List<Integer> list){
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(); // various of constructor
		for(Integer item : list){
			// use offer() method, rather than add() to add elements to the PriorityQueue pq1 if queue capacity is limited
			pq1.offer(item);
		}
		System.out.println("pq1 = " + pq1);
	}
	
	public void pqInitiateM2(List<Integer> list){
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(list.size(), new pqComparator());
		for(Integer item : list){
			pq2.offer(item);
		}
		System.out.println("pq2 = " + pq2);
	}
	
	static class pqComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer x, Integer y) {
			return x - y;
		}
		
	}
	
	public void pqInitiateM3(List<Integer> list){
		PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(
									 list.size(), 
									 new Comparator<Integer>(){
											public int compare(Integer x, Integer y) {
												return x - y ;
											}
									 }									 
									);
		
		for(Integer item : list){
			pq3.offer(item);
		}
		System.out.println("pq3 = " + pq3);
	}
	
	public void diffPQCalls(List<Integer> list){
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(list.size(), new pqComparator());
		for(Integer item : list){
			pq2.offer(item);
		}
		System.out.println("original pq = " + pq2);
		
				// print size
				System.out.println("size: " + pq2.size());
				System.out.println();
				// return highest priority element in the queue without removing it
				System.out.println("peek() call return value of root " + pq2.peek());
				// print size
				System.out.print("peek() call does not change size: " );
				System.out.println("size after peek(): " + pq2.size());
				System.out.println();
				// return highest priority element and removes it from the queue
				System.out.println("poll() call return and remove root from heap : " + pq2.poll());
				// print size
				System.out.print("poll() call does change size: ");
				System.out.println("size after poll(): " + pq2.size());
		 
				System.out.println("pq2: " + pq2);
		
		
	}
}
