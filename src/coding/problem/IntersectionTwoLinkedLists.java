package problem;


//https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/

public class IntersectionTwoLinkedLists {
    public static void main( String[] args ) {
        ListNode2 node1 = new ListNode2(4);
        ListNode2 node2 = new ListNode2(1);
        ListNode2 node3 = new ListNode2(8);
        ListNode2 node4 = new ListNode2(4);
        ListNode2 node5 = new ListNode2(5);

        ListNode2 node6 = new ListNode2(5);
        ListNode2 node7 = new ListNode2(6);
        ListNode2 node8 = new ListNode2(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        ListNode2 ans = getIntersectionNode(node1, node6);
        System.out.println(ans.val);
        ListNode2 ans1 = getIntersectionNodeWithoutLength(node1, node6);
        System.out.println(ans1.val);

    }

    public static ListNode2 getIntersectionNodeWithoutLength( ListNode2 headA, ListNode2 headB ) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode2 a = headA;
        ListNode2 b = headB;

        while (a!=b) {  // comes out of loop when a==b. if no intersection then both will be null

            if(a==null) {  // when a becomes null, move a to start of B: A+B = B +A
                a= headB;
            } else {
                a = a.next; // else move to next
            }
            if(b==null) {
                b= headA;
            } else {
                b = b.next;
            }
        }
        return a;

    }

    public static ListNode2 getIntersectionNode1( ListNode2 headA, ListNode2 headB ) {
        if (headA == null || headB == null) {
            return null;
        }
        int aLength = 0;
        int bLength = 0;

        ListNode2 atemp = headA;
        while (atemp != null) {
            aLength++;
            atemp = atemp.next;
        }
        ListNode2 btemp = headB;
        while (btemp != null) {
            bLength++;
            btemp = btemp.next;
        }
        while (aLength > bLength) {
            headA = headA.next;
            aLength--;
        }
        while (bLength > aLength) {
            headB = headB.next;
            bLength--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static ListNode2 getIntersectionNode( ListNode2 headA, ListNode2 headB ) {
        if (headA == null || headB == null) {
            return null;
        }
        int aLength = 0;
        int bLength = 0;

        ListNode2 atemp = headA;
        while (atemp != null) {
            aLength++;
            atemp = atemp.next;
        }
        ListNode2 btemp = headB;
        while (btemp != null) {
            bLength++;
            btemp = btemp.next;
        }

        boolean alarge = false;
        int dif = 0;
        if (aLength > bLength) {
            alarge = true;
            dif = aLength - bLength;
        } else {
            dif = bLength - aLength;
        }
        atemp = headA;
        btemp = headB;

        int i = 0;
        if (alarge) {
            while (i < dif) {
                atemp = atemp.next;
                i++;
            }
        } else {
            while (i < dif) {
                btemp = btemp.next;
                i++;
            }
        }

        ListNode2 interSec = null;

        while (btemp!=null && atemp!=null) {
            if(btemp == atemp) {
                interSec = atemp;
                break;
            } else {
                atemp = atemp.next;
                btemp = btemp.next;
            }
        }
        return interSec;

    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2( int x ) {
        val = x;
        next = null;
    }
}