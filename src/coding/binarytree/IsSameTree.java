package learn.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {

    public static void main( String[] args ) {
        Node4 n1 = new Node4(10);
        n1.left = new Node4(20);
        n1.right = new Node4(30);
       // n1.left.left = new Node4(84);
        //n1.left.right = new Node4(52);

        Node4 n2 = new Node4(10);
        n2.left = new Node4(20);
        n2.right = null;
        n2.left.left = null;
        n2.left.right = new Node4(30);

        BinaryTree4 bt4 = new BinaryTree4();
        System.out.println("Is same tree iterative: "+ bt4.isSameTreeIterative(n1,n2));
        System.out.println("Is same tree recursion: "+ bt4.isSameTreeRecursion(n1,n2));
    }
}

class BinaryTree4 {
    Node4 root;

    public boolean isSameTreeRecursion(Node4 n1, Node4 n2) {
        if(n1 == null && n2 == null) return true;
        if(n1== null || n2 == null || n1.val != n2.val) return false;
        boolean leftFlag = isSameTreeRecursion(n1.left, n2.left);
        boolean rightFlag = isSameTreeRecursion(n1.right, n2.right);
        return leftFlag && rightFlag;
        /*
        if(n1 != null && n2 !=null){
            if(n1.val != n2.val){
                return false;
            }
        }
        if(n1 == null && n2!= null){
            return false;
        }
        if(n1 != null && n2 == null){
            return false;
        }
        return recursion(n1.left,n2.left) && recursion(n1.right , n2.right);
         */

    }

    public boolean isSameTreeIterative(Node4 n1, Node4 n2) {

        if (n1 == null && n2 == null) return true;
        if (n1 != null && n2 == null) return false;
        if (n1 == null && n2 != null) return false;
        Queue<Node4> n1Q = new LinkedList<>();
        Queue<Node4> n2Q = new LinkedList<>();

        n1Q.add(n1);
        n2Q.add(n2);
        while (!n1Q.isEmpty() && !n2Q.isEmpty()) {
            Node4 currNodeN1 = n1Q.remove();
            Node4 currNodeN2 = n2Q.remove();

            // simpler approach
            if (currNodeN1 == null && currNodeN2 == null)
                continue;
            else if (currNodeN1 == null || currNodeN2 == null || currNodeN1.val != currNodeN2.val)
                return false;

            n1Q.add(currNodeN1.left);
            n1Q.add(currNodeN1.right);

            n2Q.add(currNodeN2.left);
            n2Q.add(currNodeN2.right);
        }
        return true;
    }

    // Detailed approach

//            if(currNodeN1.val != currNodeN2.val) {
//                return false;
//            }
//            if((currNodeN1.left == null && currNodeN2.left != null) ||
//                    (currNodeN1.left != null && currNodeN2.left == null)) {
//                return false;
//            }
//            if((currNodeN1.right == null && currNodeN2.right != null) ||
//                    (currNodeN1.right != null && currNodeN2.right == null)) {
//                return false;
//            }
//            if(currNodeN1.left != null) {
//                n1Q.add(currNodeN1.left);
//            }
//            if(currNodeN2.left!= null) {
//                n2Q.add(currNodeN2.left);
//            }
//            if(currNodeN1.right != null) {
//                n1Q.add(currNodeN1.right);
//            }
//            if(currNodeN2.right!= null) {
//                n2Q.add(currNodeN2.right);
//            }
//        }
//        return (n1Q.size() == n2Q.size());
//  }
}
class Node4 {
    int val;
    Node4 left, right;
    public Node4( int data ) {
        this.val = data;
    }
}
