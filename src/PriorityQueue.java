
public class PriorityQueue<V> implements QueueInterface<V>{

   
    private int capacity, currentSize;
    private NodeBase<V>[] queue;
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {    
    	this.capacity=capacity;
    	this.currentSize=0;
    	queue= new NodeBase[capacity];
    }
    

 
    public int size() {
    	return currentSize;
    }

    public boolean isEmpty() {
    	if(currentSize==0)
    		return true;
    	else
    		return false;
    }
	
    public boolean isFull() {
    	if(currentSize==capacity)
    		return true;
    	else
    		return false;
    }

    public void enqueue(Node<V> node) 
    {
    	if(currentSize<capacity) {
    	queue[currentSize]=node;
    	currentSize++;
    	}
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public void add(int x, String s5)
    {}
    
    public NodeBase<V> removeMin()
    {
		return null;
	}
    public NodeBase<V> dequeue() {
    	//remove min priority element
    	if(currentSize!=0)
    	{
    		//System.out.println("Hello Manoj");
    	int x=queue[0].getPriority();
    	int index=0;
//    	System.out.println("size = "+currentSize);
//    	System.out.println();
    	for(int j=1;j<currentSize;j++)
    	{
    		
//    		System.out.println("value of j = "+j);
//    		System.out.println(queue[j]);
    		NodeBase<V> a = queue[j];
    		if(x > a.getPriority())
    		{
    			x=a.getPriority();
    			index=j;
    		}
    	}
    	
    	
    	NodeBase<V> y= queue[index];
    	for(int l=index; l<currentSize-1; l++)
    	{
    		queue[l]=queue[l+1];
    	}
    	currentSize--;
    	return y;
    	}
    	else {
    		//stem.out.println("Ashwini");
    		return null;
    	}
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i].show();
	}
    }
}

