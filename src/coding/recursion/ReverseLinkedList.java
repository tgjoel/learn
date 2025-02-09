package coding.recursion;

public class ReverseLinkedList {
    public static void main( String[] args ) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
      //  listNode.next.next.next = new ListNode(4);
        ListNode newHead = reverseList(listNode);
        System.out.println("New list");
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null|| head.next == null) {
            return head;
        }
        //reducing the input
        ListNode temp = head;
        head = head.next;
        ListNode newHead = reverseList(head);
        head.next = temp;
        temp.next = null;
        return newHead;
    }

}

