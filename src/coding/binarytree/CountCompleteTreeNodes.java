package coding.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        BinaryTreeNode11 tree = new BinaryTreeNode11();
        tree.root = new Node11(1);
        tree.root.left = new Node11(2);
        tree.root.right = new Node11(3);
        tree.root.left.left = new Node11(4);
        tree.root.left.right = new Node11(5);
        tree.root.right.left = new Node11(6);
       // tree.root.right.right = new Node11(7);
        System.out.println(tree.countNodesRecursive(tree.root));
        tree.countNodesRecursive1(tree.root);
        System.out.println(tree.count);
    }
}

class BinaryTreeNode11 {
    Node11 root;

    int count =0;
    // Preorder traversal
    public void countNodesRecursive1(Node11 root) {
        if (root == null) return;
         count++;
         countNodesRecursive1(root.left);
         countNodesRecursive1(root.right);
    }
    //post order traversal
    public int countNodesRecursive(Node11 root) {
        if (root == null) return 0;
        int leftCount = countNodesRecursive(root.left);
        int rightCount = countNodesRecursive(root.right);
        return leftCount + rightCount + 1;
    }

    public int countNodesIterative(Node11 root) {
        if (root == null) return 0;
        Queue<Node11> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;;
        while (!queue.isEmpty()) {
            Node11 node = queue.remove();
            count++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return count;
    }
}

class Node11 {
    int val;
    Node11 left, right;
    public Node11(int val) {
        this.val = val;
    }
}
