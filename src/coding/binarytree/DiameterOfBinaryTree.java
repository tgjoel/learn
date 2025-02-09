package learn.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {
    public static void main( String[] args ) {

    }
}

class BinaryTree15 {
    Node15 root;

    //Need not be passing via the root. it can be the inner root as well
    int maxDia = 0;
    public int diameterOfBinaryTreeRecursive(Node15 root) {
        findDiameter(root);
        return maxDia;
    }
    public int findDiameter(Node15 root) {
        if(root == null) return 0;
        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);
        maxDia = Math.max(maxDia, leftDiameter + rightDiameter);
        return 1 + Math.max(leftDiameter, rightDiameter);
    }

//    public int diameterOfBinaryTreeIterative(Node15 root) {
//      //  TODO
//    }
}

class Node15 {
    int val;
    Node15 left, right;
    public Node15( int val ) {
        this.val = val;
    }
}