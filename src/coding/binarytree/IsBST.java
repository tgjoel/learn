package coding.binarytree;

public class IsBST {
}

class N2008_1 {
    int data;
    N2008_1 right;
    N2008_1 left;

    N2008_1(int data) {
        this.data = data;
        right = null;
        left = null;
    }
}

class BT2008_1 {
    N2008_1 root;

    public boolean isBst(N2008_1 root) {
        return this.isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(N2008_1 root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.data <= minValue || root.data > maxValue) {
            return false;
        }
        return isBst(root.left, minValue, root.data) && isBst(root.right, root.data, maxValue);
    }
}