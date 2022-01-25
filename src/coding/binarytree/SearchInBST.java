package coding.binarytree;

public class SearchInBST {
    public static void main(String[] args) {
        N2508_2 root = new N2508_2(10);
        root.left = new N2508_2(-5);
        root.left.left = new N2508_2(-10);
        root.left.right = new N2508_2(5);
        root.right = new N2508_2(25);
        root.right.right = new N2508_2(36);
        new BT2508_2().searchElement(root, 5);
        new BT2508_2().searchElement(root, 50);
    }
}

class N2508_2 {
    int data;
    N2508_2 left;
    N2508_2 right;

    public N2508_2(int data) {
        this.data = data;
        this.left = right = null;
    }
}

class BT2508_2 {
    N2508_2 root;

    public void searchElement(N2508_2 root, int element) {
        N2508_2 node = search(root, element);
        if (node != null) {
            System.out.println("Element found in BST");
        } else {
            System.out.println("Element not present in BST");
        }
    }

    private N2508_2 search(N2508_2 root, int element) {
        if (root == null) {
            return null;
        }
        if (root.data == element) {
            return root;
        }
        if (root.data > element) {
            //since its BST and the root is > than the element, then the element lies in the left side of the bst
            return search(root.left, element);
        } else {
            return search(root.right, element);
        }
    }
}
