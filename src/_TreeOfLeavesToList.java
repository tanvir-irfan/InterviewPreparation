// you are given a Binary Tree.
// Transform it to a Doubly Linked List only consisting of the leaf nodes from left to right;
public class _TreeOfLeavesToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode _1 = new TreeNode(1);

		TreeNode _2 = new TreeNode(2);
		TreeNode _3 = new TreeNode(3);

		TreeNode _4 = new TreeNode(4);
		TreeNode _5 = new TreeNode(5);

		TreeNode _6 = new TreeNode(6);
		TreeNode _7 = new TreeNode(7);

		TreeNode _8 = new TreeNode(8);
		
		_1.left = _2;
		_1.right = _3;
		
		_2.left = _4;
		_2.right = _5;
		
		_3.left = _6;
		_3.right = _7;
		
		
		_TreeOfLeavesToList t = new _TreeOfLeavesToList();
		
		t.transformToList(_1);
		
		System.out.println(_1);
		
	}

	static TreeNode prev = null;
	static TreeNode head = null;

	public void transformToList(TreeNode root) {
		System.out.println(root);

		if (root.left == null && root.right == null) {
			if (prev == null) {
				prev = root;
				head = root;
			} else {
				prev.right = root;
				root.left = prev;

				prev = root;
			}
			
			return;
		}

		transformToList(root.left);
		transformToList(root.right);

	}

}
