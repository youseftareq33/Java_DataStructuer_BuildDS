
public class Driver {
	public static void main(String[] args) {
		CDLinkedList<Integer> c=new CDLinkedList<>();
		
		c.insertAtHead(10);
		c.insertAtHead(20);
		c.insertAtHead(30);
		
		c.showCDL();
		
		c.deleteAtIndex(1);
		System.out.println("");
		c.showCDL();
	}
}
