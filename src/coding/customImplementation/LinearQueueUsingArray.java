package coding.customImplementation;

public class LinearQueueUsingArray {

	public static void main(String[] args) {
		
		LQueueArray l = new LQueueArray(5);
		System.out.println(l.isEmpty());
		System.out.println(l.isFull());
		l.enqueue(10);
		l.enqueue(20);
		System.out.println(l.peek());
		l.enqueue(30);
		System.out.println(l.dequeque());
		System.out.println(l.peek());
		System.out.println(l.isEmpty());
		System.out.println(l.isFull());
		l.delete();
		System.out.println(l.dequeque());

	}

}

class LQueueArray {
	
	private int top;
	private int begin;
	private int size;
	private int a[];
	
	LQueueArray(int size) {
		this.top = -1;
		this.begin = 0;
		this.size = size;
		a = new int[size];
	}
	
	public void enqueue(int data) {
		if(top == size -1) {
			System.out.println("Queue is full");
			return;
		}
		top++;
		a[top] = data;
	}
	
	public boolean isFull() {
		return (top == size -1);
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void delete() {
		a = null;
		this.top = -1;
		this.begin = -1;
	}
	
	public int dequeque() {
		if(this.begin == -1) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		int data = a[begin];
		begin++;
		//if the last element is dequeued setting the begin and top to initial value
		if(begin > top) {
			this.begin = 0;
			this.top = -1;
		}
		return data;
	}
	
	public int peek() {
		if(this.begin == -1) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		return a[begin];
	}
	
}
