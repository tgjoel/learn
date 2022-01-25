package coding.linkedlistproblems;

import coding.linkedlistproblems.LinkedList3.Node;

public class LoopInLinkedList {

	public static void main(String[] args) {
		
		Node one = new Node(10);
		Node two = new Node(10);
		Node three = new Node(10);
		Node four = new Node(10);
		
		LinkedList3 linkedList3 = new LinkedList3();
		linkedList3.head = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;	
		
		linkedList3.loopInLinkedList();

	}

}

class LinkedList3 {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//Floyd's cycle finding algorithm.
	public void loopInLinkedList() {
		
		if(head == null) {
			System.out.println("No list");
		}
		
		
		Node slow = head;
		Node fast = head;
		boolean flag = false;
		
		while(fast !=null && fast.next != null)  {
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(fast == slow) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("Loop detected");
			return;
		}
		System.out.println("No loop is present");
	}
}
