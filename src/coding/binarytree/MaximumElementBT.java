package learn.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumElementBT {
    public static void main( String[] args ) {
        BinaryTree1 binaryTree1 = new BinaryTree1();
        binaryTree1.root = new Node1(2);
        binaryTree1.root.left = new Node1(7);
        binaryTree1.root.right = new Node1(50);
        binaryTree1.root.left.right = new Node1(678);
        binaryTree1.root.left.right.left = new Node1(1);
        binaryTree1.root.left.right.right = new Node1(13);
        binaryTree1.root.right.right = new Node1(90);
        binaryTree1.root.right.right.left = new Node1(4);
        System.out.println("Maximum element recursion: " + binaryTree1.maximumElementRecursion(binaryTree1.root));
        System.out.println("Maximum element iterative: " + binaryTree1.maximumElementIterative(binaryTree1.root));
    }
}

class BinaryTree1 {
    Node1 root;

    public int maximumElementRecursion( Node1 currNode) {
        int max;
        if (currNode == null) {
            return -1;
        }
        int leftMax = maximumElementRecursion(currNode.left);
        int rightMax = maximumElementRecursion(currNode.right);
        max = Math.max(leftMax, rightMax);
        max = Math.max(max, currNode.data);
        return max;
    }

    public int maximumElementIterative( Node1 root ) {
        if(root == null) {
            return -1;
        }
        Queue<Node1> node1Queue = new LinkedList<>();
        node1Queue.add(root);
        int max = Integer.MIN_VALUE;
        while(!node1Queue.isEmpty()) {
            Node1 currNode = node1Queue.remove();
            if(currNode.data > max) max = currNode.data;
            if(currNode.left != null) {
                node1Queue.add(currNode.left);
            }
            if(currNode.right != null) {
                node1Queue.add(currNode.right);
            }
        }
        return max;
    }
}

class Node1 {
    int data;
    Node1 left;
    Node1 right;
    public Node1(int data) {
        this.data = data;
    }
}
