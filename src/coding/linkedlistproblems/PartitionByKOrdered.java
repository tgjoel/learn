package coding.linkedlistproblems;

public class PartitionByKOrdered {

	public static void main(String[] args) {
		L02_21 l = new L02_21();
		
		l.append(35);
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
		l.head = l.partition(45);
		System.out.println();
		l.print();
	}

}

class L02_21 {
	N02_21 head;
	static class N02_21 {
		int data;
		N02_21 next;
		
		N02_21(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("empty list");
			return;
		}
		
		N02_21 n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public void append(int data) {
		N02_21 n = new N02_21(data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		N02_21 tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		
		tmp.next = n;
	}
	
	public void push(int data) {
		N02_21 n = new N02_21(data);
		if(head == null) {
			head = n;
			return;
		}
		
		n.next = head;
		head = n;
	}
	
	public N02_21 partition(int k) {
		if(head == null) {
			System.out.println("empty list");
			return null;
		}

        //Creating dummyHead for before and after
		N02_21 beforeHead = new N02_21(0);
		N02_21 afterHead = new N02_21(0);

        //Creating the iterator nodes for before and after
        N02_21 currBefore  = beforeHead;
        N02_21 currAfter  = afterHead;

        N02_21 curr = head;
		while(curr!=null) {

			if(curr.data < k) {
                currBefore.next = curr;
                currBefore = currBefore.next;
			} else  {
                currAfter.next = curr;
                currAfter = currAfter.next;
			}
			curr = curr.next;
		}

        currAfter.next = null;// removes the cycle
        currBefore.next = afterHead.next; // next is needed to remove the dummy initial value of 0

       return beforeHead.next;// next is needed to remove the dummy initial value of 0
	}
}
