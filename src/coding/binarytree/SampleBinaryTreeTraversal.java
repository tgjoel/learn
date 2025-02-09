package coding.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SampleBinaryTreeTraversal {
	public static void main(String[] args) {
		BT1 tree = new BT1();
		tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);
        
        
        //Depth first traversal
        tree.preOderTraversal();
        System.out.println();
        tree.inOderTraversal();
        System.out.println();
        tree.postOderTraversal();
        System.out.println();
        //breadth first traversal
        tree.levelOrderTraversal();
	}

}
	class Node1 {
		int val;
		Node1 right, left;
		
		Node1(int val) {
			this.val = val;
			this.right = left = null;
		}
	}
	
	class BT1 {
		Node1 root;
		
		BT1() {
			root = null;
		}
		
		public void levelOrderTraversal() {
			
			Queue<Node1> queue = new LinkedList<>();
			queue.add(this.root);
			
			while(!queue.isEmpty()) {
				
				Node1 tmp = queue.remove();
				
				if(tmp.left !=null) {
					queue.add(tmp.left);
				}
				
				if(tmp.right!=null) {
					queue.add(tmp.right);
				}
				
				System.out.print(tmp.val + " ");
				
			}
		}

		void preOderTraversal() { 
			this.preOderTraversal(root);
		}
		
		void inOderTraversal() { 
			this.inOderTraversal(root);
		}
		
		void postOderTraversal() { 
			this.postOderTraversal(root);
		}
		 
		void preOderTraversal(Node1 n1) {
			
			if(n1 == null) {
				return;
			}
			
			System.out.print(n1.val + " ");
			preOderTraversal(n1.left);
			preOderTraversal(n1.right);
			
		}
		
		void inOderTraversal(Node1 n1) {
			
			if(n1 == null) {
				return;
			}
			
			inOderTraversal(n1.left);
			System.out.print(n1.val + " ");
			inOderTraversal(n1.right);
			
		}
		
		void postOderTraversal(Node1 n1) {
			
			if(n1 == null) {
				return;
			}
			
			inOderTraversal(n1.left);
			inOderTraversal(n1.right);
			System.out.print(n1.val + " ");
			
		}

}
