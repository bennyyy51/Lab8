   
   ben's methods:
   
       public void print(Node root) {

        System.out.println(root);
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
