
public class Node<V> extends NodeBase<V> {
	
	public int priority;
	public V value;
	
	public Node(int priority, V value) {
		this.priority = priority;
		this.value = value;
	}

	//TODO Complete these methods	
	public int getPriority() {
		return priority;
	}

	public V getValue() {
		return value;
	}

}