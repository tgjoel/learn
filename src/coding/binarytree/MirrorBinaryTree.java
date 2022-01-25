package coding.binarytree;

public class MirrorBinaryTree {
    public static void main(String[] args) {
        BT09091 tree = new BT09091();
        tree.root = new N09091(1);
        tree.root.left = new N09091(2);
        tree.root.right = new N09091(3);
        tree.root.left.left = new N09091(4);
        tree.root.left.right = new N09091(5);
        System.out.println("Before: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.println("After Traversal: ");
        tree.mirrorBinaryTree(tree.root);
        tree.inOrderTraversal(tree.root);

    }
}

class N09091 {
    int data;
    N09091 left;
    N09091 right;

    public N09091(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BT09091 {
    N09091 root;

    public void inOrderTraversal(N09091 root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public void mirrorBinaryTree(N09091 root) {
        this.mirror(root);
    }

    private N09091 mirror(N09091 root) {
        if(root == null) {
            return null;
        }

        N09091 left = mirror(root.left);
        N09091 right = mirror(root.right);

        root.left = right;
        root.right = left;
        return root;
    }


}
