package coding.linkedlistproblems;

//25. Reverse Nodes in k-Group
public class ReverseNodesInKGroup {

	public static void main(String[] args) {

        L111 l1 = new L111();
		l1.append(1);
		l1.append(2);
		l1.append(3);
		l1.append(4);
		l1.append(5);
//		l1.append(6);
//		l1.append(7);
//		l1.append(8);
//		l1.append(9);
//		l1.append(10);
//		l1.append(11);
//		l1.append(12);
//		l1.append(13);
//		l1.append(14);
		l1.print();
		System.out.println();
		l1.head = l1.reverseKGroup(l1.head,2);
		l1.print();

	}
}

class L111 {
    Node111 head;

    static class Node111 {

        Node111 next;
        int data;

        Node111(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data) {

        Node111 n = new Node111(data);
        if (head == null) {
            head = n;
            return;
        }

        Node111 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = n;
    }

    public void print() {
        if (head == null) {
            System.out.println("empty");
        }

        Node111 tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }

    public Node111 reverseKGroup(Node111 head, int k) {
        // find the kth node

        Node111 kthNode = head;
        for (int i = 0; i < k; i++) {
            if (kthNode == null) { // not enough k nodes
                return head;
            }
            kthNode = kthNode.next;
        }

        int count = 0;
        Node111 curr = head;
        Node111 prev = null;
        Node111 next = null;
        // reverse the K nodes
        while (curr != null && count < k) {
            count++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (curr != null) {
            head.next = reverseKGroup(curr, k);
        }
        return prev;
    }
}
