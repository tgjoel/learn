package coding.queueproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Interleave {

	//	Input : 11 12 13 14 15 16 17 18 19 20
	//	Output : 11 16 12 17 13 18 14 19 15 20

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<>();
		q.add(11);
		q.add(12);
		q.add(13);
		q.add(14);
		q.add(15);
		q.add(16);
		q.add(17);
		q.add(18);
		q.add(19);
		q.add(20);
		System.out.println("Before");
		q.forEach(el ->  System.out.print(el + " "));
		System.out.println();
		System.out.println("After");
		interleave(q);
		q.forEach(el ->  System.out.print(el + " "));

	}

	private static void interleave(Queue<Integer> q) {

		Stack<Integer> s = new Stack<>();
		int k = q.size()/2;

		//pushing the first half to the queue
		//s : 15 14 13 12 11
		//q : 16 17 18 19 20
		int count = 0;
		while(count < k) {
			s.push(q.remove());
			count++;
		}

		//adding back numbers reversed to the queue.
		// q: 16 17 18 19 20 15 14 13 12 11
		while(!s.isEmpty()) {
			q.add(s.pop());
		}

		//adding the first half to the back of the queue
		// q: 15 14 13 12 11 16 17 18 19 20
		count = 0;
		while(count < k) {
			q.add(q.remove());
			count++;
		}

		//adding the first half to the stack
		//s: 11 12 13 14 15
		//q: 16 17 18 19 20
		count = 0;
		while(count < k) {
			s.push(q.remove());
			count++;
		}
		
		//now interleaving
		while(!s.isEmpty()) {
			q.add(s.pop());
			q.add(q.remove());
		}

	}

}
