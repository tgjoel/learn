package coding.binarytree;

public class HeightOfBinaryTree {
   // https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
    public static void main(String[] args) {
        Node1807 root = new Node1807(15);
        root.left = new Node1807(10);
        root.right = new Node1807(20);
        root.left.left = new Node1807(8);
        root.left.right = new Node1807(12);
        root.right.left = new Node1807(16);
        root.right.right = new Node1807(25);
        System.out.print("The height of the binary tree is " + new BtHeight().heightOfBT(root));
    }
}

class BtHeight {
    public int heightOfBT(Node1807 node) {
        if(node == null) {
            return 0;
        }
        int lDepth = heightOfBT(node.left);
        int rDepth = heightOfBT(node.right);
        return  1 + Math.max(lDepth, rDepth);
    }
}

class Node1807 {
    int data;
    Node1807 left;
    Node1807 right;
    Node1807(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
