package coding.binarytree;

import java.util.ArrayList;
import java.util.List;

public class SearchInBT {
    public static void main(String[] args) {
        N2508_3 root = new N2508_3(0);
        root.left = new N2508_3(1);
        root.left.left = new N2508_3(3);
        root.left.left.left = new N2508_3(7);
        root.left.right = new N2508_3(4);
        root.left.right.left = new N2508_3(8);
        root.left.right.right = new N2508_3(9);
        root.right = new N2508_3(2);
        root.right.left = new N2508_3(5);
        root.right.right = new N2508_3(6);
        new BT2508_3().searchElement(root, 8);
    }
}

class N2508_3 {
    int data;
    N2508_3 left;
    N2508_3 right;

    public N2508_3(int data) {
        this.data = data;
        this.left = right = null;
    }
}

class BT2508_3 {
    public void searchElement(N2508_3 root, int element) {
        List<Integer> arr = new ArrayList<>();
        N2508_3 elem = search(root, element, arr);
        if (elem != null) {
            System.out.println("Found");
            System.out.println(arr);
        } else {
            System.out.println("Not found");
        }
    }

    private N2508_3 search(N2508_3 root, int element, List<Integer> arr) {
        if (root == null) {
            return null;
        }
        if (root.data == element) {
            arr.add(root.data);
            return root;
        }

        N2508_3 left = search(root.left, element, arr);
        if (left != null) {
            arr.add(root.data);
            return left;
        }
        N2508_3 right = search(root.right, element, arr);
        if (right != null) {
            arr.add(root.data);
            return right;
        }
        return null;
    }
}
