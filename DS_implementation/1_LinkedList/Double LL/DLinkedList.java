
public class DLinkedList<T extends Comparable<T>> implements Comparable<DLinkedList<T>> {
	private CDNode<T> head;

	// insert 
	public void insert(T data) {
		CDNode<T> add = new CDNode<T>(data), curr = head;

		for (; curr != null
				&& ((data instanceof String) ? (((String) (curr.getData())).compareToIgnoreCase((String) data) < 0)
						: (curr.getData().compareTo(data) < 0)); curr = curr.getNext()) {
			if (curr.getNext() == null) {
				add.setPrev(curr);
				curr.setNext(add);
				return;
			}
		}

		if (head == null) {
			head = add;
		} else if (curr == head) {
			head.setPrev(add);
			add.setNext(head);
			head = add;
		} else {
			add.setNext(curr);
			add.setPrev(curr.getPrev());
			curr.setPrev(add);
			add.getPrev().setNext(add);
		}

	}

	public void insert(@SuppressWarnings("unchecked") T... arr) {
		for (int i = 0; i < arr.length; i++)
			insert(arr[i]);

	}

	// search
	public CDNode<T> search(T data) {
		CDNode<T> curr = head;
		while (curr != null) {
			if (curr.getData().equals(data))
				return curr;
			curr = curr.getNext();
		}
		return curr;
	}

	// delete
	public void remove(T data) {
		CDNode<T> curr = head;

		if (head == null) {
			System.out.println("List is Empty");
			return;
		}

		for (; curr != null && !curr.getData().equals(data); curr = curr.getNext())
			;

		if (curr == null) {
			System.out.println("Not Exist !");
		} else if (curr.getNext() != null && curr.getPrev() != null) {
			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
		} else if (curr.getNext() == null) {
			curr.getPrev().setNext(curr.getNext());
		} else {
			head = curr.getNext();
		}
	}

	// get length
	public int length() {
		return length(head);
	}

	private int length(CDNode<T> curr) {
		if (curr == null)
			return 0;
		else
			return 1 + length(curr.getNext());
	}

	// print data
	@Override
	public String toString() {
		return "Head" + " -> " + head;
	}

	@Override
	public int compareTo(DLinkedList<T> o) {
		return head.getData().compareTo(o.head.getData());
	}

}