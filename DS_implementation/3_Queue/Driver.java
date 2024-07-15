

public class Driver {
	public static void main(String[] args) { // fifo: first in first out
		Queue<Integer> q=new Queue<>();
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		System.out.println(q.toString());
		
		q.dequeue();
		
		System.out.println(q.getFront());

		q.clear();
		System.out.println(q.toString());
		
		
	}
}
