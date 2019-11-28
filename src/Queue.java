// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private int capacity, currentSize,front,rear;
    NodeBase<V>[] queue;
    public Queue(int capacity) {    
    	this.capacity=capacity;
    	currentSize=0;
    	front=0;
    	rear=0;
    	queue=new NodeBase[capacity];
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

    public void enqueue(Node<V> node) {
    	if(currentSize!=capacity)
    	{	
 
        queue[currentSize]=node;
    	rear++;
    	currentSize++;
    	}
    }

    public NodeBase<V> dequeue() 
    {
    	if(currentSize!=0)
    	{
    		NodeBase<V> y= queue[0];
        	for(int l=0;l<currentSize-1;l++)
        	{
        		queue[l]=queue[l+1];
        	}
        	currentSize--;
    	return y;
    	}
    	else
		return null;
    }
}

