import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Assignment2Driver {
    public static int catalogSize;
    public static int numBuyers;
    public static int numSellers;
    public static int sellerSleepTime;
	public static int buyerSleepTime;
    public static Queue<Item> inventory;
    
    public static void main(String[] args) throws InterruptedException {
	
	Assignment2Driver a_driver = new Assignment2Driver();
	BufferedReader reader;
        int itemcount = 0;
	try {
	    reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
	    ArrayList<Node<Item>> list = new ArrayList<Node<Item>>();
	    String[] tokens = line.split(" ");
	    a_driver.catalogSize = Integer.parseInt(tokens[0]);
	    a_driver.numBuyers = Integer.parseInt(tokens[1]);
	    a_driver.numSellers = Integer.parseInt(tokens[2]);
	    a_driver.buyerSleepTime = Integer.parseInt(tokens[3]);
	    a_driver.sellerSleepTime = Integer.parseInt(tokens[4]);
	    
	    while (line != null) {
		line = reader.readLine();
		if (line != null) {
                    itemcount++;
		    tokens = line.split(" ");
		    Item item = new Item(tokens[1], Double.parseDouble(tokens[2]));
		    Node<Item> node = new Node<Item>(Integer.parseInt(tokens[0]), item);
		    list.add(node);
		}
	    }
            a_driver.inventory = new Queue<Item>(list.size());
        
            //TODO Add all elements of the ArrayList named "list" to inventory queue
            // ...
            
            for(int k=0;k<list.size();k++)
            {
            	Node<Item> n3=list.get(k);
            	if(!inventory.isFull())
            	{
            	inventory.enqueue(n3);
            	}
            }
            
            reader.close();
	} catch (IOException e) {
            e.printStackTrace();
	}
	
	Seller[] sellers = new Seller[a_driver.numSellers];
	Buyer[] buyers = new Buyer[a_driver.numBuyers];
	PriorityQueue<Node<Item>> queue = new PriorityQueue<Node<Item>>(a_driver.catalogSize);
	Lock lock = new ReentrantLock();
	Condition full = lock.newCondition();
	Condition empty = lock.newCondition();
        int iteration = itemcount/a_driver.numBuyers; // No. of purchases each buyer make

	// TODO Create multiple Buyer and Seller Threads and start them.
        // ...
//        System.out.println("Inventory size = "+inventory.size());
        
        for(int i=0;i<numSellers;i++)
        {
        	Seller s=new Seller(sellerSleepTime, catalogSize, lock, full, empty, queue, inventory);
        	Thread t1=new Thread(s);
        	
        	t1.start();
        }
        for(int j=0;j<numBuyers;j++)
        {
        	Buyer b=new Buyer(buyerSleepTime,catalogSize, lock, full, empty, queue, iteration);
        	Thread t2=new Thread(b);
        	
        	t2.start();
        }
    }
}
