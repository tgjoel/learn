package coding.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main( String[] args ) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        System.out.println(isPalindrome1(listNode));
    }

    public  static boolean isPalindrome1(ListNode head) {
        if(head==null||head.next==null) return true;
        int[] arr =  new int[100000];
        int size = 0;
        while(head!=null){
            arr[size++]=head.val;
            head=head.next;
        }
        int m = size/2;
        for (int i = 0 ; i< m;i++){
            if(arr[i]!=arr[--size]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        List<Integer> ansList = new ArrayList<>();
        convertListToArray(head,ansList);

        for (int i = 0, j = ansList.size()-1; i < ansList.size()/2; i++, j--) {
            if(ansList.get(i)!=ansList.get(j)) {
                isPalindrome = false;
                break;
            }
        }

//        while (i < ansList.size()/2) {
//            if(head.val != ansList.get(i)) {
//                isPalindrome = false;
//                break;
//            }
//            i++;
//            head =head.next;
//        }
        return isPalindrome;
    }

    public static void convertListToArray( ListNode head, List<Integer> ansList ) {
       if(head == null) return;
       ansList.add(head.val);
       convertListToArray(head.next, ansList);
       //  ansList.add(head.val); list would be reversed
    }
}
