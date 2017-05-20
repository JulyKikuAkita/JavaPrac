package concurrent_prac;

public class LockPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// a simple lock
class Counter{

	  private int count = 0;

	  public int inc(){
	    synchronized(this){
	      return ++count;
	    }
	  }
}

// 
class Counter2{

	  private Lock lock = new Lock();
	  private int count = 0;

	  public int inc() throws InterruptedException{
	    lock.lock();
	    int newCount = ++count;
	    lock.unlock();
	    return newCount;
	  }
	}

// not reentrant
// It is the condition inside the while loop (spin lock) that determines if a thread is allowed to exit the lock() method or not. 
// Currently the condition is that isLocked must be false for this to be allowed, 
// regardless of what thread locked it.
class Lock{
	private boolean isLocked = false;
	
	public synchronized void lock(){
		while(isLocked){
			//the while(isLocked) loop, which is also called a "spin lock"
			try{
				wait();

			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		isLocked = true;
	}
	
	public synchronized void unlock(){
		isLocked = false;
		notify();
	}
}

class ReentrantLock{
	boolean isLocked = false;
	Thread lockedBy = null;
	int lockedCount = 0;
	
	public synchronized void lock() throws InterruptedException{
		
		Thread callingThread = Thread.currentThread();
		while(isLocked && lockedBy != callingThread){
			wait();
		}
		isLocked = true;
		lockedBy = callingThread;
		lockedCount++;
		
	}
	
	public synchronized void unlock(){
		if(Thread.currentThread() == this.lockedBy){
			lockedCount --;
		}
		if(lockedCount == 0){
			isLocked = false;
			notify();
		}
	}
}

