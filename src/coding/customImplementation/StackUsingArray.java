package coding.customImplementation;

public class StackUsingArray {

	public static void main(String[] args) {

		StackArray_1 s = new StackArray_1();
	
		s.push(10);
		s.push(20);
		s.push(30);
		
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.isEmpty());
		System.out.println(s.isFull());
		s.push(40);
		System.out.println(s.peek());
		s.delete();
		System.out.println(s.peek());
		
	}

}

class StackArray_1 {
	
	final int MAX = 100; // maximum size of the stack
	int top;
	int[] arr = new int[MAX-1];

	public StackArray_1() {
		top = -1;   // top should made as -1 during the creation
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == MAX-1);
	}
	
	public int peek() {
		if(top == -1) {
			System.out.println("Empty stack");
			return Integer.MIN_VALUE;
		}
		return arr[top];
	}
	
	public void push(int data) {
		if(top == MAX-1) {
			System.out.println("Stack is full");
			return;
		}
		arr[++top] = data;
	}
	
	public int pop() {
		if(top ==-1) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
		int data = arr[top--];
		return data;
	}
	
	public void delete() {
		top = -1;
		arr = null;
	}
}
