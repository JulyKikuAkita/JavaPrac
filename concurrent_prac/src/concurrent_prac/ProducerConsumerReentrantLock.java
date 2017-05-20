package concurrent_prac;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class ProducerConsumerReentrantLock {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
	    Condition condition = lock.newCondition();
	    Producer producer = new Producer(observed, lock, condition);
	    Consumer consumer = new Consumer(observed, lock, condition);
	    Thread t1 = new Thread(producer, "producer -t1");
	    Thread t2 = new Thread(consumer, "consumer -t2");
	    t1.start();
	    t2.start();
	}
	
	static class Observed {
	    boolean filled = false;

	    public void setFilled(boolean filled) {
	        this.filled = filled;
	    }

	    public boolean getFilled() {
	        return filled;
	    }
	}

	static Observed observed = new Observed();

	static class Consumer implements Runnable {
	    Observed observed;
	    ReentrantLock lock;
	    Condition condition;

	    Consumer(Observed observed, ReentrantLock lock, Condition condition) {
	        this.observed = observed;
	        this.lock = lock;
	        this.condition = condition;
	    }

	    @Override
	    public void run() {
	        lock.lock();
	        try {
	            for (int i = 0; i < 20; i++) {
	                if (observed.getFilled() == false) {
	                    try {
	                        System.out.println("consumer waiting");
	                        condition.await();
	                        System.out.println("consumed");

	                        Thread.sleep(400 + 1000 * i % 2);
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                    observed.setFilled(false);
	                    condition.signalAll();
	                }else{
	                    observed.setFilled(false);
	                    condition.signalAll();
	                }
	            }
	        } finally {
	            lock.unlock();
	        }

	    }
	}

	static class Producer implements Runnable {
	    Observed observed;
	    ReentrantLock lock;
	    Condition condition;

	    Producer(Observed observed, ReentrantLock lock, Condition condition) {
	        this.observed = observed;
	        this.lock = lock;
	        this.condition = condition;
	    }

	    @Override
	    public void run() {
	        lock.lock();
	        try {
	            for (int i = 0; i < 20; i++) {
	                if (observed.getFilled() == true) {
	                    try {
	                        System.out.println("producer waiting");
	                        condition.await();
	                        System.out.println("produced");
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                    observed.setFilled(true);
	                    condition.signalAll();
	                }else{
	                    observed.setFilled(true);
	                    condition.signalAll();
	                }
	            }
	        } finally {
	            lock.unlock();
	        }

	    }
	}


}
