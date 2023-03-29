public class AVLTree {
	
	Node root = null;
	
	class Node {
		
		int data;
		Node parent;
		Node left;
		Node right;
		int height;
		int balance;
	
		Node(int d, Node p) {
			data = d;
			parent = p;
			height = p.height + 1;
		}
		
		Node(int d) {
			data = d;
			height = 1;
		}
		
	}
	
	AVLTree(Node n) {
		
		root = n;
		
	}

}
