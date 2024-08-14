package learn.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstSearch {

    public static void main( String[] args ) {
        BST4 bst4 = new BST4();
        bst4.insert(47);
        bst4.insert(21);
        bst4.insert(76);
        bst4.insert(18);
        bst4.insert(27);
        bst4.insert(52);
        bst4.insert(82);

        System.out.println( bst4.bfs());
    }



}

class Node4 {
    int value;
    Node4 left;
    Node4 right;
    Node4(int value) {
        this.value = value;
    }
}

class BST4 {
    Node4 root;

    public void insert(int value) {
        root = insert(root, value);
    }
    private Node4 insert(Node4 curNode, int value) {
        if(curNode == null) return new Node4(value);
        if(value== curNode.value) return curNode;
        if(value < curNode.value) {
            curNode.left = insert(curNode.left, value);
        } else {
            curNode.right = insert(curNode.right, value);
        }
        return curNode;
    }

    public List<Integer> bfs() {

        List<Integer> answerList = new ArrayList<>();
        Queue<Node4> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node4 currNode = queue.remove();
            answerList.add(currNode.value);
            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        return  answerList;
    }
}
