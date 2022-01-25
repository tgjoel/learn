package coding.binarytree;

public class LCABinarySearchTree {

    /*
    Print the Least common ancestor of the BST.

                         10
               -10                  30
                  8             24      60
              6         9           28       78


    LCA of : 28,78 --> 30
             6,9  ---> 8
             30, 78 ---> 30

            since its BST, lesser values will be on the left and greater values will be on the right of the root node.
             check if the root is greater or lesser than the given nodes, move to left or right accordingly. if root is lesser than one
             and greater than the other or equal then root is the least common ancestor
     */

    public static void main(String[] args) {
        BST_0812_1 bt = new BST_0812_1();
        bt.root = new N0812_1(10);
        bt.root.left = new N0812_1(-10);
        bt.root.left.right = new N0812_1(8);
        bt.root.left.right.left= new N0812_1(6);
        bt.root.left.right.right= new N0812_1(9);
        bt.root.right = new N0812_1(30);
        bt.root.right.left = new N0812_1(24);
        bt.root.right.right = new N0812_1(60);
        bt.root.right.right.right = new N0812_1(78);
        bt.root.right.left.right = new N0812_1(28);
        System.out.println("Iterative");
        bt.findLCAIterative(bt.root, 28, 78 );
        bt.findLCAIterative(bt.root, 6, 9 );
        bt.findLCAIterative(bt.root, 30, 78 );
        System.out.println("Recursion");
        N0812_1 ans1 =  bt.findLCARecursive(bt.root, 28, 78 );
        N0812_1 ans2 =  bt.findLCARecursive(bt.root, 6, 9 );
        N0812_1 ans3 =  bt.findLCARecursive(bt.root, 30, 78 );
        System.out.println("LCA: " + ans1.data);
        System.out.println("LCA: " + ans2.data);
        System.out.println("LCA: " + ans3.data);
    }
}

class N0812_1 {
    int data;
    N0812_1 left;
    N0812_1 right;
    public N0812_1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST_0812_1 {
    N0812_1 root;
    public BST_0812_1() {
        this.root = null;
    }

    public void findLCAIterative(N0812_1 root, int n1, int n2) {

        if(root == null) {
            return;
        }
        int ans = -1;
        while(root !=null) {
            if(root.data > n1 && root.data > n2) {
                // root is greater than both n1 and n2, then n1 and n2 is on the left side of the root
                root = root.left;
            } else if(root.data < Math.min(n1, n2)){
                // root is lesser than both n1 and n2, then n1 and n2 is on the right side of the root
                root = root.right;
            } else {
                ans =  root.data;
                break;
            }
        }
        System.out.println("LCA: " + ans);
    }

    public N0812_1 findLCARecursive(N0812_1 root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        if(root.data > n1 && root.data > n2) {
            // root is greater, going to the left side
            return findLCARecursive(root.left, n1, n2);
        } else if(root.data < n1 && root.data < n2) {
            return findLCARecursive(root.right, n1, n2);
        } else {
            return root;
        }
    }
}
