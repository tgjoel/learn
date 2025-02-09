package coding.binarytree;

import java.util.ArrayList;
import java.util.List;

// Given a binary tree and a sum, find if there is a path from root to leaf which sums to this sum.
//https://www.youtube.com/watch?v=Jg4E4KZstFE
public class SumToRootLeafNodeBT {
    public static void main(String[] args) {
        N2508_1 root = new N2508_1(10);
        root.left = new N2508_1(16);
        root.right = new N2508_1(5);
        root.left.left = new N2508_1(-3);
        root.right.left = new N2508_1(6);
        root.right.right = new N2508_1(11);
        new BT2508_1().findSum(root, 26);
    }
}

class N2508_1 {
    N2508_1 right;
    N2508_1 left;
    int data;

    public N2508_1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BT2508_1 {
    N2508_1 root;

    public void findSum(N2508_1 root, int sum) {
        List<Integer> result = new ArrayList<>();
        this.findSumRootToLeaf(root, sum, result);
        System.out.println(result);
    }
    private boolean findSumRootToLeaf(N2508_1 root, int sum, List<Integer> result) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            //then its a leaf node. if its a leaf node then its sum should be equals the sum.
            if (root.data == sum) {
                result.add(root.data);
                return true;
            } else {
                //if its a leaf node and still if the root.data is not equal to sum then retuning false
                return false;
            }
        }

        //for non leaf nodes we need to subtract the data from the sum
        if (findSumRootToLeaf(root.left, sum - root.data, result)) {
            result.add(root.data);
            return true;
        }
        if (findSumRootToLeaf(root.right, sum - root.data, result)) {
            result.add(root.data);
            return true;
        }
        return false;
    }

}
