package learn.binarysearchtree;

public class TreeMinimum {
    public static void main( String[] args ) {
        BST2 bst2 = new BST2();
        bst2.insert(47);
        bst2.insert(21);
        bst2.insert(76);
        bst2.insert(18);
        bst2.insert(27);
        bst2.insert(52);
        bst2.insert(82);

        System.out.println(bst2.minimum(bst2.root));
        System.out.println(bst2.minimum(bst2.root.right));
    }
}

class Node2 {
    int value;
    Node2 left;
    Node2 right;
    public Node2(int value) {
        this.value = value;
    }
}

class BST2 {
    Node2 root;

    public void insert(int value) {
        root = insert(root, value);
    }
    private Node2 insert(Node2 currNode, int value) {
        if(currNode == null) {
            return new Node2(value);
        } else if (currNode.value == value) {
            return currNode;
        } else if(value < currNode.value) {
            currNode.left = insert(currNode.left,value);
        } else {
            currNode.right = insert(currNode.right,value);
        }
        return currNode;
    }

    public int minimum(Node2 startNode) {
        if(startNode== null) return -1;
        while(startNode.left != null) {
            startNode = startNode.left;
        }
        return startNode.value;
    }
}