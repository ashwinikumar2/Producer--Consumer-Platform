ASHWINI KUMAR
2018MT60778
COL106 ASSIGNMENT 2

In this assignment, I implemented several classes such as Node, Queue, PriorityQueue, Seller and 
Buyer.

CLASSES:
NODE: Took two inputs as int priority and V value through constructor and set them as its value 
and priority.

QUEUE: Took input as int capacity through constructor and then created an array of size capacity and 
this array act as a queue from which elements will be taken from first position of this array and 
while doing enqueue element will be added after the last current position.

PRIORITYQUEUE: Took input as int capacity through constructor and then created an array of size 
capacity and this array will act as a queue which has priorities for each node.While doing enqueue 
I will add element at the last and while doing dequeue I will remove the element with minimum 
priority and shift the remaining elements towards left.

SELLER: Passed several variables through constructor and this class has a method named 'sell' which 
removes an element from the inventory and add it to catalog.In the method sell I first synchronised 
the codeblock using the lock.lock() method so that there is no mixing up of threads and then added 
the element in catalog after removing it from inventory.At last I unlocked the current thread and 
set the thread to sleep for specific sleepTime.

BUYER: Passed several variables through constructor and this class has a method named 'sell' which 
removes an element from the catalog.In the method sell I first synchronised 
the codeblock using the lock.lock() method so that there is no mixing up of threads and then removed 
an element form the catalog.Further I unlocked the lock on the current thread and then set it to 
sleep for given sleepTime.

CHANGES IN ASSIGNMENT2DRIVER:
I first added the items in the inventory as objects of the class Item obtained from the arraylist.
Further I created and started threads for each seller and likewise created and started threads for 
each buyer.

Finally took input from a file and then gave output to the system in the form of the "Consumed X" 
where X represents the element with priority as X in the catalog(which is a PriorityQueue).