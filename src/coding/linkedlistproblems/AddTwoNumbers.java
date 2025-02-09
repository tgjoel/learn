package coding.linkedlistproblems;

//LC: 2. Add Two Numbers
public class AddTwoNumbers {

    public static void main( String[] args ) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode l3 = addTwoNumbers(l1,l2);
        ListNode l4 = addTwoNumbersRecursion(l1,l2);
        System.out.println(l3);
    }

    private static ListNode addTwoNumbersRecursion( ListNode l1, ListNode l2 ) {

            return addTwoNumbersRecursion(l1, l2, 0 );

    }

    private static ListNode addTwoNumbersRecursion( ListNode l1, ListNode l2, int carry ) {
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        int val1 = l1 != null ? l1.val : 0;
        int val2 = l2 != null ? l2.val : 0;
        int sum = val1 + val2 + carry;
        carry = sum / 10;
        sum = sum % 10;
        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        ListNode newNode = new ListNode(sum);
        newNode.next = addTwoNumbersRecursion(l1, l2, carry);
        return newNode;
    }

    public static ListNode addTwoNumbers( ListNode l1, ListNode l2 ) {
        ListNode tmpHead = new ListNode(0); // will create a dummy node as head and this will be removed
        ListNode tail = tmpHead;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            //adding the sum number to the tail
            tail.next = new ListNode(sum);
            tail = tail.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // for the last carry that needs to be added
        if (carry == 1) {
            tail.next = new ListNode(carry);
        }
        // setting the result head to the next node of the tmpHead as the first node was dummy
        ListNode result = tmpHead.next;
        tmpHead.next = null; // remove the dummy node from the actual result
        return result;
    }



    public static void append(ListNode head, int val) {
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
    }


    static class ListNode {
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
