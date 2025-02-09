package coding.customImplementation;

import java.util.Stack;

public class QueueUsingStack {

	public static void main(String[] args) {
		
		StackQueue q1 = new StackQueue();
		
		System.out.println(q1.deQueue1());
		q1.enQueue1(1);
		q1.enQueue1(2);
		q1.enQueue1(3);
		q1.enQueue1(4);
		System.out.println(q1.deQueue1());
		q1.enQueue1(5);
		System.out.println(q1.deQueue1());
		System.out.println(q1.deQueue1());
		System.out.println(q1.deQueue1());
		System.out.println(q1.deQueue1());
		System.out.println(q1.deQueue1());
		
		StackQueue q2 = new StackQueue();
		
		System.out.println(q2.deQueue2());
		q2.enQueue2(10);
		q2.enQueue2(20);
		q2.enQueue2(30);
		q2.enQueue2(40);
		System.out.println(q2.deQueue2());
		q2.enQueue2(50);
		System.out.println(q2.deQueue2());
		System.out.println(q2.deQueue2());
		System.out.println(q2.deQueue2());
		System.out.println(q2.deQueue2());
		System.out.println(q2.deQueue2());
		
		

	}
}

class StackQueue {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public void enQueue1(int n) {
		//making the enqueue costly

		if(s1.isEmpty()) {
			s1.push(n);
			return;
		}

		while(!s1.isEmpty()) {
			// pushing from s1 to s2
			s2.push(s1.pop());
		}
		
		s1.push(n); //pushing the new one to the bottom and popping the s2 back to s1 to maintain the order
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public int deQueue1() {
		if(s1.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		return s1.pop();
	}
	
	public void enQueue2(int n) {
		// making deQueue costly 
		s1.push(n);
	}
	
	public int deQueue2() {
		if(s1.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		int res = s2.pop();
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		
		return res;
	}
}
