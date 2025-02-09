package coding.customImplementation;

public class StackUsingLinkedList {

	public static void main(String[] args) {
		Stack_LinkedList_1 s = new Stack_LinkedList_1();
		
		s.push(10);
		s.push(20);
		s.push(30);
		
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.isEmpty());
		s.push(50);
		System.out.println(s.peek());
		s.delete();
		System.out.println(s.peek());
	}

}

class Stack_LinkedList_1 {
	
	Stack_Node_1 head;
	
	 class Stack_Node_1 {
		int data;
		Stack_Node_1 next;
		
		 Stack_Node_1(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void push(int data) {
		Stack_Node_1 n = new Stack_Node_1(data);
		n.next = head;
		head = n;
	}
	
	public int peek() {
		if(head == null) {
			System.out.println("empty stack");
			return Integer.MIN_VALUE;
		}
		return head.data;
	}
	
	public int pop() {
		if(head == null) {
			System.out.println("empty stack");
			return Integer.MIN_VALUE;
		}
		Stack_Node_1 tmp = head;
		head = head.next;
		return tmp.data;
	}
	
	public boolean isEmpty() {
		return head ==null;
	}
	
	public void delete() {
		head = null;
	}
	
}
