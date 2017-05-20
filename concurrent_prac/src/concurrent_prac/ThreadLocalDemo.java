package concurrent_prac;
//http://netjs.blogspot.com/2015/07/when-and-how-to-use-thread-local-class-in-java.html
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
/*
public class ThreadLocalDemo {

	public static void main(String[] args) {
		MyClass mc1 = new MyClass();
        Thread thread1 = new Thread(mc1, "Thread-1");
        Thread thread2 = new Thread(mc1, "Thread-2");
        Thread thread3 = new Thread(mc1, "Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
	}

}
*/

public class ThreadLocalDemo implements Runnable {
    // threadlocal variable is created
    private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            System.out.println("Initializing SimpleDateFormat for - " + Thread.currentThread().getName() );
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    };
            
    public static void main(String[] args) {
        ThreadLocalDemo td = new ThreadLocalDemo();
        // Two threads are created
        Thread t1 = new Thread(td, "Thread-1");
        Thread t2 = new Thread(td, "Thread-2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("Thread run execution started for " + Thread.currentThread().getName());
        System.out.println("Date formatter pattern is  " + dateFormat.get().toPattern());
        System.out.println("Formatted date is " + dateFormat.get().format(new Date()));
    } 

}

//This class will provide a thread local variable which
//will provide a unique ID for each thread
class ThreadId {
	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	// private static final ThreadLocal<Integer> threadId = ThreadLocal.<Integer>withInitial(()-> {return nextId.getAndIncrement();}); //not working
	// Thread local variable containing each thread's ID
	private static final ThreadLocal<Integer> threadId =
			new ThreadLocal<Integer>() {
		@Override 
		protected Integer initialValue() {
			return nextId.getAndIncrement();
		}
	};
	// Returns the current thread's unique ID, assigning it if necessary
	public static int get() {
		return threadId.get();
	}
}

//In this class thread's run method is executed
class MyClass implements Runnable{
   @Override
   public void run() {
     System.out.println("Thread " + Thread.currentThread().getName() + " Value - " +  ThreadId.get());
   }
}