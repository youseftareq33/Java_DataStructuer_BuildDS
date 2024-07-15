
public class Driver {

	public static void main(String[] args) {
		DLinkedList<Integer> dl=new DLinkedList<>(); 
		
		dl.insert(10);
		dl.insert(20);
		dl.insert(30);
		dl.insert(40);
		dl.insert(50);
		
		System.out.println(dl.toString());
		
		dl.remove(40);
		
		System.out.println(dl.toString());

		
		System.out.println(dl.search(50));
	}

}
