package coding.linkedlistproblems;

public class PartitionByK {

	public static void main(String[] args) {
		L02_2 l = new L02_2();
		
		l.append(70);
		l.append(90);
		l.append(10);
		l.append(20);
		l.append(60);
		l.append(80);
		l.append(30);
		l.append(40);
		l.append(50);
		l.append(100);
		l.print();
		System.out.println();
		l.partitionBeyondK(45);
		System.out.println();
		l.print();
	}

}

class L02_2 {
	N02_2 head;
	static class N02_2 {
		int data;
		N02_2 next;
		
		N02_2(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N02_2 n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public void append(int data) {
		N02_2 n = new N02_2(data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		N02_2 tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		
		tmp.next = n;
	}
	
	public void push(int data) {
		N02_2 n = new N02_2(data);
		if(head == null) {
			head = n;
			return;
		}
		
		n.next = head;
		head = n;
	}
	
	public void partitionBeyondK(int k) {
		
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N02_2 prev = head;
		N02_2 curr = head.next;
		
		while(curr!=null) {
			
			N02_2 next = curr.next;
			if(curr.data < k) {
				prev.next = next;
				curr.next = head;
				head = curr;
				
			} else  {
				prev = curr;
			}
			curr = next;
		}
		
		
	}
}
