package problem;

public class LinkedListCycle {
    public static void main( String[] args ) {
        ListNode1 node1 = new ListNode1(3);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(0);
        ListNode1 node4 = new ListNode1(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
       // node4.next = node2;
        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle( ListNode1 head ) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode1 fast = head.next;
        ListNode1 slow = head;

        while (fast != null && fast.next!=null) {
            if(fast == slow) {
                return true;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }

        }
        return false;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1( int x ) {
        val = x;
        next = null;
    }
}
