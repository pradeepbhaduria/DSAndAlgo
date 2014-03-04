package ds.tree.bst;

public class Main {
	public static void main(String args[]) {
		System.out.println("Main.main() START");
		BST tree = new BST();
		tree.insert(500);
		tree.insert(1000);
		tree.insert(50);
		
		tree.insert(25);
		tree.insert(175);
		tree.insert(705);
		tree.insert(5);
		tree.insert(35);
		tree.insert(37);
		tree.insert(30);
		tree.insert(1500);tree.insert(1100);tree.insert(1600);
		
		tree.traverseInorder();
		System.out.println("Main.main() Deleting ");
		tree.delete(500);
		tree.traverseInorder();
		System.out.println("Main.main() END");
	}
}
