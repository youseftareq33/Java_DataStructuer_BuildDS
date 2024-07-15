

public class Test1 {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst= new BinarySearchTree<>();
		
		bst.insert(6);					
		bst.insert(4);
		bst.insert(8);
		bst.insert(3);
		
		bst.insert(5);
    	bst.insert(9);
    	bst.insert(7);
		
		
		System.out.println(bst.find(5));
		
//		System.out.println(bst.countEven());
		
//    	System.out.println(bst.size());
    	
//    	bst.printLeaves();
    	
//    	System.out.println(bst.height());
    	
//    	System.out.println(bst.smallest());
    	
//    	System.out.println(bst.largest());
    	
		//bst.printDiagram();
		
	}

}
