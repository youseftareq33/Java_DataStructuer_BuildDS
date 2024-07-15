
public class AVL<T extends Comparable<T>> {

	private TNode<T> root;

	// Constructor
	public AVL() {
		root = null;
	}

	private int getHeightDifference(TNode<T> node) {
	    if (node == null) {
	        return 0;
	    }
	    int leftHeight = getHeight(node.getLeft());
	    int rightHeight = getHeight(node.getRight());
	    return leftHeight - rightHeight;
	}

	// Level of node
	public int getHeight() {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
	}

	private int getHeight(TNode<T> curr) {
		if (curr == null)
			return 0;
		if (curr.isLeaf())
			return 1;
		else
			return Math.max(1 + getHeight(curr.getLeft()), 1 + getHeight(curr.getRight()));
	}

	// Insert
	public void insert(T data) {
	    if (isEmpty())
	        root = new TNode<>(data);
	    else {
	        TNode<T> rootNode = root;
	        addEntry(data, rootNode);
	        root = rebalance(rootNode);
	    }
	}

	public void addEntry(T data, TNode<T> rootNode) {
	    assert rootNode != null;
	    if (data.compareTo(rootNode.getData()) < 0) { // Insert into left subtree
	        if (rootNode.hasLeft()) {
	            TNode<T> leftChild = rootNode.getLeft();
	            addEntry(data, leftChild);
	            rootNode.setLeft(rebalance(leftChild));
	        } else {
	            rootNode.setLeft(new TNode<>(data));
	        }
	    } else { // Insert into right subtree
	        if (rootNode.hasRight()) {
	            TNode<T> rightChild = rootNode.getRight();
	            addEntry(data, rightChild);
	            rootNode.setRight(rebalance(rightChild));
	        } else {
	            rootNode.setRight(new TNode<>(data));
	        }
	    }
	}

	// Delete
	public void delete(T data) {
	    root = delete(root, data);
	}

	private TNode<T> delete(TNode<T> root, T data) {
	    if (root == null)
	        return null;
	    if (data.compareTo(root.getData()) < 0)
	        root.setLeft(delete(root.getLeft(), data));
	    else if (data.compareTo(root.getData()) > 0)
	        root.setRight(delete(root.getRight(), data));
	    else {
	        if (root.getLeft() == null)
	            return root.getRight();
	        else if (root.getRight() == null)
	            return root.getLeft();
	        root.setData(findMin(root.getRight()).getData());
	        root.setRight(delete(root.getRight(), root.getData()));
	    }
	    return root;
	}

	public TNode<T> findMin(TNode<T> node) {
	    if (node == null)
	        return null;
	    else if (node.getLeft() == null)
	        return node;
	    return findMin(node.getLeft());
	}

	// Search
	public TNode<T> search(T data) {
	    return search(root, data);
	}

	private TNode<T> search(TNode<T> root, T data) {
	    if (root == null || root.getData().compareTo(data) == 0) {
	        return root;
	    } else if (data.compareTo(root.getData()) < 0) {
	        return search(root.getLeft(), data);
	    } else {
	        return search(root.getRight(), data);
	    }
	}

	// Rebalance
	private TNode<T> rebalance(TNode<T> nodeN) {
	    int diff = getHeightDifference(nodeN);
	    if (diff > 1) { // Insertion was in node's left subtree
	        if (getHeightDifference(nodeN.getLeft()) > 0)
	            nodeN = rotateRight(nodeN);
	        else
	            nodeN = rotateLeftRight(nodeN);
	    } else if (diff < -1) { // Insertion was in node's right subtree
	        if (getHeightDifference(nodeN.getRight()) < 0)
	            nodeN = rotateLeft(nodeN);
	        else
	            nodeN = rotateRightLeft(nodeN);
	    }
	    return nodeN;
	}

	// Rotate right to left
	private TNode<T> rotateRightLeft(TNode<T> root) {
	    TNode<T> temp = root.getRight();
	    root.setRight(rotateRight(temp));
	    return rotateLeft(root);
	}

	// Rotate left
	private TNode<T> rotateLeft(TNode<T> root) {
	    TNode<T> temp = root.getRight();
	    root.setRight(temp.getLeft());
	    temp.setLeft(root);
	    return temp;
	}

	// Rotate left to right
	private TNode<T> rotateLeftRight(TNode<T> root) {
	    TNode<T> temp = root.getLeft();
	    root.setLeft(rotateLeft(temp));
	    return rotateRight(root);
	}

	// Rotate right
	private TNode<T> rotateRight(TNode<T> root) {
	    TNode<T> temp = root.getLeft();
	    root.setLeft(temp.getRight());
	    temp.setRight(root);
	    return temp;
	}

	public boolean isEmpty() {
	    return root == null;
	}

	// Print AVL
	public void print() {
		print(root);
	}

	private void print(TNode<T> root) {
		if (root == null) {
			return;
		}
		print(root.getLeft());
		System.out.print(root.getData() + " ");
		print(root.getRight());
	}

	// Traverse level
	public String traverseLevel() {
	    StringBuilder sb = new StringBuilder();
	    int h = getHeight(root);
	    int i;
	    for (i = 0; i < h; i++) {
	        sb.append(printLevel(root, i, 0)).append("\n\n");
	    }
	    return sb.toString();
	}

	private String printLevel(TNode<T> root, int i, int j) {
		if (root != null) {
			if (i == j)
				return root.data + " ";
			if (j > i)
				return "NULL";

			return printLevel(root.getLeft(), i, j + 1) + " " + printLevel(root.getRight(), i, j + 1);
		} else
			return "NULL";
	}

	// Clear
	public void clear() {
        root = null;
    }
}
