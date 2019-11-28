import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
	
	int sleepTime, catalogSize;
//	public Lock lock;
//	public Condition full;
//	public Condition empty;
//	public PriorityQueue<V> catalog;
//	public Queue<V> inventory;
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
        // ...
    	
    	this.sleepTime=sleepTime;
    	this.catalogSize=catalogSize;
    	this.lock=lock;
    	this.full=full;
    	this.empty=empty;
    	this.catalog=catalog;
    	this.inventory=inventory;
    	setSleepTime(sleepTime);
    }
    
    public void sell() throws InterruptedException {
	try {lock.lock();
            //TODO Complete the try block for produce method
            // ...
		
		while(catalog.isFull())
		{
			full.await();
		}
		if(this.inventory.isEmpty()!=true)
		{Node<V> n3=(Node<V>) inventory.dequeue();
		catalog.enqueue(n3);}//here inventory,dequeue is of NodeBase<V> type instead of Node
		empty.signalAll();	
		 
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
		lock.unlock();
		Thread.sleep(sleepTime);
	}		
    }
}
