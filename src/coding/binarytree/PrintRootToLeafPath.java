package coding.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToLeafPath {
    public static void main(String[] args) {
        N08291 root = new N08291(1);
        root.left = new N08291(2);
        root.left.left = new N08291(4);
        root.left.right = new N08291(5);
        root.right = new N08291(3);
        root.right.left = new N08291(6);
        root.right.left.left = new N08291(8);
        root.right.right = new N08291(7);
        root.right.right.right = new N08291(9);
        BT08291 bt08291 = new BT08291();
        bt08291.printRootToLeft(root);
    }
}


class N08291 {
    int data;
    N08291 left;
    N08291 right;
    public N08291(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BT08291 {
    N08291 root;
    
    public void printRootToLeft(N08291 root) {
        List<Integer> list = new ArrayList<>();
        printFromRootToLeft(root, list);
    }

    private void printFromRootToLeft(N08291 root, List<Integer> list) {

        if(root == null) {
            return;
        }

        list.add(root.data); // adding the list

        if(root.left == null && root.right == null) {  // if the current node is the leaf node then printing the list
            System.out.println("Path: " + list);
        } else {
            printFromRootToLeft(root.left, list);  // iterating till the left and right node
            printFromRootToLeft(root.right, list);
        }
        list.remove(list.size()-1); // remove the current node is both the left and right tree are done.
    }
}
