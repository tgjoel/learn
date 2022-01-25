package coding.binarytree;

/*
  https://youtu.be/4fiDs7CCxkc

 * Given a binary tree, find size of largest binary search subtree in this
 * binary tree.
 *
 * Traverse tree in post order fashion. Left and right nodes return 4 piece
 * of information to root which isBST, size of max BST, min and max in those
 * subtree.
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size +
 * right size + 1 and new min will be min of left side and new max will be max of
 * right side.
 */
public class LargestBSTinBT {

    public static void main(String[] args) {
        BT0820 tree = new BT0820();
        tree.root = new Node0820(50);
        tree.root.left = new Node0820(30);
        tree.root.right = new Node0820(60);
        tree.root.left.left = new Node0820(5);
        tree.root.left.right = new Node0820(20);
        tree.root.right.left = new Node0820(45);
        tree.root.right.right = new Node0820(70);
        tree.root.right.right.left = new Node0820(65);
        tree.root.right.right.right = new Node0820(80);
        System.out.println("Size of largest BST is " + tree.largestBST(tree.root));
    }
}


class BT0820 {
    Node0820 root;

    public int largestBST(Node0820 root) {
        Params p = largest(root);
        return p.size;
    }

    private Params largest(Node0820 root) {

        if(root == null) {
            return new Params();
        }

        Params leftParam = largest(root.left);
        Params rightParam = largest(root.right);
        Params param = new Params();

        // if either of the left or right is not bst then root is not bst. Also the root should be greater than the
        // max of left side and should be less than min of the right side.
        // Note: max is initialized as Integer.MIN() and min as Integer.MAX();
        if(!leftParam.isBst || !rightParam.isBst || !(root.data > leftParam.max && root.data < rightParam.min)) {
            param.isBst = false;
            param.size = Math.max(leftParam.size, rightParam.size);
            return param;
        }

        // current root is a bst. setting it as bst.
        // the new size will be the left size + right size + 1 for the root
        param.isBst = true;
        param.size = 1 + leftParam.size + rightParam.size;

        //if the left node is present then its min will be the new min or setting it as the root nodes min
        param.min = root.left !=null ? leftParam.min : root.data;
        param.max = root.right !=null ? rightParam.max : root.data;
        return param;
    }

}


class Node0820 {
    int data;
    Node0820 right;
    Node0820 left;
    Node0820(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Params {
    boolean isBst;
    int size;
    int max;
    int min;
    Params() {
        isBst = true;
        size = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
}
