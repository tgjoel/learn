package learn.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSum {
    public static void main( String[] args ) {
        Node2 root = new Node2(10);
        root.left = new Node2(20);
        root.right = new Node2(30);
        root.left.left = new Node2(84);
        root.left.right = new Node2(52);
        root.right.left = new Node2(97);
        root.right.right = new Node2(48);
        root.right.right.left = new Node2(64);
        root.right.right.right = new Node2(-7);
        root.right.left.left = new Node2(87);
        BinaryTree2 bt = new BinaryTree2();
        bt.root = root;
       System.out.println("Maximum Level Sum Iterative: "+ bt.maxLevelSumIterative(root));
       System.out.println("Maximum Level Sum Recursion: "+ bt.maxLevelSumRecursion(root));
    }
}

class BinaryTree2 {
    Node2 root;

    public int maxLevelSumIterative(Node2 node) {
        int max = Integer.MIN_VALUE;
        Queue<Node2> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            int result = 0;
            while(levelLength > 0) {
                Node2 currNode = queue.remove();
                result +=currNode.data;
                if(currNode.left!= null) {
                    queue.add(currNode.left);
                }
                if(currNode.right!= null) {
                    queue.add(currNode.right);
                }
                levelLength--;
            }
            max = Math.max(max, result);
        }
        return max;
    }


    public int maxLevelSumRecursion( Node2 root ) {
            Map<Integer, Integer> levelSumMap = new HashMap<>();
            calculateLevelSum(root, 0, levelSumMap);
            return levelSumMap.values().stream().max(Integer::compareTo).get();

    }

    private void calculateLevelSum(Node2 root, int level, Map<Integer, Integer> levelSumMap) {
        if(root == null)   return;
        levelSumMap.put(level, levelSumMap.getOrDefault(level,0) + root.data);
        calculateLevelSum(root.left, level+1, levelSumMap);
        calculateLevelSum(root.right, level+1, levelSumMap);
    }
}

class Node2 {
    int data;
    Node2 left, right;
    public Node2( int data ) {
        this.data = data;
    }
}

