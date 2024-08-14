package learn.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    public static void main( String[] args ) {
        BinaryTreeNode13 tree = new BinaryTreeNode13();
        tree.root = new Node13(1);
        tree.root.left = new Node13(25);
        tree.root.right = new Node13(92);
        tree.root.left.left = new Node13(83);
        tree.root.left.right = new Node13(744);
        tree.root.right.left = new Node13(465);
        tree.root.right.right = new Node13(378);
        List<String> treePaths = tree.binaryTreePathsIterative(tree.root);
        System.out.println("Paths in Binary Tree Path Iterative: ");
        treePaths.forEach(System.out::println);
    }
}

class BinaryTreeNode13 {
    Node13 root;

    public List<String> binaryTreePathsRecursive( Node13 root ) {
        List<String> paths = new ArrayList<>();
        binaryTreePathsRecursive(root, "", paths);
        return paths;
    }
    private void binaryTreePathsRecursive( Node13 root, String path, List<String> paths ) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            paths.add(path+root.val);
        }
        if(root.left != null) {
            binaryTreePathsRecursive(root.left, path + "->"+ root.val, paths);
        }
        if(root.right != null) {
            binaryTreePathsRecursive(root.right, path + "->"+ root.val, paths);
        }
    }

    public List<String> binaryTreePathsIterative( Node13 root ) {
        List<String> paths = new ArrayList<>();
        Queue<Node13> queue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();;
        queue.add(root);
        pathQueue.add(root.val+"");
        while(!queue.isEmpty()) {
            Node13 currNode = queue.remove();
            String currPath = pathQueue.remove();
            if(currNode.left == null && currNode.right == null) {
                paths.add(currPath);
            }
            if(currNode.left != null) {
                queue.add(currNode.left);
                pathQueue.add(currPath + "->"+ currNode.left.val);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
                pathQueue.add(currPath + "->" + currNode.right.val);
            }
        }
        return paths;
    }
}

class Node13 {
    int val;
    Node13 left, right;

    public Node13( int val ) {
        this.val = val;
    }
}
