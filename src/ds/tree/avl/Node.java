package ds.tree.avl;

public class Node {
	public Node(int data) {
		super();
		this.data = data;
	}

	Node leftChild;
	Node rightChild;
	private int data;

	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
