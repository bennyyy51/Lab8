package lab8;

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


	
	public void print(Node root) {
		
		System.out.println(root);
		if (root.left != null) {
			print(root.left);
		}
		if (root.right != null) {
			print(root.right);
		}
	}
	
	public boolean add(Node node, int number, int data) {
		if (node == null) {
			return true;
		}
	
		if (data < node.data) {
			
		}
		
		else if (data > node.data) {
			
		}
			
		return false;
		
	}
	
	public void rotateR(Node node) {
		Node nodeL = node.left;
		Node nodeR = node.right;
		Node nodeT = node;
		
		node = nodeL;
		nodeR = nodeT;
		nodeL = nodeL.left;
		
		
	}
	
	public void rotateL(Node node) {
		Node nodeL = node.left;
		Node nodeR = node.right;
		Node nodeT = node;
		
		node = nodeR;
		nodeR = nodeT;
		nodeR = nodeL.left;
		
	}

}
