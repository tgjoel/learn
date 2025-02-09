package learn.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderDepthFirstSearch {

    public static void main( String[] args ) {

        BST6 bst6 = new BST6();

        bst6.insert(47);
        bst6.insert(21);
        bst6.insert(76);
        bst6.insert(18);
        bst6.insert(27);
        bst6.insert(52);
        bst6.insert(82);

        System.out.println(bst6.postOrder());

    }
}

class BST6 {
    Node6 root;

    public void insert(int value) {
        Node6 newNode = new Node6(value);
        if(root == null) {
            root = newNode;
            return;
        }
        Node6 tmp = root;
        while (true) {
            if(tmp.value == value) return;
            if(value < tmp.value) {
                if(tmp.left == null) {
                    tmp.left = newNode;
                    return;
                } else {
                    tmp = tmp.left;
                }
            }
            else {
                if(tmp.right == null) {
                    tmp.right = newNode;
                    return;
                } else {
                    tmp = tmp.right;
                }
            }
        }
    }

    public List<Integer> postOrder() {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder( Node6 currNode, List<Integer> list ) {
        if(currNode == null) return;
        postOrder(currNode.left, list);
        postOrder(currNode.right, list);
        list.add(currNode.value);
    }

}

class Node6 {
    int value;
    Node6 left;
    Node6 right;

    Node6 (int value) {
        this.value = value;
    }
}


