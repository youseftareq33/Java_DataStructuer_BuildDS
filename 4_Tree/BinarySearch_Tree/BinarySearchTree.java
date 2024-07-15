

public class BinarySearchTree<T extends Comparable<T>> {
	TNode<T> root;

	
	////////////////////////////////////////////////////////////////
	// to print the tree (recursive)
	
	// print data 
	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(TNode node) {
		if (node != null) {
			if (node.left != null)
				traverseInOrder(node.left);
			System.out.print(node + " ");
			if (node.right != null)
				traverseInOrder(node.right);
		}
	}
	
	// print tree of data
	public void printDiagram() {
        printDiagram(root, "", "");
    }

    private void printDiagram(TNode node, String prefix, String childrenPrefix) {
    	
    	 if (node == null) {
    	        return;
    	    }

    	    System.out.println(prefix + node.data);

    	    String leftPrefix = childrenPrefix + "│   ";
    	    String rightPrefix = childrenPrefix + "    ";
    	    
    	    if (node.right != null) {
    	        leftPrefix = rightPrefix;
    	    }

    	    printDiagram(node.left, leftPrefix + "├── ", leftPrefix);
    	    printDiagram(node.right, rightPrefix + "└── ", rightPrefix);
    }
	
	////////////////////////////////////////////////////////////////
	// if the tree is empty
    /* check if tree empty or not   if root= null --> true
     *                              if root != null --> false */
	
    public boolean isEmpty() {
    	if(root==null) {
    		return true;
    	}
    	else {
    		return false;
    	}
	}
	
	///////////////////////////////////////////////////////////////
	// insert
    /* to insert data to the tree   if tree is empty --> insert as root
     * 								else if the data we insert > root --> insert right
     * 								else left   */
	
    public void insert(T data) {
		
		if (isEmpty()) {
			root = new TNode<>(data);
		}	
		else {
			insert(data, root);
		}	
	}

	private void insert(T data, TNode node) {
		if(node.data.compareTo(data)>0) { // insert left
			if(!node.hasLeft()) {
				node.left=new TNode<>(data);
			}
			else {
				insert(data,node.left);
			}
		} 
		else { // insert right
				if(!node.hasRight()) {
					node.right=new TNode<>(data);
				}
				else {
					insert(data,node.right);
				}
		}
	}
	
	///////////////////////////////////////////////////////////////
	// find
	/* if the tree has a root(node !=null) --> compare data
	 * 													    if the (data = root) --> root
	 *                                                      if the (data > root) --> -1(right)
	 *                                                      if the (data < root) -->  1(left)  */
	
	
	public TNode find(T data) {
		return find(data, root);
	}

	private TNode find(T data, TNode node) {
		
		if (node != null) {
			int comp = node.data.compareTo(data);
			
			if (comp == 0) { // root
				return node;
			}
			else if (comp > 0 && node.hasLeft()) { // comp= 1 --> left
				return find(data, node.left);
			}
			else if (comp < 0 && node.hasRight()) { // comp= -1 --> right
				return find(data, node.right);
			}
				
		}
		return null;
	}

	///////////////////////////////////////////////////////////////
	// even count
	public int countEven() {
		return countEven(root);
	}

	private int countEven(TNode node) {
		if(node==null) {
			return 0;
		}
		else {
			int l_even = countEven(node.left);
			int r_even = countEven(node.right);
			if((int)node.data%2==0) {
				return 1+l_even+r_even;
			}
			
			return l_even+r_even;
		}
			
	}
	
	///////////////////////////////////////////////////////////
	// size of tree
	public int size() {
			return size(root);
		}

	private int size(TNode node) {
			int count=0;
			if(node == null) {
				return 0;
			}
			else {
				return 1+size(node.left)+size(node.right);
			}
			
		}
	
	//////////////////////////////////////////////////////////
	// to print leaf
	public void printLeaves() {
		printLeaves(root);
	}
	
	private void printLeaves(TNode node) {
		if (node != null) {
			if (node.isLeaf())
			System.out.print(node + " ");
			else {
				printLeaves(node.right);
				printLeaves(node.left);
			}
				
		}
	}
	
	//////////////////////////////////////////////////////////
	// to get height of tree
	public int height() {
		return height(root);
	}

	private int height(TNode node) {
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		
		if (node.hasLeft())
			left = height(node.left);
		if (node.hasRight())
			right = height(node.right);
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	//////////////////////////////////////////////////////////
	// to get largest node
	public TNode largest() {
		return largest(root);
	}

	public TNode<T> largest(TNode node) {
		if (node != null) {
			if (!node.hasRight())
				return (node);
			return largest(node.right);
		}
		return null;
	}
	/////////////////////////////////////////////////////////
	// to get smallest node
	public TNode smallest() {
		return smallest(root);
	}

	public TNode<T> smallest(TNode node) {
		if (node != null) {
			if (!node.hasLeft())
				return (node);
			return smallest(node.left);
		}
		return null;
	}
	
	////////////////////////////////////////////////////////
	
}
