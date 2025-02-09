package coding.linkedlistproblems;

public class MergeTwoSortedLinkedList {
//https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
    public static void main(String[] args) {
        //       llist1: 5->10->15,
        //       llist2: 2->3->20->40->50

        L1907 llist1 = new L1907();
        llist1.add(5);
        llist1.add(10);
        llist1.add(15);
        L1907 llist2 = new L1907();
        llist2.add(2);
        llist2.add(3);
        llist2.add(20);
        llist2.add(40);
        llist2.add(50);

        L1907 newList = new L1907();
        newList.head = mergeSortedList(llist1.head, llist2.head);
        newList.print(newList.head);
    }

    public static N1907 mergeSortedList(N1907 headA, N1907 headB) {

        N1907 dummyHead = new N1907(0); // creating a dummy head for the new list node
        N1907 tail = dummyHead; // tail node to create the next node
        while (true) {

            if(headA == null) {
                tail.next = headB;  // if the LL-A is completely iterated, then rest of the  LL-B will be set to the new LL
                break;
            }
            if(headB == null) {
                tail.next = headA; // if the LL-B is completely iterated, then rest of the  LL-A will be set to the new LL
                break;
            }
            if(headA.data < headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next; // setting the tail to the next node as new node is inserted
        }
        return dummyHead.next; // this will be the head of the new LL;
    }
}



class L1907 {

    N1907 head;
    public void add(int data) {
        N1907 newNode = new N1907(data);
        if(head == null) {
            head =newNode;
            return;
        }

        N1907 tmp = head;
        while (tmp.next !=null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public void print(N1907 headNode) {
        if (headNode == null) {
            System.out.println("Empty linkedList");
        }

        N1907 tmp = headNode;
        while (tmp!=null) {
            System.out.print(" " + tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }
}



class N1907 {
    int data;
    N1907 next;

    public N1907(int data) {
        this.data = data;
        this.next = null;
    }
}
