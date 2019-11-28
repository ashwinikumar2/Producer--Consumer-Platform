import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {

	int catalogSize;
//	Lock lock;
//	Condition full;
//	Condition empty;
//	PriorityQueue<V> catalog;
	
	
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty,PriorityQueue<V> catalog,  int iteration) {
        //TODO Complete the Buyer Constructor method
        // ...
   
    	this.catalogSize=catalogSize;
    	this.lock=lock;
    	this.full=full;
    	this.empty=empty;
    	this.catalog=catalog;
    	setIteration( iteration);
    	setSleepTime(sleepTime);
    }
    
    public void buy() throws InterruptedException {
	try {lock.lock();
            //TODO Complete the try block for consume method
            // ...
//	System.out.println("size of catalog  = "+catalog.size() );
			while(catalog.isEmpty())
			{
//				  System.out.println("afhaf");
				empty.await();
			}
			
			NodeBase<V> n=catalog.dequeue();
		   	System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
		   
			n.show(); // DO NOT REMOVE (For Automated Testing)
            // ...
			full.signalAll();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
		lock.unlock();
		
	}
    }
}
