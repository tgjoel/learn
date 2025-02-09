package coding.linkedlistproblems;

import coding.linkedlistproblems.LinkedList5.Node5;
// https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/?ref=lbp
public class AddNumber_1 {

	public static void main(String[] args) {
		
		LinkedList5 first = new LinkedList5();
		first.append(7);
		first.append(5);
		first.append(9);
		first.append(4);
		first.append(6);
		
		System.out.println("First List: ");
		first.print();
		LinkedList5 second = new LinkedList5();
		second.append(8);
		second.append(4);
		System.out.println();
		System.out.println("Second List: ");
		second.print();
		
		LinkedList5 result =  addNumber(first.head, second.head);
		System.out.println();
		System.out.println("Result List: ");
		result.print();
		
		
	}
	
		
	public static LinkedList5 addNumber(Node5 first, Node5 second) {
		
		if(first == null && second == null) {
			System.out.println("Both list are null");
			return null;
		}
		
		LinkedList5 resultant = new LinkedList5();
		int carry = 0, sum = 0, n1, n2;
		
		while(first != null ||  second !=null) {
			
			n1 = first != null ? first.data: 0;
			n2 = second !=null ? second.data: 0;
			
			sum = n1 + n2 + carry;
			
			carry = sum/10;
			sum = sum%10;
				
			
			resultant.append(sum);
			if(first != null) {
				first = first.next;
			}
			if(second !=null) {
				second = second.next;
			}
		
		}
		
		if(carry ==1) {
			resultant.append(carry);
		}
	 
		return resultant;	
		
	}

}

class LinkedList5 {
	
	Node5 head;
	
	static class Node5 {
		Node5 next;
		int data;
		
		Node5(int data) {
			this.data = data;
			this.next = null;
		}	
	}
	
	public void print() {
		if(head == null) {
			System.out.println("No list");
			return;
		}
		
		Node5 n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public void append(int data) {
		
		Node5 n = new Node5(data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		Node5 tmp = head;
		while(tmp.next != null) {
			tmp =tmp.next;
		}
		tmp.next = n;
	}
	
	
}
	
	

