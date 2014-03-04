package ds.tree.bst;

public class Node {
	public Node(double data) {
		super();
		this.data = data;
	}

	private double data;
	
	Node leftChild;
	Node rightChild;

	/**
	 * @return the person
	 */
	public double getData() {
		return data;
	}

}
