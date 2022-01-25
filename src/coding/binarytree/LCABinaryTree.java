package coding.binarytree;

public class LCABinaryTree {
    /*
                      3
                  6         8
              2      11         13
                   9     5   7

    */
    public static void main(String[] args) {

    }
}

class N0812_2 {
    int data;
    N0812_2 left;
    N0812_2 right;
    public N0812_2(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class B0812_2 {
    N0812_2 root;

    public N0812_2 lca(N0812_2 root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        if(root.data == n1 || root.data == n2) {
            return root;
        }

        N0812_2 left = lca(root.left, n1 ,n2);
        N0812_2 right = lca(root.right, n1, n2);

        if(left !=null && right !=null) {
            return root;
        }
        if(left == null && right == null) {
            return null;
        }
        return left !=null ? left: right;
    }
}
