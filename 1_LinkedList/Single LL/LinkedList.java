
public class LinkedList <T extends Comparable<T> > {
    private Node<T> head;

    ///////////////////////////////--- insert first ---///////////////////////
    public void insertathead(T data) {
        Node<T> newnode = new Node<>(data);
        if(head== null) {
            head = newnode;
        } else {
 
            newnode.setNext(head);
            head = newnode;
        }

    }
    
    
    
    //////////////////////////////--- insert any location ---//////////////
    public void insertAnyLocation(int index,T data) {
		Node<T> newNode=new Node<>(data);
		
		if(index==0) {
			insertathead(data);
		}
		
		else {
			Node<T> curr=head;
			
			for(int i=0;i<index-1;i++) {
				//System.out.println(curr.getData()+"\n");
				curr=curr.getNext();
				
			}
			
			newNode.setNext(curr.getNext());
			curr.setNext(newNode);
			
		}
	
	}
    
    
    //////////////////////////////--- insert at last ---/////////////////////
    
    public void insertatlast(T data) {
        Node<T> newnode = new Node<T>(data);
        
        if(head==null) {
            insertathead(data);
        }
        else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(newnode);
        }
    }

    
    
    /////////////////////////////--- insert sorted ---//////////////////////
    public void insertsorted(T data) {
        Node<T> newnode = new Node<T>(data);
         if (head == null) { // case at empty list
            head = newnode;
        }
         else { //not empty
            Node<T> curr = head;
            Node<T> prev = null;
            while (curr != null && curr.getData().compareTo(data) > 0) {
                prev = curr;
                curr = curr.getNext();
            }
            if (prev == null) { // case at head
                newnode.setNext(head);
                head = newnode;
            }
            else { // case at middle or last
                newnode.setNext(curr);
                prev.setNext(newnode);
            }
        }
    }

    
    
    /////////////////////////////--- delete ---/////////////////////////
    
	public void delete(T data) {
		Node<T> curr = head;
		Node<T> prev = null;
		while (curr != null) {
			if (curr.getData().compareTo(data) == 0) { // found
				if (prev == null) { // case at head
					head = curr.getNext();
				} else { // case at middle or last
					prev.setNext(curr.getNext());
				}
			} // not found
			prev = curr;
			curr = curr.getNext();
		}
	}
	
    
	
	/////////////////////////////--- search ---/////////////////////////////
    public T search (T data) {
    	Node<T> curr = head;
    	String x[];
    	//scan_x=sc_scan.nextLine().split(",");
    	while(curr != null) {
    		x=curr.getData().toString().split(",");
    		if(x[0].equals(data) ) {
    			return curr.getData();
        		
    		}
    		else {
    			curr = curr.getNext(); 	   	
    		}
    			
    	}    	
    	return null;
    }
		
    

    ////////////////////////////--- show data ---////////////////////////
    public void show() {
		Node<T> curr=head;
		while(curr != null) {
			//System.out.print(curr.getData()+" --> ");
			
			System.out.print("\n"+"                          "+curr.getData()+"\n\n"
			+ "                                     |"
			+ "\n"+"                                     V\n\n");
			
			//////////////////////////////////////////////////////////////////
			curr=curr.getNext();
			
			///////////////////////////////////////////////////////////////
		}
		System.out.print("                                    "+"null"+"\n\n\n");
	}
    
    
    
    ///////////////////////////--- to string ---///////////////////////
    @Override
    public String toString() {
    	String res="head --> ";
    	Node<T> curr=head;
    	while(curr!=null) {
    		res+= curr.getData()+" --> ";
    		curr=curr.getNext();
    	}
    	
    	return res+"null";
    }

}



