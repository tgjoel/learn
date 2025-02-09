package coding.linkedlistproblems;

public class ReverseLinkedList_Iterative {

	public static void main(String[] args) {
		
		LinkedList7 linkedList7 = new LinkedList7();
		
		linkedList7.push(10);
		linkedList7.push(20);
		linkedList7.push(30);
		linkedList7.push(40);
		linkedList7.push(50);
		
		System.out.println("Before");
		linkedList7.print();
		System.out.println();
		System.out.println("After");
		linkedList7.reverse();
		linkedList7.print();

	}

}

class LinkedList7 {
	
	Node7 head;
	
	static class Node7 {
		
		int data;
		Node7 next; 
		Node7(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head ==null ) {
			System.out.println("Null list");
			return;
		}
		
		Node7 n = head;
		while(n!=null) {
			System.out.print(" " + n.data);
			n = n.next;
		}
	}
	
	public void push(int data) {
		Node7 n = new Node7(data);
		if(head == null) {
			head = n;
			return;
		}
		
		n.next = head;
		head = n;
	}
	
	public void reverse() {
		
		Node7 prev = null;
		Node7 next = null;
		Node7 curr = head;
		
		while(curr !=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;	
		}
		// pointing the head to the current first element
		head = prev;
	}
}
