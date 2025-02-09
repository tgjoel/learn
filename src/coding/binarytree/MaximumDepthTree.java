package learn.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthTree {
    public static void main( String[] args ) {
        Node7 n2 = new Node7(10);
        n2.left = new Node7(20);
        n2.right = null;
        n2.left.left = null;
        n2.left.right = new Node7(30);
        BinaryTree7 tree = new BinaryTree7();;
        System.out.println("Max depth iterative: "+tree.maxDepthIterative(n2));
        System.out.println("Max depth recursion: "+tree.maxDepthRecursion(n2));
    }
}
class BinaryTree7 {
    Node7 root;

    public  int maxDepthIterative(Node7 root) {
        if (root == null) return 0;
        Queue<Node7> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Node7 currNode = queue.remove();
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepthRecursion( Node7 n2 ) {
        if (n2 == null) return 0;
        int leftDepth = maxDepthRecursion(n2.left);
        int rightDepth = maxDepthRecursion(n2.right);
        return 1 + Math.max(leftDepth, rightDepth); // 1 needs to be added for the root node
    }
}

class Node7 {
    int val;
    Node7 left, right;
    public Node7( int val ) {
        this.val = val;
    }
}
