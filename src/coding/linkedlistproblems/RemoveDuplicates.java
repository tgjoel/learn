package coding.linkedlistproblems;

public class RemoveDuplicates {

	public static void main(String[] args) {
		L01 l1 = new L01();
		
		l1.addBeg(10);
		l1.addBeg(20);
		l1.addBeg(30);
		l1.addBeg(10);
		l1.addBeg(40);
		l1.addBeg(10);
		l1.addBeg(30);
		l1.addBeg(320);
		l1.addBeg(320);
		l1.addBeg(40);
		l1.print();
		l1.deleteDuplicates();
		System.out.println();
		l1.print();
	}
}

class L01 {
	
	N01 head;
	static class N01 {
		N01 next;
		int data;
		N01(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N01 tmp = head;
		
		while(tmp!=null) {
			System.out.print(tmp.data+  " ");
			tmp = tmp.next;
		}
	}
	
	public void addBeg(int data) {
		N01 n = new N01(data);
		 if(head == null) {
			 head = n;
			 return;
		 }
		 
		 n.next = head;
		 head = n;	
	}
	
	public void deleteDuplicates() {
		if(head ==null) {
			System.out.println("empty list");
		}
		
		N01 tmp = head;
		
		while(tmp!=null) {
			N01 prev = tmp;
			N01 curr = tmp.next;
			
			while(curr !=null) {
				N01 next = curr.next;
				if(tmp.data == curr.data) {
					prev.next = curr.next;
				}
				prev = curr;
				curr = next;
			}
			tmp = tmp.next;
		}
		
	}
}
