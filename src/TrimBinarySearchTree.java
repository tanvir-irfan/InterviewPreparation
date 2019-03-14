
public class TrimBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		
		TrimBinarySearchTree.trimBST(root, 1, 3);
	}

	public static TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) 
            return null;

        // If the value of this node is less than L, then the whole left subtree will be smaller, 
        // so we can discard the left sub tree and return the root of the trimmed right sub tree 
        if (root.val < L) 
            return trimBST(root.right, L, R);

        // If the value of this node is greater than R, then the whole right subtree will be greater
        // so we can discard the right sub tree and return the root of the trimmed left sub tree
        if (root.val > R) 
            return trimBST(root.left, L, R);

        // If the value of this node does not need to be deleted, 
        // we need to pass this recursive call downwards to both sides
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        // All the processing of the subtrees done, now return this node
        return root;
    }
}
