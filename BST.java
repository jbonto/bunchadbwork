
public class BST<T extends Comparable<T>> {
	Node<T> root;

	@SuppressWarnings("hiding")
	private class Node<T extends Comparable<T>> {
		// extends comparable makes the individual nodes comparable
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data) {
			super();
			this.data = data;
		}
	}

	public void add(T data) {
		root = add(root, data);

	}
	public Node<T> getRoot(){
		return root;
	}
	private Node<T> add(Node<T> ptr, T data) {
		if (ptr == null) {
			return new Node<T>(data);
		}
		if (data.compareTo(ptr.data) < 0) {
			ptr.left = add(ptr.left, data);
		} else {
			if (data.compareTo(ptr.data) > 0) {
				ptr.right = add(ptr.right, data);
			}
		}
		return ptr;
	}
	public int leaves() {
		if(root==null){
			return 0;
		}
		return leaves(root);
	}
	public int leaves(Node<T> ptr){

		if(ptr==null){
			return 0;
		}
		if(ptr.left==null && ptr.right==null){
			return 1;
		} else if(ptr.left!=null && ptr.right!=null){
			return 0+ leaves(ptr.left)  + leaves(ptr.right);
		} else if (ptr.left!=null){
			return 0 + leaves(ptr.left);
		} else if (ptr.right!=null){
			return 0 + leaves(ptr.right);
		}
		return 0;
	}

	public void delete(T data){
		delete(data, root);
	}
	private void delete(T data, Node<T> ptr){
		if(data.compareTo(ptr.data)==0){
			System.out.println("deleted");
			if(ptr.right!=null)
				ptr = ptr.right;
			else if (ptr.left!=null)
				ptr = ptr.left;
			else
				ptr = null;
			System.out.println(ptr.data);
		} else {
			if (ptr.left!=null && ptr.right!=null){
				delete(data, ptr.left);
				delete(data, ptr.right);
			} else if(ptr.right!=null){
				delete(data, ptr.right);
			} else if(ptr.left!=null){
				delete(data, ptr.left);
			}

		}
	}


	public int height(){
		if(root==null)
			return 0;
		return height(root);
	}
	private int height(Node<T> ptr){
		if(ptr.left!=null && ptr.right!=null){
			return 1+ Math.max(height(ptr.left), height(ptr.right));
		} else if(ptr.right!=null){
			return 1 + height(ptr.right);
		} else if(ptr.left!=null){
			return 1 + height(ptr.left);
		}
		return 0 ;
	}
	//height 1+ max of subtrees
	//pretty print
	public String inOrder(Node<T> ptr) {
		String result = "";
		if (ptr == null)
			return "";
		result += inOrder(ptr.left)+" ";
		result += ptr.data+" ";
		result += inOrder(ptr.right)+" ";
		return result;
	}

	public String toString(){
		return prettyPrint();
	}

	public String prettyPrint() {
		if (root == null)
			return "";

		int depth = height();
		//int depth = 4;
		@SuppressWarnings("unchecked")
		Node<T>[][] tree = (Node<T>[][]) new Node[depth][(int) Math.pow(2, depth)];

		tree[0][0] = root;
		for (int level = 1; level < depth; level++)
			for (int i = 0; i < Math.pow(2, level - 1); i++)
				if (tree[level - 1][i] == null)
				{
					tree[level][i * 2] = null;
					tree[level][i * 2 + 1] = null;
				}
				else
				{
					tree[level][i * 2] = tree[level - 1][i].left;
					tree[level][i * 2 + 1] = tree[level - 1][i].right;
				}

		String result = "";
		String blankSpaces = "                                                           ";

		for (int level = 0; level < depth; level++)
		{
			result += "\n";
			int n = 3 * ((int) Math.pow(2, depth - 1 - level) - 1);
			String spacesAfter = blankSpaces.substring(0, n / 2);
			String spacesBefore = blankSpaces.substring(0, n - n / 2);

			for (int i = 0; i < Math.pow(2, level); i++)
				if (tree[level][i] == null)
					result += spacesBefore + " X " + spacesAfter;
				else
					result += spacesBefore + " " + tree[level][i].data + " "
							+ spacesAfter;
		}
		return result;
	}

}
