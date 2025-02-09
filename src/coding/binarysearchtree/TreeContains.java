package learn.binarysearchtree;

public class TreeContains {
    public static void main( String[] args ) {
        BinaryTreeB b = new BinaryTreeB();

        System.out.println("Tree contains null: "+ b.iContains(12));
        b.insert(47);
        b.insert(21);
        b.insert(76);
        b.insert(18);
        b.insert(27);
        b.insert(82);
        b.insert(52);

        //Iterative
        System.out.println("Tree contains 17: " + b.iContains(17));
        System.out.println("Tree contains 76: " + b.iContains(76));
        System.out.println("Tree contains 100: " + b.iContains(100));
        System.out.println("Tree contains 52: " + b.iContains(52));

        //Recursive
        System.out.println("Tree contains 52: " + b.rContains(52));
        System.out.println("Tree contains 802: " + b.rContains(802));
    }
}

class NodeB {
    int value;
    NodeB left;
    NodeB right;
    public NodeB(int value) {
        this.value = value;
    }
}

class BinaryTreeB {
    NodeB root;

    public boolean rContains( int value) {
        return rContains(root,value);
    }

    //Recursive contains
    private boolean rContains( NodeB currNode, int value) {

        if(currNode == null)
            return false;

        if(value == currNode.value)
            return true;

        if (value < currNode.value)
            return rContains(currNode.left,value);
        else
            return rContains(currNode.right,value);
    }

    //Iterative contains
    public boolean iContains( int value) {
        NodeB tmp = root;

        while(tmp!=null) {
            if(value < tmp.value) {
                tmp = tmp.left;
            } else if(value > tmp.value) {
                tmp = tmp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void insert(int value) {
        NodeB newNode = new NodeB(value);

        if(root == null) {
            root = newNode;
            return;
        }
        NodeB tmp = root;
        while(true) {
            if(newNode.value == tmp.value) {
                System.out.println("Cannot insert");
                return;
            }
            if(newNode.value < tmp.value) {
                if(tmp.left== null) {
                    tmp.left = newNode;
                    return;
                } else {
                    tmp = tmp.left;
                }
            } else {
                if(tmp.right == null) {
                    tmp.right = newNode;
                    return;
                } else {
                    tmp = tmp.right;
                }
            }
        }
    }
}