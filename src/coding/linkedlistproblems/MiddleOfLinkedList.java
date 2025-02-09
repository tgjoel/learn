package coding.linkedlistproblems;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		
		LinkedList2 linkedList2 = new LinkedList2();
		
		linkedList2.append(10);
		linkedList2.append(20);
		linkedList2.append(30);
		linkedList2.append(40);
		linkedList2.append(50);
		linkedList2.append(60);
		linkedList2.append(70);
		linkedList2.append(80);
		//linkedList2.append(90);
		
		linkedList2.print();
		System.out.println();
		linkedList2.middleOfLinkedList();
		linkedList2.middleOfLinkedList2();
		
		

	}

}

class LinkedList2 {
	
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
		if(head ==null) {
			System.out.println("Null list");
			return;
		}
		
		Node n = head;
		
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public void append(int data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node temp = head;
		while(temp.next !=null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
	}
	
	public void middleOfLinkedList() {
		
		if(head == null) {
			System.out.println("No list");
			return;
		}
		
		int count = 0;
		
		Node temp1 = head;
		Node temp2 = head;
		while(temp2!=null && temp2.next !=null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			count++;
		}
		
		System.out.println("Middle: " + count);
		System.out.println("Middle Node Data 1: " + temp1.data);
		
	}
	
	public void middleOfLinkedList2() {
		
		if(head == null) {
			System.out.println("No list");
			return;
		}
		
		int count = 0;
		
		Node temp = head;
		Node mid = head;
		
		while(temp != null) {
			
			if((count % 2) == 1) {
				mid = mid.next;
			}
			temp = temp.next;
			++count;
		}
	
		System.out.println("Middle Node Data 2: " + mid.data);
	}
	
	
	
}
