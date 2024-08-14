package learn.binarysearchtree;

public class TreeDelete {

    public static void main( String[] args ) {
        BST3 bst3 = new BST3();

        bst3.insert(2);
        bst3.insert(1);
        bst3.insert(3);

        System.out.println("Root: "+ bst3.root.value);
        System.out.println("Root left: "+ bst3.root.left.value);
        System.out.println("Root right: "+bst3.root.right.value);

        bst3.delete(2);

        System.out.println("Root: "+ bst3.root.value);
        System.out.println("Root left: "+ bst3.root.left.value);
        System.out.println("Root right: "+bst3.root.right);

    }
}

class Node3 {
    int value;
    Node3 left;
    Node3 right;
    Node3(int value) {
        this.value = value;
    }
}

class BST3 {
    Node3 root;

    public void insert(int value) {
        root = this.insert(root, value);
    }
    private Node3 insert(Node3 currNode, int value) {
        if(currNode == null) {
            return new Node3(value);
        }
        if(value < currNode.value) {
            currNode.left = insert(currNode.left,value);
        } else {
            currNode.right = insert(currNode.right,value);
        }
        return currNode;
    }

    public void delete(int value) {
        delete(root, value);
    }
    private Node3 delete(Node3 currNode, int value) {
        if(currNode == null) return null;
        if(value < currNode.value) {
            currNode.left = delete(currNode.left,value);
        } else if (value > currNode.value) {
            currNode.right = delete(currNode.right,value);
        } else {
            if(currNode.left == null && currNode.right == null) {
                currNode = null;
            } else if(currNode.left == null) {
                currNode = currNode.right;
            } else if(currNode.right == null) {
                currNode = currNode.left;
            } else {
                //get the minimum on the right subtree of the Delete Node and assign min value to the DeleteNode's value. Delete the repeated subtree node.
                int subtreeMin = getMinimum(currNode.right);
                currNode.value = subtreeMin;
                currNode.right = delete(currNode.right, subtreeMin); // call the recursive method to delete the duplicate.
            }
        }
        return currNode;
    }

    private int getMinimum( Node3 currNode ) {
        // The minimum of the tree will be always on the left
        while (currNode.left!=null) {
            currNode = currNode.left;
        }
        return currNode.value;
    }


}
