package learn.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class InOrderDepthFirstSearch {

    public static void main( String[] args ) {
        BST7 bst7 = new BST7();
        bst7.insert(47);
        bst7.insert(21);
        bst7.insert(76);
        bst7.insert(18);
        bst7.insert(27);
        bst7.insert(52);
        bst7.insert(82);
        System.out.println(bst7.inOrder());


    }
}


class BST7 {
    Node7 root;

    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }
    private void inOrder(Node7 currNode, List<Integer> list) {
        if(currNode == null) return;
        inOrder(currNode.left,list);
        list.add(currNode.value);
        inOrder(currNode.right,list);

    }

    public void insert(int value){
        Node7 newNode = new Node7(value);
        if(root == null) {
            root = newNode;
            return;
        }
        Node7 tmp = root;
        while(true) {
            if (newNode.value < tmp.value) {
                if (tmp.left == null) {
                    tmp.left = newNode;
                    return;
                } else {
                    tmp = tmp.left;
                }
            } else {
                if (tmp.right == null) {
                    tmp.right = newNode;
                    return;
                } else {
                    tmp = tmp.right;
                }
            }
        }
    }
}

class Node7 {
    int value;
    Node7 left;
    Node7 right;

    Node7(int value) {
        this.value = value;
    }
}
