package ds.tree.avl;

public class AVLTree {

	private Node root;

	public void insert(int data) {
		root = insert(data, root);
	}

	private Node insert(int data, Node parent) {
		if (parent == null) {
			parent = new Node(data);
		} else if (data < parent.getData()) {
			parent.leftChild = insert(data, parent.leftChild);
			if(getHeight(parent.leftChild) - getHeight(parent.rightChild) == 2){
				if(data < parent.leftChild.getData()){
					parent = rotateRight(parent);
				}else{
					parent = doubleRotateWithLeftChild(parent);
				}
			}
		} else if (data > parent.getData()) {
			parent.rightChild = insert(data, parent.rightChild);
			if(getHeight(parent.rightChild) - getHeight(parent.leftChild) == 2){
				if(data > parent.rightChild.getData()){
					parent = rotateLeft(parent);
				}else{
					parent = doubleRotateWithRightChild(parent);
				}
			}
		}
		return parent;
	}
	
	private Node doubleRotateWithLeftChild(Node z) {
		Node y = z.leftChild;
		z.leftChild = rotateLeft(y);
		return rotateRight(z);
	}
	
	private Node doubleRotateWithRightChild(Node z) {
		Node y = z.rightChild;
		z.rightChild = rotateRight(y);
		return rotateLeft(z);
	}

	/*
	 * rotate right with left child so that y becomes the root for x and z.
	 */
	private Node rotateRight(Node z) {
		Node y = z.leftChild;
		z.leftChild = y.rightChild;
		y.rightChild = z;
		return y;
	}
	
	private Node rotateLeft(Node z) {
		Node y = z.rightChild;
		z.rightChild = y.leftChild;
		y.leftChild = z;
		return y;
	}

	public int getHeight(){
		return getHeight(root);
	}

	private int getHeight(Node node){
		if(node == null){
			return 0;
		}else{
			return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
		}
	}

	public void inorder() {
		System.out.println("Root :"+root.getData()+"\n");
		inorder(root);
	}

	private void inorder(Node node) {
		if (node != null) {
			inorder(node.leftChild);
			System.out.print(node.getData() + "\t");
			inorder(node.rightChild);
		}
	}

	public boolean find(int data) {
		boolean isFound = false;
		Node dataNode = root;
		while (dataNode != null) {
			if (data == dataNode.getData()) {
				isFound = true;
				break;
			} else if (data < dataNode.getData()) {
				dataNode = dataNode.leftChild;
			} else {
				dataNode = dataNode.rightChild;
			}
		}
		return isFound;
	}

}
