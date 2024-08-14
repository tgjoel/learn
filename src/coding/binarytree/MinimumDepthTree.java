package learn.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthTree {
    public static void main( String[] args ) {
        Node8 n2 = new Node8(2);
        n2.right = new Node8(3);
        n2.right.right = new Node8(4);
        n2.right.right.right = new Node8(5);
        n2.right.right.right.right = new Node8(6);
        BinaryTree8 tree = new BinaryTree8();
        System.out.println("Minimum Depth Tree of Binary Tree recursive: " + tree.minDepthRecursive(n2));
        System.out.println("Minimum Depth Tree of Binary Tree iterative: " + tree.minDepthIterative(n2));
    }
}

class BinaryTree8 {
    Node8 root;

    public int minDepthIterative(Node8 node) {
        if (node == null) return 0;
        int depth = 1;
        Queue<Node8> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level > 0) {
                level--;
                Node8 currNode = queue.remove();
                if (currNode.left == null && currNode.right == null) {
                    return depth;
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepthRecursive(Node8 node) {
        if (node == null) return 0;
        int leftDepth = minDepthRecursive(node.left);
        int rightDepth = minDepthRecursive(node.right);

        // One approach
//        if(leftDepth == 0) {
//            return 1 + rightDepth;
//        } else if (rightDepth == 0) {
//            return 1 + leftDepth;
//        } else {
//            return Math.min(rightDepth, leftDepth);
//        }

        if (leftDepth == 0 || rightDepth == 0)
            return 1 + leftDepth + rightDepth;
        else
            return 1 + Math.min(leftDepth, rightDepth);
    }
}

class Node8 {
    int val;
    Node8 left, right;
    public Node8( int val ) {
        this.val = val;
    }
}
