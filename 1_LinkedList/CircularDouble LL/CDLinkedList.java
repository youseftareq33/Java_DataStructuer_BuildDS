
public class CDLinkedList <T extends Comparable<T>>{
	 private CDNode<T> head;
	 
	 //Insert
	 ///////////////////////////////--- insert at head ---///////////////////////
	 public void insertAtHead(T data) {
	        CDNode<T> newNode = new CDNode<>(data);
	        CDNode<T> curr=head;
	        
	        if (curr == null) {
	            head = newNode;
	            newNode.setNext(head);
	            newNode.setPrev(head);
	        }
	        else {
	            newNode.setNext(curr);
	            newNode.setPrev(curr.getPrev());
	            curr.getPrev().setNext(newNode);
	            curr.setPrev(newNode);
	            head = newNode;
	        }
	    }
	 
	 //////////////////////////////--- insert at last ---/////////////////////	 
	 public void insertAtLast(T data) {
	        CDNode<T> newNode = new CDNode<>(data);
	        CDNode<T> curr=head;
	        
	        if (curr == null) {
	            head = newNode;
	            newNode.setNext(head);
	            newNode.setPrev(head);
	        } 
	        else {
	            newNode.setPrev(curr.getPrev());
	            newNode.setNext(curr);
	            curr.getPrev().setNext(newNode);
	            curr.setPrev(newNode);
	        }
	    }

	 /////////////////////////////--- insert sorted ---//////////////////////
	 public void insertSorted(T data) {
		    CDNode<T> newNode = new CDNode<>(data);
		    CDNode<T> curr=head;
		    if (curr == null) {
		        head = newNode;
		        newNode.setNext(head);
		        newNode.setPrev(head);
		    }
		    else {
		        while (curr.getNext() != head && curr.getData().compareTo(data) < 0) {
		            curr = curr.getNext();
		        }
		        newNode.setNext(curr.getNext());
		        newNode.setPrev(curr);
		        curr.getNext().setPrev(newNode);
		        curr.setNext(newNode);
		    }
		}

	 
	 
	 
	 
	 
	 //Delete
	 /////////////////////////////--- delete from head ---/////////////////////////
	 public void deleteFromHead() {
	        CDNode<T> curr=head;
	        if (curr == null) {
	            return;
	        }
	        else {
	            curr.getPrev().setNext(curr.getNext());
	            curr.getNext().setPrev(curr.getPrev());
	            head = curr.getNext();
	        }
	    }

	 /////////////////////////////--- delete from last ---/////////////////////////
	 public void deleteFromLast() {
	        CDNode<T> curr=head;
	        if (curr == null) {
	            return;
	        }
	        else {
	            curr.setPrev(curr.getPrev().getPrev());
	            curr.getPrev().setNext(curr);
	        }
	    }

	 /////////////////////////////--- delete At Index ---/////////////////////////
		public void deleteAtIndex(int index) {
			CDNode<T> curr = head;
			if (curr == null) {
				return;
			}

			int count = 0;
			while (count < index) {
				curr = curr.getNext();
				count++;
			}

			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
			if (index == 0) {
				head = curr.getNext();
			}
		}
	 
	 
	 
	 
	 
	 //Search
	 public T search(T data) {
		    CDNode<T> curr=head;
		    if (curr == null) {
		        return null;
		    } else {
		        while(curr != head) {
		            if (curr.getData().equals(data)) {
		                return curr.getData();
		            }
		            curr = curr.getNext();
		        }
		    }
		    return null;
		}

	 
	 
	 
	 
	 //Print Data
	 ////////////////////////////--- show data ---////////////////////////
	 public void showCDL() {
		    CDNode<T> curr = head;
		    if (curr == null) {
		        System.out.println("There is no data");
		        return;
		    }
		    System.out.print("Head --> ");
		    while (curr.getNext() != head) {
		        System.out.print(curr.getData() + " --> ");
		        curr = curr.getNext();
		    }
		    System.out.print(curr.getData() + " --> Null");
		}
	 
	 ///////////////////////////--- to string ---///////////////////////
	 @Override
	 public String toString() {
	    	String res="head --> ";
	    	CDNode<T> curr=head;
	    	while(curr!=null) {
	    		res+= curr.getData()+" --> ";
	    		curr=curr.getNext();
	    	}
	    	
	    	return res+"null";
	    }

}
