
public class CDNode<T extends Comparable<T>> {

	private T data;
	private CDNode<T> next;
	private CDNode<T> prev;
	
	////////////////////////////////////////////////
	// Constructor
	public CDNode(T data) {
		this.data = data;
	}

	////////////////////////////////////////////////
	// getter and setter
	public T getData() {
		return data;
	}
	
	public CDNode<T> getNext() {
		return next;
	}

	public CDNode<T> getPrev() {
		return prev;
	}
	
    /////////////////////
	public void setNext(CDNode<T> next) {
		this.next = next;
	}

	public void setPrev(CDNode<T> prev) {
		this.prev = prev;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	////////////////////////////////////////////////
//	@Override
//	public String toString() {
//		if (getNext() != null)
//			return data + " -> " + getNext();
//		else
//			return data + " -> " + "NULL";
//	}
}
