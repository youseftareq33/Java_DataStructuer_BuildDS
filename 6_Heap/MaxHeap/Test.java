
public class Test {

	public static void main(String[] args) {
		MaxHeap max_heap=new MaxHeap();
		
		max_heap.insert("A", 5);
		max_heap.insert("B", 3);
		max_heap.insert("C", 4);
		max_heap.insert("D", 8);
		max_heap.insert("E", 12);

		max_heap.printData();
		
		System.out.println("remove max: " + max_heap.extractMax());
	    
		System.out.println("Max Heap:");
	    max_heap.printData();
	}

}
