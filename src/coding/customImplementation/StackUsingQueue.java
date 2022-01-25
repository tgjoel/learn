package coding.customImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	public static void main(String[] args) {
		QueueStack s = new QueueStack();
		System.out.println(s.pull());
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pull());
		System.out.println(s.pull());
		System.out.println(s.pull());
		System.out.println(s.pull());
		System.out.println(s.pull());
	}

}

class QueueStack {
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int n) {
		if(q1.isEmpty()) {
			q1.add(n);
			return;
		}
		
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		
		q1.add(n);
		
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
	}
	
	public int pull() {
		if(q1.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		return q1.poll();
	}
}
