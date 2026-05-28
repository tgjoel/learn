package coding.linkedlistproblems;

// LeetCode 328 – Odd Even Linked List
public class OddEvenLinkedList1 {

  public static void main(String[] args) {
	  
	 L281 l = new L281();
	  
	  l.append(1);
	  l.append(7);
	  l.append(2);
	  l.append(4);

	  l.append(6);
	  l.append(8);
	  l.append(10);
	  l.append(3);
	  l.append(11);
	  //l.insertBeg(20);
	  
	  System.out.print("before: ");
	  l.print();
	  System.out.println();
	  System.out.print("after: ");
      l.oddEvenList();
	  l.print();
  }
}

class L281 {

  N28 head;
  static class N28 {
    int data;
    N28 next;

    public N28(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void print() {
    if(head == null) {
      System.out.println("Empty");
    }
    N28 tmp = head;
    while(tmp !=null) {
      System.out.print(tmp.data + " ");
      tmp = tmp.next;
    }
  }

  public void append(int data) {
    N28 n = new N28(data);
    if(head ==null) {
      head = n;
      return;
    }

    N28 tmp = head;
    while(tmp.next!=null) {
      tmp = tmp.next;
    }
    tmp.next = n;
  }
  
  public void insertBeg(int data) {
	  
	  N28 n = new N28(data);
	  
	  if(head == null) {
		  head = n;
		  return;
	  }
	  
	  n.next = head;
	  head = n;
  }
  
  public void oddEvenList() {
	  
	  if(head == null) {
		  System.out.println("Empty");
	  }
	  
	  N28 odd = head;
	  N28 even = head.next;
	  N28 evenHead = even;

	  
	  while(even !=null && even.next!=null) {
          odd.next = even.next;
          odd = even.next;

          even.next = odd.next;
          even = odd.next;
	  }
      odd.next = evenHead;
  }
}
