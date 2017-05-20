import java.util.PriorityQueue;


public class MedianFinder {
		private PriorityQueue<Integer> minHeap;
	    private PriorityQueue<Integer> maxHeap;
	    private int ttl;
	    private double median;

	    
	    
	    public MedianFinder(){
	        minHeap = new PriorityQueue<Integer>();
	        maxHeap = new PriorityQueue<Integer>();
	        //maxHeap = new PriorityQueue<Integer>(Collections.reverseORder());
	        ttl = 0;
	        median = -1;
	    }

	    // Adds a number into the data structure.
	    public void addNum(int num) {
	        if(ttl == 0){
	            minHeap.offer(num);
	        }else{
	            if(num < median){
	                maxHeap.offer(-num);
	            }else{
	                minHeap.offer(num);
	            }
	        }
	            
	        while(Math.abs(minHeap.size() - maxHeap.size()) > 1){
	            if(minHeap.size() > maxHeap.size()){
	                maxHeap.offer(-minHeap.poll());
	            }else{
	                minHeap.offer(-maxHeap.poll());
	            }
	        }
	        ttl++;
	        setMedian();
	    }
	    
	    private void setMedian(){
	        if(ttl % 2 == 1){
	            if(minHeap.size() > maxHeap.size()){
	                median = minHeap.peek();
	            }else{
	                median = -maxHeap.peek();
	            }
	        }else{
	            int fir = minHeap.peek();
	            int sec = -maxHeap.peek();
	            median = (double) (fir + sec) / 2;
	        }
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        return median;
	    }
	    
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
	}


