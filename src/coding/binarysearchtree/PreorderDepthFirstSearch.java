package learn.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class PreorderDepthFirstSearch {

    public static void main( String[] args ) {
        BST5 bst5 = new BST5();
        bst5.insert(47);
        bst5.insert(21);
        bst5.insert(76);
        bst5.insert(18);
        bst5.insert(27);
        bst5.insert(52);
        bst5.insert(82);

        System.out.println(bst5.preOrderTraversal());
    }
}

class BST5 {

    Node5 root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node5 insert(Node5 currNode, int value) {
        if(currNode == null) return new Node5(value);
        else if (currNode.value == value) {
            return currNode;
        } else if (value < currNode.value) {
            currNode.left = insert(currNode.left, value);
        } else {
            currNode.right = insert(currNode.right, value);
        }
        return currNode;
    }

    // root -- left -- right
     public List<Integer> preOrderTraversal() {
        List<Integer> list = new ArrayList<>();
         preOrderTraversal(root, list);
         return list;
    }
    private void preOrderTraversal(Node5 currNode, List<Integer> list) {
        if(currNode == null) return;

        list.add(currNode.value);
        preOrderTraversal(currNode.left, list);
        preOrderTraversal(currNode.right, list);
    }

}



class Node5 {
    int value;
    Node5 left;
    Node5 right;

    Node5(int value) {
        this.value = value;
    }
}