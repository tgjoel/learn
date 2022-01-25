package coding.queueproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		
		System.out.println("before");
		q.forEach(System.out::print);
		System.out.println();
		System.out.println("After");
		
		reverseKElementsQueue(q, 3);
		q.forEach(System.out::print);
		System.out.println();
		
		reverseKElementsQueue(q, 5);
		q.forEach(System.out::print);
		System.out.println();
		
		reverseKElementsQueue(q, 50);
		q.forEach(System.out::print);
		System.out.println();
		
	}

	private static void reverseKElementsQueue(Queue<Integer> q, int k) {
		if(q.isEmpty()) {
			return;
		}
		
		Stack<Integer> s = new Stack<>();
		
		int oldSize = q.size();
		int count = 0;
		//adding the elements to the stack for reversing
		while(!q.isEmpty() && count < k) {
			s.push(q.remove());
			count++;
		}
		
		//adding the elements back to the queue after reversing
		while(!s.isEmpty()) {
			q.add(s.pop());
		}
		
		//now adding the rest of the elements from the beginning to the back of the queue
		while(k< oldSize) {
			q.add(q.remove());
			k++;
			
		}
		
	}
	
}
