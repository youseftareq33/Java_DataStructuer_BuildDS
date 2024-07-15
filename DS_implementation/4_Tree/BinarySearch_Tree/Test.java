

public class Test {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> bst=new BinarySearchTree<>();
		
		//the root
		TNode<Integer> n=new TNode<Integer>(55);
		bst.root=n;
		
		// the children of chhhhhh
		TNode<Integer> n1=new TNode<Integer>(60);
		TNode<Integer> n2=new TNode<Integer>(70);
		n.left=n1;
		n.right=n2;
		TNode<Integer> n3=new TNode<Integer>(80);
		TNode<Integer> n4=new TNode<Integer>(90);
		n2.left=n4;
		n1.right=n3;
		
		
		//bst.printLeaves();
		bst.printDiagram();
		//System.out.println(bst.height());
		
		
		
		
	}

}
