package coding.binarytree;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
        Node2508 root = new Node2508(15);
        root.left = new Node2508(10);
        root.right = new Node2508(20);
        root.left.left = new Node2508(8);
        root.left.right = new Node2508(12);
        root.right.left = new Node2508(16);
        root.right.right = new Node2508(25);
        new BT2508().size(root);
    }
}

class Node2508 {
    int data;
    Node2508 right;
    Node2508 left;
    public Node2508(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BT2508 {
    Node2508 root;
    public BT2508() {
        this.root = null;
    }

    public void size(Node2508 root) {
        int size = getSize(root);
        System.out.println("Size of the BST: " + size);
    }

    private int getSize(Node2508 root) {
        if(root == null) {
            return 0;
        }
        int leftSize = getSize(root.left);
        int rightSize = getSize(root.right);
        return 1+ leftSize + rightSize;
    }
}
