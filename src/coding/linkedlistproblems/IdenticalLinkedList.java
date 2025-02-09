package coding.linkedlistproblems;

import coding.linkedlistproblems.L29_1.N29_1;

public class IdenticalLinkedList {

	public static void main(String[] args) {

		L29_1 l1 = new L29_1();
		L29_1 l2 = new L29_1();
		l1.append(1);
		l1.append(3);
		l1.append(2);
		l1.append(4);
		l1.append(6);
		l1.append(8);
		l1.append(8);

		l2.append(1);
		l2.append(3);
		l2.append(2);
		l2.append(4);
		l2.append(6);
		l2.append(8);

		System.out.print("First list: ");
		l1.print();
		System.out.println();
		System.out.print("Second list: ");
		l2.print();
		System.out.println();
		System.out.println("Iterative approach: " + areIdenticalIterative(l1, l2));
		System.out.println("Recursive approach: " + areIdenticalRecursive(l1.head, l2.head));

	}

	public static boolean areIdenticalIterative(L29_1 l1, L29_1 l2) {

		if (l1 == null && l2 == null) {
			return true;
		}

		N29_1 tmp1 = l1.head;
		N29_1 tmp2 = l2.head;
		while (tmp1 != null && tmp2 != null) {

			if (tmp1.data != tmp2.data) {
				return false;
			}
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;

		}

		return tmp1 == null && tmp2 == null;

	}

	public static boolean areIdenticalRecursive(N29_1 n1, N29_1 n2) {

		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 != null && n2 != null) {
			return (n1.data == n2.data) && areIdenticalRecursive(n1.next, n2.next);
		}

		return false;
	}
}

class L29_1 {

	N29_1 head;

	static class N29_1 {
		int data;
		N29_1 next;

		N29_1(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("empty list");
			return;
		}

		N29_1 tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}

	public void append(int data) {

		N29_1 n = new N29_1(data);
		if (head == null) {
			head = n;
			return;
		}

		N29_1 tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = n;
	}
}
