package learn.binarytree;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SumLeftLeaves {
    public static void main( String[] args ) {
    }
}


class BinaryTree14 {
    Node14 root = null;

    public int sumOfLeftLeavesRecursive(Node14 root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeavesRecursive(root.left);
        }
        sum += sumOfLeftLeavesRecursive(root.right);
        return sum;
    }

    public int sumOfLeftLeavesIterative(Node14 root) {
        if (root == null) return 0;
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int sum = 0;
        Queue<Node14> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node14 curNode = queue.remove();
            if (curNode.left != null) {
                queue.add(curNode.left);
                if(curNode.left.left == null && curNode.left.right == null) {
                    sum += curNode.left.val;
                }
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }

        }
        return sum;
    }

}
class Node14 {
    int val;
    Node14 left, right;
    public Node14(int val) {
        this.val = val;
    }
}
