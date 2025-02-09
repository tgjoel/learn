package learn.binarysearchtree;


public class TreeInsert {
    public static void main( String[] args ) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.iInsert(47);
        bst.iInsert(21);
        bst.iInsert(76);
        bst.iInsert(19);
        bst.iInsert(52);
        bst.iInsert(82);

        bst.iInsert(27);
        bst.iInsert(92);

        System.out.println(bst.root.left.right.value);
        System.out.println(bst.root.right.right.right.value);

        System.out.println("<<<<<<<<<<<<<<<  Recursive >>>>>>>>>>>>>>>>>>>");
        bst = new BinarySearchTree();
        bst.rInsert(47);
        bst.rInsert(21);
        bst.rInsert(76);
        bst.rInsert(19);
        bst.rInsert(52);
        bst.rInsert(82);
        bst.rInsert(76);
        bst.rInsert(27);
        bst.rInsert(92);

        System.out.println(bst.root.left.right.value);
        System.out.println(bst.root.right.right.right.value);
    }
}

class BinarySearchTree {
    public TNode1 root;

    public void rInsert( int value ) {
        root = rInsert(root, value);
    }

    private TNode1 rInsert( TNode1 currNode, int value ) {

        if (currNode == null) {
            return new TNode1(value);
        }
        if (currNode.value == value) {
            System.out.println("Cannot insert");
            return currNode;
        }
        if (value < currNode.value) {
            currNode.left = rInsert(currNode.left, value);
        } else {
            currNode.right = rInsert(currNode.right, value);
        }
        return currNode;
    }

    public void iInsert( int val ) {
        TNode1 newNode = new TNode1(val);
        if (root == null) {
            root = newNode;
            return;
        }
        TNode1 tmp = root;
        while (true) {
            if (newNode.value == tmp.value) {
                //cannot insert to the tree that has same value
                return;
            }
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

class TNode1 {
    int value;
    TNode1 left;
    TNode1 right;

    TNode1( int value ) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}