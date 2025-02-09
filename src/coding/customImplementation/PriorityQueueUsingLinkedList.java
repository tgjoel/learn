package coding.customImplementation;

public class PriorityQueueUsingLinkedList {

	public static void main(String[] args) {

		Pq pq1 = new Pq();
		pq1.enQueue(1, 1);
		pq1.enQueue(2, 4);
		pq1.enQueue(4, 2);
		pq1.enQueue(5, 2);
		System.out.println(pq1.deQueue());
		System.out.println(pq1.deQueue());
		System.out.println(pq1.deQueue());
		System.out.println(pq1.deQueue());
		System.out.println(pq1.deQueue());
		
	}

}

class Pq {
	Npq head;

	class Npq {
		int data;
		int priority;
		Npq next;

		Npq(int data, int priority) {
			this.data = data;
			this.priority = priority;
			this.next = null;
		}
	}

	public void enQueue(int d, int p) {

		Npq n = new Npq(d, p);

		if (head == null) {
			head = n;
			return;
		}

		if (head.priority < n.priority) {
			n.next = head;
			head = n;
			return;
		}

		Npq tmp = head;

		while (tmp.next != null && tmp.next.priority > n.priority) {
			tmp = tmp.next;
		}

		n.next = tmp.next;
		tmp.next = n;

	}
	
	public int deQueue() {
		if(head == null) {
			return Integer.MIN_VALUE;
		}
		
		Npq tmp = head;
		head = head.next;
		return tmp.data;
	}
	
	public int peek() {
		if(head == null) {
			return Integer.MIN_VALUE;
		}
		return head.data;
	}

}
