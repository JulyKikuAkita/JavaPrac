package concurrent_prac;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Multithreading example without Synchronization:
Here is a simple example which may or may not print counter value in sequence and every time we run it, 
it produces different result based on CPU availability to a thread.
 * 
 */
public class TestThreadNotSafe {

	public static void main(String[] args) {
		  PrintDemo PD = new PrintDemo();

	      ThreadDemo T1 = new ThreadDemo( "Thread 1 ", PD );
	      ThreadDemo T2 = new ThreadDemo( "Thread 2 ", PD );
	      ThreadDemo T3 = new ThreadDemo( "Thread 3 ", PD );

	      T1.start();
	      T2.start();
	      T3.start();


	      // wait for threads to end
	      try {
	         T1.join();
	         T2.join();
	    	 T3.join();
	    	 System.out.println(Thread.currentThread().getState());
	      } catch( InterruptedException e) {
	         System.out.println("Interrupted" + e.getLocalizedMessage());
	      }finally{
	    	  PD.printList();
	    	  PD.printSB();
	    	  PD.printField();
	      }

	}

}

class ThreadDemo extends Thread {
	   private Thread t;
	   private String threadName;
	   PrintDemo  PD;

	   ThreadDemo( String name,  PrintDemo pd){
	       threadName = name;
	       PD = pd;
	   }
	   public void run() {
		//synchronized(PD){
	     PD.printCount();
		// }
	     System.out.println("Thread " +  threadName + " exiting.");
	   }
	   /*
	   public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	   */
	}

class PrintDemo {
	int ttl = 0;
	volatile int ttl2 = 0;
	AtomicInteger ai = new AtomicInteger(0);
	List<Integer> res = new ArrayList<Integer>();
	StringBuilder sb = new StringBuilder();
    
	public void printCount(){
        try {
            for(int i = 2; i > 0; i--) {
            	ttl++;
            	ttl2++;
            	//ai.getAndIncrement();
            	res.add(i);
            	sb.append(i + " ");
            	System.out.println();
                System.out.println(Thread.currentThread().getName() + " Counter------------------------------" + ( ttl) );
                System.out.println(Thread.currentThread().getName() + " Volatile---------------------" + ( ttl2));
                System.out.println(Thread.currentThread().getName() + " Atomic-------------" + ( ai.getAndIncrement()));
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
	public void printField(){
		System.out.println("int = " + ttl);
		System.out.println("volatile = " + ttl2);
		System.out.println("atomic = " + ai);
	}
	
	public void printList(){
		System.out.print( "List: ");
		for(int i: res){
			System.out.print(i + " ");
		}
		System.out.println();
	}
    
	public void printSB(){
		System.out.print( "SB  : ");
		System.out.println(sb.toString());
		
	}
    
}