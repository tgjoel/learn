package learn.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {

    }
}

class BinaryTreeNode11 {
    Node11 root;

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
