package learn.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main( String[] args ) {
        BinaryTree12 tree = new BinaryTree12();
        tree.root = new Node12(1);
        tree.root.left = new Node12(22);
        tree.root.right = new Node12(42);
        tree.root.left.left = new Node12(53);
        tree.root.left.right = new Node12(64);
        tree.root.right.left = new Node12(47);
        tree.root.right.right = new Node12(35);

        System.out.print(tree.root.val + " ");
        System.out.print(tree.root.left.val+ " ");
        System.out.print(tree.root.right.val+ " ");
        System.out.print(tree.root.left.left.val+ " ");
        System.out.print(tree.root.left.right.val+ " ");
        System.out.print(tree.root.right.left.val+ " ");
        System.out.print(tree.root.right.right.val+ " ");
        System.out.println();

        tree.invertTreeRecursion(tree.root);

        System.out.print(tree.root.val + " ");
        System.out.print(tree.root.left.val+ " ");
        System.out.print(tree.root.right.val+ " ");
        System.out.print(tree.root.left.left.val+ " ");
        System.out.print(tree.root.left.right.val+ " ");
        System.out.print(tree.root.right.left.val+ " ");
        System.out.print(tree.root.right.right.val+ " ");
        System.out.println();

        tree.invertTreeIterative(tree.root);

        System.out.print(tree.root.val + " ");
        System.out.print(tree.root.left.val+ " ");
        System.out.print(tree.root.right.val+ " ");
        System.out.print(tree.root.left.left.val+ " ");
        System.out.print(tree.root.left.right.val+ " ");
        System.out.print(tree.root.right.left.val+ " ");
        System.out.print(tree.root.right.right.val+ " ");


    }
}

class BinaryTree12 {
    Node12 root;

    public Node12 invertTreeRecursion(Node12 root) {
        if(root == null) return null;
        Node12 tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);
        return root;
    }

    public void invertTreeIterative( Node12 root ) {
        if(root == null) return;
        Queue<Node12> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0) {
            Node12 currNode = queue.remove();
            Node12 temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;
            if(currNode.left != null) queue.add(currNode.left);
            if(currNode.right != null) queue.add(currNode.right);
        }

    }
}

class Node12 {
    int val;
    Node12 left, right;
    public Node12( int val ) {
        this.val = val;
    }
}
