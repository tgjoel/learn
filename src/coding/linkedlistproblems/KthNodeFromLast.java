package coding.linkedlistproblems;

public class KthNodeFromLast {

	public static void main(String[] args) {
			
		L02 l = new L02();
		
		l.append(10);
		l.append(20);
		l.append(30);
		l.append(40);
		l.append(50);
		l.append(60);
		l.append(70);
		l.append(80);
		l.append(90);
		l.append(100);
		
		l.print();
		System.out.println();
		l.kthNodeFromLast(5);
		l.kthNodeFromLast(2);
	}

}

class L02 {
	N02 head;
	static class N02 {
		int data;
		N02 next;
		
		N02(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N02 n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public void append(int data) {
		N02 n = new N02(data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		N02 tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		
		tmp.next = n;
	}
	
	public void kthNodeFromLast(int k) {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N02 slow = head;
		N02 fast = head;
		
		int count = 0;
		
		while(count < k && fast!=null) {
			fast = fast.next;
			count++;
		}
		
		if(fast == null) {
			System.out.println( k + " is greater than list");
			return;
		}
		
		while(fast!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println( k + "th node from last: " + slow.data);
	}
}
