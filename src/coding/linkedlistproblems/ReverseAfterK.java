package coding.linkedlistproblems;

//https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/?ref=lbp
public class ReverseAfterK {

    public static void main(String[] args) {

        L1 l1 = new L1();
        l1.append(10);
        l1.append(20);
        l1.append(30);
        l1.append(40);
        l1.append(50);
        l1.append(60);
        l1.append(70);
        l1.append(80);
        l1.append(90);
        l1.append(100);
        l1.print();
        System.out.println();
        l1.reverse(5);
        l1.print();

    }

}

class L1 {

    N1 head;

    static class N1 {
        int data;
        N1 next;

        N1(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void print() {
        if (head == null) {
            return;
        }

        N1 n = head;

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public void append(int data) {

        N1 n = new N1(data);
        if (head == null) {
            head = n;
            return;
        }

        N1 tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = n;
    }

//    public void reverse(int k) {
//
//        if (head == null) {
//            System.out.println("empty list");
//            return;
//        }
//
//        head = reverse(head, k);
//    }

    public void reverse( int k) {
        if (head == null) {
            return;
        }

        N1 curr = head;
        N1 next;
        N1 prev = null;
        while (curr != null && k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        head.next = curr;
//
//        if (curr != null) {
//            head.next = reverse(curr, k);
//        }
        this.head = prev;
    }
}

//after learning stack
//https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/?ref=lbp
