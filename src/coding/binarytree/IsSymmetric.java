package learn.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    public static void main( String[] args ) {
        BinaryTree6 tree = new BinaryTree6();
        tree.root = new Node6(1);
        tree.root.left = new Node6(2);
        tree.root.right = new Node6(2);
        tree.root.left.left = new Node6(3);
        tree.root.left.right = new Node6(4);
        tree.root.right.left = new Node6(4);
        tree.root.right.right = new Node6(3);
        if (tree.isSymmetricRecursive(tree.root))
            System.out.println("Symmetric by recursion");
        else
            System.out.println("Not symmetric by recursion");

        if (tree.isSymmetricIterative(tree.root))
            System.out.println("Symmetric by iterative");
        else
            System.out.println("Not symmetric by iterative");

    }
}
class BinaryTree6 {
    Node6 root;

    public boolean isSymmetricRecursive( Node6 root ) {
        return isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive( Node6 left, Node6 right ) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        boolean leftFlag = isSymmetricRecursive(left.left, right.right);
        boolean rightFlag = isSymmetricRecursive(left.right, right.left);
        return leftFlag && rightFlag;
    }

    public boolean isSymmetricIterative( Node6 root ) {
        if (root == null) return true;

        Queue<Node6> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            Node6 left = queue.remove();
            Node6 right = queue.remove();

            if (left == null && right == null) return true;
            if (left == null || right == null || left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}

class Node6 {
    int val;
    Node6 left, right;
    public Node6( int val ) {
        this.val = val;
    }
}