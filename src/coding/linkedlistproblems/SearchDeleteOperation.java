package coding.linkedlistproblems;

import java.util.Objects;

public class SearchDeleteOperation {

	public static void main(String[] args) {
		
		LinkedList1 l = new LinkedList1();
		
		l.append(10);
		l.append(20);
		l.append(30);
		l.append(40);
		l.append(50);
		l.append(60);
		l.append(70);
		l.print();
		
		System.out.println();
		
		//l.search(50);
		//l.search(40);
		
//		l.deleteNodeWithData2(80);
//		l.deleteNodeWithData2(10);
//		l.deleteNodeWithData2(70);
//		l.deleteNodeWithData2(40);
//		l.print();
		
//		l.deleteNodeAtPosition(2);
//		l.deleteNodeAtPosition(0);
//		l.deleteNodeAtPosition(6);
//		l.deleteNodeAtPosition(4);
//		l.deleteNodeAtPosition(10);
//		l.print();
		
		//l.lengthOflinkedList();
		
		
	}
}
	
	class LinkedList1 {
		Node head;
		
		static class Node {
			
			int data;
			Node next;
			
			Node(int n) {
				this.data = n;
				this.next = null;
			}
			
		}
		
		public void print() {
			 Node n = head;
			 
			 while(n!=null) {
				 System.out.print(n.data + " ");
				 n = n.next;
			 }
		}
		
		public void append(int data) {
			
			Node n = new Node(data);
			
			if(Objects.isNull(head)) {
				head = n;
				return;
			}
			
			Node last = head;
			while(last.next!=null) {
				last = last.next;
			}
			
			last.next = n;
		}
		
		public void push(int data) {
			
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
				return;
			}
			
			newNode.next = head;
			head = newNode;
		}
		
		public void search(int val) {
			
			if(Objects.isNull(head)) {
				System.out.println("List is empty");
				return;
			}
			
			Node n = head;
			while(Objects.nonNull(n)) {
				if(n.data == val) {
					System.out.println("Value found at node: "+ n);
					return;
				}
				n = n.next;
			}
			
			System.out.println("Unable to find the value");
		}
		
		public void deleteNodeWithData1(int val) {
			
			if(head == null) {
				System.out.println("Linkedlist does not exisit");
				return;
			}
			
			//deleting the first node
			if(head.data == val) {
				head = head.next;
				return;
			}
			
			
			Node n = head;
			while(n.next != null) {			
				if(n.next.data == val) {
					Node temp = n.next.next;
					n.next.next = null;
					n.next = temp;
					return;	
				}
				n = n.next;
			}
			
		}
		
		public void deleteNodeWithData2(int val) {
			
			if(head == null) {
				System.out.println("List does not exist");
				return;
			}
			
			
			if(head.data == val) {
				head = head.next;
				return;
			}
			
			Node n = head.next;
			Node prev = head;
			
			while(n!=null && n.data !=val) {
				prev = n;
				n = n.next;
			}
			
			if(n == null) {
				System.out.println("value is not present");
				return;
			}
			
			prev.next = n.next;
			n.next = null;
		}

		
		public void deleteNodeAtPosition(int position) {
			
			if(head == null) {
				System.out.println("list does not exist");
			}
			
			if(position == 0) {
				head = head.next;
				return;
			}
			
			int count = 1;
			Node n = head.next;
			Node prev = head;
			while(n != null) {
				if(count == position) {
					prev.next = n.next;
					return;
				}
				prev = n;
				n = n.next;
				count++;
			}
			
			if(n == null) {
				System.out.println("Invalid position");
			}
			
		}

		public void lengthOflinkedList() {
			
			if(head == null) {
				System.out.println("list does not exist");
				return;
			}
			
			int count = 1;
			Node n = head;
			
			while(n.next!=null) {
				count++;
				n = n.next;
			}
			
			System.out.println("Length: "+ count);
			
		}
		
		public void reverseLinkedList() {
			
			if(head == null) {
				System.out.println("List does not exits");
				return;
			}
			
			LinkedList1 reversedLinkedList = new LinkedList1();
			
			
			
		}
	}
	
