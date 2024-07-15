

public class TNode<T extends Comparable<T>> {
	T data;
	TNode<T> left;
	TNode<T> right;

	////////////////////////////////////////////////
	// constructor
	
	public TNode(T data) {
		this.data = data;
	}
	
	////////////////////////////////////////////////
	// setter and getter
	
	// data
	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	// left node
	public TNode getLeft() {
		return left;
	}

	public void setLeft(TNode left) {
		this.left = left;
	}

	// right node
	public TNode getRight() {
		return right;
	}

	public void setRight(TNode right) {
		this.right = right;
	}

	////////////////////////////////////////////////
	// check if the tree has a leaf
	/*Leaf: node without children*/
	
	public boolean isLeaf() {
		return (left == null && right == null);
	}

	////////////////////////////////////////////////
	// check if the tree has a left node
	
	public boolean hasLeft() {
		return left != null;
	}

	////////////////////////////////////////////////
	// check if the tree has a right node
	
	public boolean hasRight() {
		return right != null;
	}
	
	////////////////////////////////////////////////
	// toString for tree
	
	@Override
	public String toString() {
		return "[" + data + "]";
	}
}
