

public class BSTtester {
	public static void main(String[] args){
		BST tree = new BST();
		tree.add(35);
		tree.add(33);
		tree.add(38);
		tree.add(17);
		tree.add(34);
		tree.add(40);
		tree.add(37);
		tree.add(41);

		tree.delete(33);
		//still trying to figure out delete
		System.out.println("leaves "+tree.leaves());
		//pretty print defaults depth to 4 if height hasn't been figured out
		System.out.print(tree.toString());
	}
}
