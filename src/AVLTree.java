public class AVLTree {
	
	Node root = null;
	
	class Node {
		
		int data;
		Node parent;
		Node left;
		Node right;
		int height;
		int balance;
		
	}
	
	AVLTree(Node n) {
		
		root = n;
		
	}

}
