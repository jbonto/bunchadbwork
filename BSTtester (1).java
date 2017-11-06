package tree;

public class BSTtester {
	public static void main(String[] args){
		BST<Integer> tree = new BST<Integer>();
		tree.add(35);
		tree.add(33);
		tree.add(30);
		System.out.println(tree.height());
		//tree.delete(17);
		//still trying to figure out delete
		System.out.println("leaves "+tree.leaves());
		//pretty print defaults depth to 4 if height hasn't been figured out
		System.out.println(tree.toString());
		//System.out.println(tree.inOrder(tree.getRoot()));
	}
}
