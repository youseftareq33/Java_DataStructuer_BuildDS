
public class Test {

	public static void main(String[] args) {
		MinHeap<String> min_heap= new MinHeap<>();
		
		min_heap.insert("A", 5);
		min_heap.insert("B", 3);
		min_heap.insert("C", 4);
		min_heap.insert("D", 8);
		min_heap.insert("E", 12);
		
		min_heap.printData();
		
	}

}
