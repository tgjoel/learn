package coding.linkedlistproblems;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		
		L02_1 l = new L02_1();
		
		l.append(10);
		l.append(20);
		l.append(30);
		l.append(40);
		l.append(50);
		l.append(60);
		l.append(70);
		l.append(80);
		l.append(90);
		//l.append(100);
		
		l.print();
		System.out.println();
		l.deleteMiddleNode();
		l.print();
		
	}
}

class L02_1 {
	N02_1 head;
	static class N02_1 {
		int data;
		N02_1 next;
		
		N02_1(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N02_1 n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public void append(int data) {
		N02_1 n = new N02_1(data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		N02_1 tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		
		tmp.next = n;
	}
	
	public void deleteMiddleNode() {
		if(head ==null) {
			System.out.println("empty list");
			return;
		}
		
		N02_1 fast = head;
		N02_1 slow = head;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//slow will be the middle node
		//deleting the middle node
		//setting the next nodes value to this and deleting the next node
		slow.data = slow.next.data;
		slow.next = slow.next.next;
	}
}
