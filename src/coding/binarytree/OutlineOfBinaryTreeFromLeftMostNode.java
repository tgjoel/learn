package coding.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutlineOfBinaryTreeFromLeftMostNode {

    /*
    Print the outline of the tree from the left most node

                                  1
                       2                     3
                 4          5           6          7
                   8      9           10         11

       expected output  starting from left most node  : 8 4 2 1 3 7 11
     */

    public static void main(String[] args) {
        N04071 root = new N04071(1);
        root.left = new N04071(2);
        root.right = new N04071(3);
        root.left.left = new N04071(4);
        root.left.right = new N04071(5);
        root.right.left = new N04071(6);
        root.right.right = new N04071(7);
        root.left.left.right = new N04071(8);
        root.left.right.left = new N04071(9);
        root.right.left.left = new N04071(10);
        root.right.right.left = new N04071(11);
        Tree tree = new Tree(root);
        tree.printOutlineFromLeftMostNode();
    }
}


class Tree {
    N04071 root;
    int currentLevel = 0;

    public Tree(N04071 root) {
        this.root = root;
    }

    public void printOutlineFromLeftMostNode() {
        List<Integer> list = new ArrayList<>();
        this.getLeftView(root.left, 1, list); // Get the left view of the left part of the tree
        Collections.reverse(list);  // we need the left most as the first
        list.add(root.data);        // adding the root data to the list as its being excluded in both the loops
        this.currentLevel = 0;  // need to reset the current level for the right view
        this.getRightView(root.right, 1, list); // Get the right view of the right part of the tree
        list.forEach(number -> System.out.print(number + " "));
    }

    private void getLeftView(N04071 root, int level, List<Integer> list) {

        if (root == null) {
            return;
        }
        if (level > currentLevel) {
            list.add(root.data);
            currentLevel = level;
        }
        this.getLeftView(root.left, level + 1, list);
        this.getLeftView(root.right, level + 1, list);
    }

    private void getRightView(N04071 root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level > currentLevel) {
            list.add(root.data);
            currentLevel = level;
        }
        this.getRightView(root.right, level + 1, list);
        this.getRightView(root.left, level + 1, list);
    }
}

class N04071 {
    int data;
    N04071 left;
    N04071 right;

    public N04071(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
