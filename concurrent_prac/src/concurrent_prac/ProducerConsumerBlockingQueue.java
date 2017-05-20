package concurrent_prac;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {
		//Creating BlockingQueue of size 10
		int size = 10;
		BlockingBuffer buf = new BlockingBuffer(size);
        Producer2 producer = new Producer2(buf);
        Consumer2 consumer = new Consumer2(buf);
        
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        for (int i = 0; i < size; i++){
        	String name = "consumer" + i;
        	new Thread(name).start();
        }
        
        System.out.println("Producer and Consumer has been started");
		
	}

}
class BlockingBuffer{
	//private BlockingQueue<Integer> queue;
	private ArrayDeque<Integer> queue;
	private int capacity = 5;
	public BlockingBuffer(int capacity){
		//this.queue = new ArrayBlockingQueue<>(capacity);
		this.queue = new ArrayDeque<Integer>();
		this.capacity = capacity;
	}
	
	public int take() throws InterruptedException{
		while(queue.isEmpty()){
			wait();
		}
		int cur = queue.removeFirst();
		System.out.println("Consumed "+ cur + " Queue has : " + queue.size());
		notifyAll();
		return cur;

	}
	
	public void put(int item) throws InterruptedException{
		while (queue.size() >= capacity){
			wait();
		}
		queue.offer(item);
		System.out.println("Produced "+ item + " Queue has : " + queue.size());
		notifyAll();
	}
}

class Consumer2 implements Runnable{
	BlockingBuffer queue;
    int size;
    
	public Consumer2(BlockingBuffer queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true){
			 try {
				queue.take();
				Thread.sleep(10);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class Producer2 implements Runnable{
	BlockingBuffer queue;
	
	public Producer2(BlockingBuffer queue) {
		this.queue = queue;	
	}

	@Override
	public void run() {
		Random rand = new Random();
		int random = rand.nextInt(9) + 1;  //range 1 - 9
		try{
			queue.put(random);
			Thread.sleep(1);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
};
