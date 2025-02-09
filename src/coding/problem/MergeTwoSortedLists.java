package coding.problem;

public class MergeTwoSortedLists {

    public static void main( String[] args ) {
        ListNode list1 = null;
                //new ListNode(1);
        //list1.next = new ListNode(2);
       /// list1.next.next = new ListNode(4);
       // list1.next.next.next = new ListNode(7);

        ListNode list2 = new ListNode(0);
        //list2.next = new ListNode(3);
        //list2.next.next = new ListNode(4);

        ListNode ansList =  mergeTwoLists(list1, list2);
        while (ansList !=null) {
            System.out.println(ansList.val);
            ansList = ansList.next;
        }
    }


    // Solution 1 with recursion
    public ListNode mergeTwoListsWithRecursion(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ansList = null;
        ListNode ansHead = null;
        while(list1 !=null && list2 != null) {
            ListNode temp = new ListNode();
            if(list1.val < list2.val) {
                temp.val = list1.val;
                list1= list1.next;
            } else {
                temp.val = list2.val;
                list2 = list2.next;
            }
            if(ansList == null) {
                ansList = temp;
                ansHead = ansList;
            } else {
                ansList.next = temp;
                ansList = ansList.next;
            }
        }

        if(list1 != null) {
            if(ansList == null) {
                ansHead = list1;
            } else {
                ansList.next = list1;
            }
        } else {
            if(ansList == null) {
                ansHead = list2;
            } else {
                ansList.next = list2;
            }
        }
        return ansHead;
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