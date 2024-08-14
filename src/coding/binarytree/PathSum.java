package learn.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    public static void main( String[] args ) {
        Node9 root = new Node9(10);
        root.left = new Node9(8);
        root.right = new Node9(2);
        root.left.left = new Node9(3);
        root.left.right = new Node9(5);
        root.right.left = new Node9(2);

        int targetSum = 23;
        BinaryTree9 tree = new BinaryTree9();
        System.out.println("Path Sum recursive: " + tree.pathSumRecursive(root, targetSum));
        System.out.println("Path Sum iterative: " + tree.pathSumIterative(root, targetSum));
    }
}

class BinaryTree9 {
    Node9 root;

    public boolean pathSumRecursive(Node9 node, int targetSum) {
        if (node == null) return false;
        if(node.left == null && node.right == null && targetSum == node.val) {
            return true;
        }
        boolean left = pathSumRecursive(node.left, targetSum - node.val);
        boolean right = pathSumRecursive(node.right, targetSum - node.val);
        return left || right;
    }

    public boolean pathSumIterative(Node9 node, int targetSum) {
        if(node == null) return false;
        Queue<Node9> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(node);
        sumQueue.add(node.val);
        while (!nodeQueue.isEmpty()) {
            Node9 currNode = nodeQueue.remove();
            int sum = sumQueue.remove();
            if (currNode.left == null && currNode.right == null && sum == targetSum) {
                return true;
            }
            if (currNode.left != null) {
                nodeQueue.add(currNode.left);
                sumQueue.add(sum + currNode.left.val);
            }
            if (currNode.right != null) {
                nodeQueue.add(currNode.right);
                sumQueue.add(sum + currNode.right.val);
                }
        }
        return false;
    }
}

class Node9 {
    int val;
    Node9 left;
    Node9 right;
    public Node9( int val ) {
        this.val = val;
    }
}
