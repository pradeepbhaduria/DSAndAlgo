package ds.tree.bst;

public class BST implements ITree {
	private Node root; // the only data field in Tree

	public void find(int data) {
		Node dataNode = new Node(data);
		Node parent = root;
		while (true) {
			if (dataNode.getData() < parent.getData()) {
				parent = parent.leftChild;
				continue;
			} else if (dataNode.getData() > parent.getData()) {
				parent = parent.rightChild;
				continue;
			} else if (dataNode.getData() == parent.getData()) {
				System.out.println("BST.find(Data Dound in tree)");
			} else {
				System.out.println("BST.find(Data Not available)");
			}
		}
	}

	public void insert(double data) {
		Node dataNode = new Node(data);
		if (root == null) {
			root = dataNode;
		} else {
			// traver left tree
			Node parent = root;
			while (true) {
				if (dataNode.getData() < parent.getData()) {
					if (parent.leftChild == null) {
						parent.leftChild = dataNode;
						break;
					} else {
						parent = parent.leftChild;
						continue;
					}
				} else {
					if (parent.rightChild == null) {
						parent.rightChild = dataNode;
						break;
					} else {
						parent = parent.rightChild;
						continue;
					}
				}
			}
		}

	}

	public void delete(int data) {
		Node dataNode = new Node(data);
		Node currentNode = root;
		Node parent = root;
		while (true) {
			if (dataNode.getData() < currentNode.getData()
					&& currentNode.leftChild != null) {
				parent = currentNode;
				currentNode = currentNode.leftChild;
				continue;
			} else if (dataNode.getData() > currentNode.getData()
					&& currentNode.rightChild != null) {
				parent = currentNode;
				currentNode = currentNode.rightChild;
				continue;
			} else if (dataNode.getData() == currentNode.getData()) {
				boolean hasLeftChild = false;
				boolean hasRightChild = false;
				if (currentNode.leftChild != null) {
					hasLeftChild = true;
				}
				if (currentNode.rightChild != null) {
					hasRightChild = true;
				}
				if (parent.leftChild == currentNode) {// left child
					if (hasLeftChild && hasRightChild) {// current node has a
														// sub tree. find the
														// smallest fron the
														// subtree as the
														// successor
						Node successor = findLowestElement(currentNode.rightChild);
						System.out.println("BST.delete()SUCCOSSOR:"
								+ successor.getData());
						successor.leftChild = currentNode.leftChild;
						if (successor != currentNode.rightChild) {
							successor.rightChild = currentNode.rightChild;
						}
						parent.leftChild = successor;
					} else if (hasLeftChild) {
						parent.leftChild = currentNode.leftChild;
					} else if (hasRightChild) {
						parent.leftChild = currentNode.rightChild;
					} else {
						parent.leftChild = null;
					}

				} else {// right child
					if (hasLeftChild && hasRightChild) {// current node has a
						// sub tree. find the
						// smallest fron the
						// subtree as the
						// successor
						Node successor = findLowestElement(currentNode.rightChild);
						System.out.println("BST.delete()SUCCOSSOR:"
								+ successor.getData());
						successor.leftChild = currentNode.leftChild;
						if (successor != currentNode.rightChild) {
							successor.rightChild = currentNode.rightChild;
						}
						if(parent != currentNode){//root
							parent.rightChild = successor;
						}else{
							root = successor;
						}
					} else if (hasLeftChild) {
						parent.rightChild = currentNode.leftChild;
					} else if (hasRightChild) {
						parent.rightChild = currentNode.rightChild;
					} else {
						parent.rightChild = null;
					}
				}
				break;
			} else {
				System.out.println("BST.delete( Data Not found )");
				break;
			}
		}

	}

	private Node findLowestElement(Node root) {
		Node parent = root;
		while (true) {
			if (root.leftChild != null) {
				parent = root;
				root = root.leftChild;
			} else {
				break;
			}
		}
		parent.leftChild = null;
		return root;
	}

	public void traverseInorder() {
		inorder(root);
	}

	public void inorder(Node node) {
		if (node != null) {
			inorder(node.leftChild);
			System.out.print(node.getData() + "\t");
			inorder(node.rightChild);
		}
	}

}
