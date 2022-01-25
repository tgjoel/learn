package coding.linkedlistproblems;

import coding.linkedlistproblems.LinkedList4.Node4;

public class DetectAndRemoveLoop {

	public static void main(String[] args) {
		
	 
	 	Node4 one = new Node4(10);
		Node4 two = new Node4(20);
		Node4 three = new Node4(30);
		Node4 four = new Node4(40);
		
		LinkedList4 linkedList4 = new LinkedList4();
		linkedList4.head = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;	
		
		linkedList4.print();
		linkedList4.detectAndRemoveLoop(); 
	 
	}
}
	
	class LinkedList4 {
		
		Node4 head;
		
		static class Node4 {
			int data;
			Node4 next;
			
			Node4(int data) {
				this.data = data;
				this.next = null;
			}
		}
		
		public void print() {
			if(head == null) {
				System.out.println("null list");
				return;
			}
			
			Node4 n = head;
			
			int count = 0;
			
			while(n!=null) {
				System.out.print(n.data + " ");
				n= n.next;
				if(count == 4) {
					System.out.println();
					break; // no required only 	if we want to print the before list 
				}
				count++;
			}
		}
		
		public void detectAndRemoveLoop() {
			
			if(head == null) {
				System.out.println("null list");
				return;
			}
			
			Node4 fast = head;
			Node4 slow = head;
			
			while(fast !=null && fast.next!=null) {
				
				slow = slow.next;
				fast = fast.next.next;	
				
				if(fast==slow) {
					System.out.println("Loop detected at node with data: " + fast.data);
					this.removeLoop(fast);
					break;
				}
				
			}
			
		}

		private void removeLoop(Node4 loopNode) {
			
			Node4 slow = head;
			Node4 fast = loopNode;
			
			while(slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			
			fast.next = null;
			System.out.println("List after removing the list");
			this.print();
			
		}
	}
