package coding.linkedlistproblems;

public class DeleteAlternate {

	public static void main(String[] args) {

		L28_1 l = new L28_1();

		l.append(1);
		l.append(3);
		l.append(2);
		l.append(4);
		l.append(6);
		l.append(8);
		l.append(10);
		l.append(11);
		l.append(12);

		System.out.print("before: ");
		l.print();
		System.out.println();
		System.out.print("after: ");
		l.deleteAlternate();
		l.print();

	}
}

class L28_1 {
	N28_1 head;

	class N28_1 {
		int data;
		N28_1 next;

		public N28_1(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("Empty");
		}
		N28_1 tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}

	public void append(int data) {
		N28_1 n = new N28_1(data);
		if (head == null) {
			head = n;
			return;
		}

		N28_1 tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = n;
	}

	public void deleteAlternate() {

		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		N28_1 curr = head;
		while (curr != null && curr.next != null) {
			curr.next = curr.next.next;
			curr = curr.next;
		}
		

	}

}
