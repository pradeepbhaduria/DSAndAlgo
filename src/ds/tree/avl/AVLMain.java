package ds.tree.avl;

public class AVLMain {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		
		tree.insert(7);
		
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		
		tree.insert(11);tree.insert(12);tree.insert(13);
		tree.inorder();
		System.out.println("\nTree Height :"+tree.getHeight());
	}

}
