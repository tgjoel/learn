package coding.queueproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

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
		
		reverseQueue(q);
		q.forEach(System.out::print);
		
		reverseByrecursion(q);
		System.out.println();
		System.out.println("After");
		q.forEach(System.out::print);
		

	}

	private static void reverseQueue(Queue<Integer> q) {
		
		Stack<Integer> s = new Stack<>();
		
		//pushing each element to the stack
		while(!q.isEmpty()) {
			s.push(q.remove());
		}
		
		//popping the element out of stack
		while(!s.isEmpty()) {
			q.add(s.pop());
		}
		
	}
	
	private static Queue<Integer> reverseByrecursion(Queue<Integer> q) {
		
		if(q.isEmpty()) {
			return q;
		} 
		
		int data = q.remove();
		
		reverseByrecursion(q);
		q.add(data);
		return q;
	}
	
	

}
