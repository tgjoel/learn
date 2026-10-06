package coding.recursion;


public class HeightOfBinaryTree01 {
    static void main() {

    }
    public int heightOfBinaryTee(Node1 root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfBinaryTee(root.left),  heightOfBinaryTee(root.right));
    }

    static class Node1 {
        int val;
        Node1 left;
        Node1 right;
    }
}
