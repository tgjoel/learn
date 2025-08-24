package coding.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSum {
    public static void main( String[] args ) {
        Node22 root = new Node22(10);
        root.left = new Node22(20);
        root.right = new Node22(30);
        root.left.left = new Node22(84);
        root.left.right = new Node22(52);
        root.right.left = new Node22(97);
        root.right.right = new Node22(48);
        root.right.right.left = new Node22(64);
        root.right.right.right = new Node22(-7);
        root.right.left.left = new Node22(87);
        BinaryTree2 bt = new BinaryTree2();
        bt.root = root;
       System.out.println("Maximum Level Sum Iterative: "+ bt.maxLevelSumIterative(root));
       System.out.println("Maximum Level Sum Recursion: "+ bt.maxLevelSumRecursion(root));
    }
}

class BinaryTree2 {
    Node22 root;

    public int maxLevelSumIterative(Node22 node) {
        int max = Integer.MIN_VALUE;
        Queue<Node22> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            int result = 0;
            while(levelLength > 0) {
                Node22 currNode = queue.remove();
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


    public int maxLevelSumRecursion( Node22 root ) {
            Map<Integer, Integer> levelSumMap = new HashMap<>();
            calculateLevelSum(root, 0, levelSumMap);
            return levelSumMap.values().stream().max(Integer::compareTo).get();

    }

    private void calculateLevelSum(Node22 root, int level, Map<Integer, Integer> levelSumMap) {
        if(root == null)   return;
        levelSumMap.put(level, levelSumMap.getOrDefault(level,0) + root.data);
        calculateLevelSum(root.left, level+1, levelSumMap);
        calculateLevelSum(root.right, level+1, levelSumMap);
    }
}

class Node22 {
    int data;
    Node22 left, right;
    public Node22( int data ) {
        this.data = data;
    }
}

