package coding.linkedlistproblems;

public class OddEvenLinkedList {

  public static void main(String[] args) {
	  
	  L28 l = new L28();
	  
	  l.append(1);
	  l.append(3);
	  l.append(2);
	  l.append(4);
	  l.append(6);
	  l.append(8);
	  l.append(10);
	  l.append(9);
	  l.append(11);
	  //l.insertBeg(20);
	  
	  System.out.print("before: ");
	  l.print();
	  System.out.println();
	  System.out.print("after: ");
	 l.rearrangeOddEven();
	  l.print();
	  

  }
}

class L28 {

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
  
  public void rearrangeOddEven() {
	  
	  if(head == null) {
		  System.out.println("Empty");
	  }
	  
	  N28 curr = head.next;
	  N28 prev = head;
	
	  
	  while(curr!=null) {
		  N28 next = curr.next;
		  if(curr.data%2 != 0) {
			 prev.next = next;
			 curr.next = head;
			 head = curr;
		  } else {
			  prev = curr;
		  }
		  curr = next;
	  }
  }
}
