package coding.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeInsertion {
	public static void main(String[] args) {
		BT2 b = new BT2();
		b.insert(1);
		b.insert(4);
		b.insert(2);
		b.insert(5);
		b.insert(3);
		b.levelOrder();
	}
}

class Node2 {
	int val;
	Node2 right, left;
	Node2(int val) {
		this.val = val;
		this.right = null;
		this.left = null;
	}
}

 class BT2 {
	Node2 root;
	BT2() {
		this.root = null;
	}
	
	void insert(int val) {
	
		
		if(root == null) {
			root = new Node2(val);
			return;
		}
		
		// finding the null child nodes by level order traversal
		
		Queue<Node2> queue = new LinkedList<>();
		queue.add(root);
	
		
		while(!queue.isEmpty()) {
			
			Node2 temp= queue.remove();
			if(temp == null) {
				temp = new Node2(val);
				break;
			}
			
			if(temp.left == null) {
				temp.left = new Node2(val);
				break;
			} else {
				queue.add(temp.left);
			}
			
			if(temp.right == null) {
				temp.right = new Node2(val);
				break;
			} else {
				queue.add(temp.right);
			}
			
		}
	}
	
	void levelOrder() {
		Queue<Node2> queue = new LinkedList<>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			Node2 tmp = queue.remove();
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			if(tmp.right !=null) {
				queue.add(tmp.right);
			}
			System.out.print(tmp.val + " ");
		}
	}
}
