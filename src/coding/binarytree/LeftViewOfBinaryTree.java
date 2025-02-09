package coding.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    /*
    Print the node when viewing from the left side.

                     1
                    2  3
                          4
                       5     6

       output : 1 2 4 5
     */

    public static void main(String[] args) {
        Node0704 root = new Node0704(1);
        root.left = new Node0704(2);
        root.right = new Node0704(3);
        root.right.right = new Node0704(4);
        root.right.right.left = new Node0704(5);
        root.right.right.right = new Node0704(6);

        //using recursion
        new LeftView().printLeftViewRecursive(root, 1);
        System.out.println();
        //using queue
        new LeftView().printLeftViewUsingQueue(root);
    }
}

class LeftView {
    int visitedLevel = 0;
    public void printLeftViewRecursive(Node0704 root, int level) {

        if(root == null) {
            return;
        }
        if(visitedLevel < level) {
            System.out.print(root.data + " ");
            visitedLevel = level;
        }

        printLeftViewRecursive(root.left, level + 1);
        printLeftViewRecursive(root.right, level + 1);
    }

    public void printLeftViewUsingQueue(Node0704 root) {

        if (root == null) {
            return;
        }
        Queue<Node0704> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int level = queue.size(); // queue size will be the no. of nodes at the each level of the queue

            //iterating through all the node of the current level and printing the left view
            for (int i = 1; i <= level ; i++) {
                Node0704 curr = queue.poll();
                if(i == 1) { // printing the first element of the level
                    System.out.print(curr.data + " ");
                }
                if(curr.left !=null) {
                    queue.add(curr.left);
                }
                if(curr.right !=null) {
                    queue.add(curr.right);
                }
            }
        }
    }
}

class Node0704 {
    int data;
    Node0704 left;
    Node0704 right;

    public Node0704(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
