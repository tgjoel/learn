package problem;

public class RemoveDuplicatesSortedLinkedList {

    public static void main( String[] args ) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next.next = new ListNode(4);

        ListNode ans = deleteDuplicates(l);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    public static ListNode deleteDuplicates( ListNode head ) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l2 != null) {
            if (l1.val == l2.val) {
               l1.next = l2.next;
            } else {
                l1 = l1.next;
            }
            l2 = l2.next;
        }
        return head;
    }


}

class ListNode {
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