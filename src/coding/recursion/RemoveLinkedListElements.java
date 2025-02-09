package coding.recursion;

public class RemoveLinkedListElements {

    public static void main( String[] args ) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);
        //ListNode newHead = removeElements(listNode, 6);
        ListNode newHead1= removeElements1(listNode, 6);
        System.out.println("Removed list");
    }

    //more simplified
    public static ListNode removeElements1(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = removeElements(head, val);
        if(head.val == val) {  // kept here so will loop till the end of the list and then starts to check.
            // if it was kept above then it will check only for the first time and then its returned
            return head.next;
        }
        return temp;
    }


}
