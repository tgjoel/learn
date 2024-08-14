package learn.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelProduct {
    public static void main( String[] args ) {
        Node3 root = new Node3(1);
        root.left = new Node3(2);
        root.right = new Node3(3);
        root.left.left = new Node3(4);
        root.left.right = new Node3(5);
        root.right.right = new Node3(8);
        root.right.right.left = new Node3(6);
        root.right.right.right =  new Node3(7);
        BinaryTree3 bt = new BinaryTree3();
        System.out.println("Max product iterative: "+bt.maxLevelProductIterative(root));
        System.out.println("Max product recursion: "+bt.maxLevelProductRecursive(root));
    }
}

class Node3 {
    int data;
    Node3 right, left;
    public Node3( int data ) {
        this.data = data;
    }
}

class BinaryTree3 {
    Node3 root;

    public int maxLevelProductIterative( Node3 root ) {
        if (root == null) return -1;
        int maxProduct = Integer.MIN_VALUE;
        Queue<Node3> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int product = 1;
            int queueSize = queue.size();
            while (queueSize > 0) {
                Node3 currNode = queue.remove();
                product *= currNode.data;
                queueSize--;
                if (null != currNode.left) {
                    queue.add(currNode.left);
                }
                if (null != currNode.right) {
                    queue.add(currNode.right);
                }
            }
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }

    public int maxLevelProductRecursive( Node3 root ) {

        Map<Integer, Integer> levelProductMap = new HashMap<>();
        maxLevelProductIterative(root, 0, levelProductMap);
        return levelProductMap.values().stream().max(Integer::compareTo).orElse(-1);

    }

    private void maxLevelProductIterative( Node3 root, int level, Map<Integer, Integer> levelProductMap ) {
        if (root == null) return;
        levelProductMap.put(level, levelProductMap.getOrDefault(level, 1) * root.data);
        maxLevelProductIterative(root.left, level + 1, levelProductMap);
        maxLevelProductIterative(root.right, level + 1, levelProductMap);
    }
}
