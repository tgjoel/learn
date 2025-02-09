package coding.linkedlistproblems;

public class SplitAlternateLinkedList {

	public static void main(String[] args) {

		
		L29 l = new L29();

		l.append(1);
		l.append(3);
		l.append(2);
		l.append(4);
		l.append(6);
		l.append(8);
		l.append(10);
		l.append(11);
		l.append(12);
		l.append(13);

		System.out.print("Actual list: ");
		l.print();
		System.out.println();
		L29 l1 = new L29();
		L29 l2 = new L29();
		l.split(l1, l2);
		System.out.print("First list: ");
		l1.print();
		System.out.println();
		System.out.print("Second list: ");
		l2.print();
	}

}

class L29 {
	N29 head;

	static class N29 {
		int data;
		N29 next;

		public N29(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head ==null) {
			System.out.println("Empty list");
			return;
		}
		
		N29 tmp = head;
		while(tmp!=null) {
			System.out.print(tmp.data+ " ");
			tmp = tmp.next;
		}
	}
	
	public void append(int data) {
		N29 n = new N29(data);
		if(head ==null) {
			head = n;
			return;
		}
		
		N29 tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		tmp.next = n;
	}
	
	public void split(L29 l1, L29 l2) {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N29 tmp = head;
		
		int count = 1;
		while(tmp!=null) {
			if(count%2 == 1) {
				l1.append(tmp.data);
			} else {
				l2.append(tmp.data);
			}
			count++;
			tmp = tmp.next;
		}
	}
	
	
}