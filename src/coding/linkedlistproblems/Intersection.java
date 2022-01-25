package coding.linkedlistproblems;

import coding.linkedlistproblems.L02_02.N02_02;

public class Intersection {
// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
	public static void main(String[] args) {
		
		L02_02 l = new L02_02();
		
		N02_02 l11 = new N02_02(3);
		N02_02 l12 = new N02_02(1);
		N02_02 l13 = new N02_02(5);
		N02_02 l14 = new N02_02(9);
		N02_02 l15 = new N02_02(7);
		N02_02 l16 = new N02_02(2);
		N02_02 l17 = new N02_02(1);
		
		l.head = l11;
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		l14.next = l15;
		l15.next = l16;
		l16.next = l17;
	
		l.print();
		System.out.println();
		
		
		L02_02 k = new L02_02();
		
		N02_02 k11 = new N02_02(4);
		N02_02 k12 = new N02_02(6);
		
		k.head = k11;
		k11.next = k12;
		//k12.next = l15;
		k.print();
		System.out.println();
		
		checkInterSection(l,k);
	
	}

	private static void checkInterSection(L02_02 l, L02_02 k) {
		
		//need to check if the last element of both are same if not then no intersection
		
		N02_02 l_last = l.head;
		int l_size = 1;
		
		while(l_last.next !=null) {
			l_size++;
			l_last = l_last.next;
		}
		
		//System.out.println("L size: " + l_size);
		//System.out.println("L last: " + l_last.data);
		
		N02_02 k_last = k.head;
		int k_size = 1;
		
		while(k_last.next !=null) {
			k_size++;
			k_last = k_last.next;
		}
		
		//System.out.println("k size: " + k_size);
		//System.out.println("k last: " + k_last.data);
		
		if(l_last != k_last) {
			System.out.println("No intersection");
			return;
		}
		
		
		int j;
		N02_02 jthNode;
		L02_02 longer;
		L02_02 shorter;
		if(k_size > l_size) {
			//System.out.println("k is longer advancing");
			longer = k;
			shorter = l;
			j = k_size - l_size;
		} else {
			//System.out.println("l is longer advancing");
			longer = l;
			shorter = k;
			j = l_size - k_size;
		}
		
		jthNode = findJthNode(longer.head, j);
		
		//iterating longer from jth node and shorter from the begining
		N02_02 intersectNode = null;
		N02_02 tmp = shorter.head;
		while(jthNode!=null) {
			if(jthNode == tmp) {
				intersectNode = jthNode;
				break;
			}
			jthNode = jthNode.next;
			tmp = tmp.next;
		}
		if(intersectNode!=null) {
			System.out.println("intersectNode: " + intersectNode.data);
		}
		
		
		
	}

	private static N02_02 findJthNode(N02_02 head, int j) {
		
		N02_02 jthNode  = head;
		int count = 0;
		while(count < j && jthNode!=null) {
			jthNode = jthNode.next;
			count++;
		}
		return jthNode;
	}

}

class L02_02 {
	N02_02 head;
	static class N02_02 {
		int data;
		N02_02 next;
		
		N02_02(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N02_02 n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public void append(int data) {
		N02_02 n = new N02_02(data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		N02_02 tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		
		tmp.next = n;
	}
}




