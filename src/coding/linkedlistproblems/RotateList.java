package coding.linkedlistproblems;

//LC 61. Rotate List
public class RotateList {
    public static void main( String[] args ) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        //   head = rotateRight(head, 2);
        head = rotateRight1(head, 2);

        System.out.println(head);

    }

    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tmp = head;
        int length = 1;  //loop counts nodes starting from the second node. As the first node is already considered.
        while(tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        tmp.next = head; // making the linked list to circular

        //Rotation logic
        k = length - (k % length);

        while (k-- > 0) {
            tmp = tmp.next;
        }
        head = tmp.next;
        tmp.next = null;
        return head;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        ListNode first = head;
        ListNode secondLast = null;
        ListNode last = null;
        ListNode tmp = head;

        for (int i = 0; i < k; i++) {

            while(tmp.next != null && tmp.next.next != null) {
                tmp = tmp.next;  // found the seconds last of the node
            }

            secondLast = tmp;
            last = secondLast.next;

            //rotating
            last.next = first;
            secondLast.next = null;
            first = last;
            tmp = first;
        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode( int val ) {
            this.val = val;
        }

        ListNode( int val, ListNode next ) {
            this.val = val;
            this.next = next;
        }
    }
}
