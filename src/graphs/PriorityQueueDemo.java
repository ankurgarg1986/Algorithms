package graphs;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String args[]) {
		// create priority queue
		PriorityQueue<Integer> prq = new PriorityQueue<Integer>();

		// insert values in the queue
		for (int i = 0; i < 10; i++) {
			prq.add(new Integer(i));
		}

		// create iterator from the queue
		Iterator<Integer> it = prq.iterator();

		System.out.println("Priority queue values are: ");

		while (it.hasNext()) {
			int val = it.next();
		//	prq.remove(val);
			val = val+10;
			//prq.add(val);
			
		}
		
		Iterator<Integer> it1 = prq.iterator();

		System.out.println("Priority queue values are: ");

		while (it1.hasNext()) {
			System.out.println ( "Value: "+ it.next()); 			
		}

	}
}
