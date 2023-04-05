
public class AVLTree {

   static Node root = null;

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

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }

    }

    public int getBalance(Node n) {
        int temp;
        if (n != null) {
            temp = 1 + getBalance(n.right) - getBalance(n.left);
            n.balance = temp;
            return temp;
        }
        return 0;
    }

    public void print(Node root) {

        System.out.println(root.data);
        if (root.left != null) {
            print(root.left);
        }
        if (root.right != null) {
            print(root.right);
        }
    }


    public Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = add(node.left, data);
        }

        else if (data > node.data) {
            node.right = add(node.right, data);
        }

        else {
            return node;
        }

        node.height = 1 + getHeight(node);

        int balance = getBalance(node);
        
        if (node.left != null && node.right != null && node.left.right != null && node.right.left != null) {

            if (balance > 1 && data < node.left.data) {
                return rotateR(node);
            }
            
            if (balance < -1 && data > node.right.data) {
                return rotateL(node);
            }
            
            if (balance > 1 && data > node.left.data) {
                node.left = rotateL(node.left);
                return rotateR(node);
            }
            
            if (balance < -1 && data < node.right.data) {
                node.right = rotateR(node.right);
                return rotateL(node);
            }
        }
        
        return node;
        
    }

    public Node rotateR(Node node) {
        Node nodeL = node.left;
        Node nodeLR = nodeL.right;
        
        nodeL.right = node;
        node.left = nodeLR;
        
        nodeL.height = getHeight(nodeL);
        node.height = getHeight(node);
        
        return nodeL;

    }

    public Node rotateL(Node node) {
        
        Node nodeR = node.right;
        Node nodeRL = nodeR.left;
        
        nodeR.left = node;
        node.right = nodeRL;
        
        node.height = getHeight(node);
        nodeR.height = getHeight(nodeR);
        
        return nodeR;

    }
    
public static void main(String[] args) {
        
        // testing code for AVLTree
        
        // Right rotation
        AVLTree.Node node = new AVLTree(root).new Node(12);
        AVLTree tree = new AVLTree(node);
        tree.add(tree.root, 15);
        tree.add(tree.root, 11);
        tree.add(tree.root, 7);
        tree.add(tree.root, 4);
        System.out.println("\ntree.print after R rotation:");
        tree.print(tree.root);
        
        //Left rotation
        tree = new AVLTree(node);
        tree.add(tree.root, 11);
        tree.add(tree.root, 15);
        tree.add(tree.root, 17);
        tree.add(tree.root, 25);
        System.out.println("\ntree.print after L rotation:");
        tree.print(tree.root);

        //Right-left rotation
        tree = new AVLTree(node);
        tree.add(tree.root, 11);
        tree.add(tree.root, 13);
        tree.add(tree.root, 17);
        tree.add(tree.root, 25);
        tree.add(tree.root, 16);
        tree.add(tree.root, 14);
        tree.add(tree.root, 15);
        System.out.println("\ntree.print after R-L rotation:");
        tree.print(tree.root);
        
        //Left-right rotation
        tree = new AVLTree(node);
        tree.add(tree.root, 20);
        tree.add(tree.root, 13);
        tree.add(tree.root, 9);
        tree.add(tree.root, 8);
        tree.add(tree.root, 10);
        tree.add(tree.root, 12);
        tree.add(tree.root, 11);
        System.out.println("\ntree.print after L-R rotation:");
        tree.print(tree.root);

    }

}