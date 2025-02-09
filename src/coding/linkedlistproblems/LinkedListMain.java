package coding.linkedlistproblems;

public class LinkedListMain {

	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		
		linkedList.append(50);
		
		linkedList.insertFirst(40);
		
		linkedList.insertAfter(linkedList.head, 45);
		
		linkedList.append(60);
		
		System.out.println("Linked List");
		linkedList.print();

	}

}

class LinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}	
	}
	
	public void print() {
		Node n = head;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAfter(Node prevNode, int data) {
		
		if(prevNode == null) {
			System.out.println("error");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}
	
	public void append(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = newNode;
	}
}
