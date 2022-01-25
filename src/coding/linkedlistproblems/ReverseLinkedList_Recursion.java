package coding.linkedlistproblems;

public class ReverseLinkedList_Recursion {

	public static void main(String[] args) {
		LinkedList8 linkedList8 = new LinkedList8();

		linkedList8.push(10);
		linkedList8.push(20);
		linkedList8.push(30);
		linkedList8.push(40);
		linkedList8.push(50);

		System.out.println("Before");
		linkedList8.print();
		System.out.println();
		System.out.println("After");
		linkedList8.reverse();
		linkedList8.print();

	}

}

class LinkedList8 {

	Node8 head;

	static class Node8 {

		int data;
		Node8 next;

		Node8(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("Null list");
			return;
		}

		Node8 n = head;
		while (n != null) {
			System.out.print(" " + n.data);
			n = n.next;
		}
	}

	public void push(int data) {
		Node8 n = new Node8(data);
		if (head == null) {
			head = n;
			return;
		}

		n.next = head;
		head = n;
	}
	
	public void reverse() {
		
		head = reverseList(head, null);
	}

	private Node8 reverseList(Node8 head, Node8 newHead) {
		
		if(head == null) {
			return newHead;
		}
		
		Node8 next = head.next;
		head.next = newHead;
		newHead = head;
		head = next;
		
		return reverseList(head, newHead);
	}

}
