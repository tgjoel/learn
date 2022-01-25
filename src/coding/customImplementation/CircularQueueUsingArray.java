package coding.customImplementation;

public class CircularQueueUsingArray {

	public static void main(String[] args) {

		CQueueArray c = new CQueueArray(3);
		System.out.println(c.isEmpty());
		System.out.println(c.isFull());
		c.enqueue(10);
		c.enqueue(20);
		c.enqueue(30);
		c.enqueue(40);
		System.out.println(c.isFull());
		System.out.println(c.dequeuqe());
		System.out.println(c.peek());
		c.enqueue(40);
		c.enqueue(50);
		
	}

}

class CQueueArray {
	
	private int top;
	private int begin;
	private int size;
	private int a[];
	
	public CQueueArray(int size) {
		this.size = size;
		this.top = -1;
		this.begin = 0;
		a = new int[size];
	}
	
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		// will be full is begin is 0 and top is at last
		// will be full when top is 1 behind the beging
		// will be empty when top != -1
		return (top !=-1 && ((top == size - 1 && begin == 0) || (top == begin-1)));
	}
	
	public void enqueue(int data) {
		if(this.isFull()) {
			System.out.println("Queue is full");
			return;
		}
		
		if(top == size -1) {
			top = 0;  // queue is not full but top is pointing to the length of array and we have space in the beginnging
		} else {
			top++; //normal flow increasing the top of the array and inserting the data
		}
		a[top] = data;
	}
	
	public int dequeuqe() {
		if(top == -1) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		
		int data = a[begin];
		
		//if there was only one element
		if(top == begin) {
			top = -1;
			begin = 0;
		} else if(begin == size -1) { //resetting the beginning of the queue when last element is dequeued
			this.begin = 0;
		} else {
			begin++;
		}
		
		return data;
	}
	
	public void delete() {
		this.top = -1;
		this.begin = 0;
		this.a = null;
	}
	
	public int peek() {
		if(top == -1) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		return a[begin];
	}
}
