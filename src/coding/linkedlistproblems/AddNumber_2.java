package coding.linkedlistproblems;

import coding.linkedlistproblems.LinkedList9.Node9;

public class AddNumber_2 {
	//https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists-set-3/?ref=lbp

	public static void main(String[] args) {
		
		LinkedList9 l1 = new LinkedList9(); 
        l1.append(5); 
        l1.append(6); 
        l1.append(3); 
        System.out.println("L1");
        l1.print();
        System.out.println();
        System.out.println("L2");
        LinkedList9 l2 = new LinkedList9(); 
        l2.append(8); 
        l2.append(4); 
        l2.append(2); 
        l2.print();
        
        l1.reverse();
        l2.reverse();
        System.out.println();
        System.out.println("Reversed: L1");
        l1.print();
        System.out.println();
        System.out.println("Reversed: L2");
        l2.print();
        LinkedList9 l3 = addNumber(l1.head, l2.head) ; 
        l3.reverse();
        System.out.println();
        System.out.println("L3");
        l3.print();

	}
	
	public static LinkedList9 addNumber(Node9 head1, Node9 head2) {
		
		while(head1 ==null && head2 ==null) {
			System.out.println("both are empty list");
			return null;
		}
		 LinkedList9 l3  = new LinkedList9();
		 
		 int carry = 0;
		 int sum = 0;
		 while(head1 !=null || head2 !=null) {
			 
			 int data1 = head1!=null ? head1.data:0;
			 int data2 = head2!=null ? head2.data:0;
			 sum = carry + data1 + data2;
			 carry = sum/10;
			 sum = sum%10;
			 l3.append(sum);
			 
			 head1 = head1!=null? head1.next: null;
			 head2 = head2!=null? head2.next:null;
		 }
		 if(carry >0) {
			 l3.append(carry);
		 }
		 
		return l3;
	}
	

}

class LinkedList9 {

	Node9 head;

	static class Node9 {

		int data;
		Node9 next;

		Node9(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("Null list");
			return;
		}

		Node9 n = head;
		while (n != null) {
			System.out.print(" " + n.data);
			n = n.next;
		}
	}

	public void push(int data) {
		Node9 n = new Node9(data);
		if (head == null) {
			head = n;
			return;
		}

		n.next = head;
		head = n;
	}
	
	public void append(int data) {
		Node9 n = new Node9(data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		Node9 tmp = head;
		
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		
		tmp.next = n;
	}
	
	public void reverse() {
		if(head == null) {
			return;
		}
		
		Node9 curr = head;
		Node9 next = null;
		Node9 prev = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
}
