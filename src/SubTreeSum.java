
public class SubTreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(-10);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(8);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(-4);
		root.right.right = new TreeNode(7);
		
		System.out.println(new SubTreeSum().countSubtreesWithSumX(root, 7));
	}

	private static int ans = 0;
    int countSubtreesWithSumX(TreeNode root, int x) {
        helper(root, x);
        int res = ans;
        ans = 0;
        return res;
    }
    
    int helper(TreeNode root, int x) {
	    //Add your code here.
	    if(root == null) {
	        return 0;
	    }
	    
	    int l = helper(root.left, x);
	    int r = helper(root.right, x);
	    
	    if((l + r + root.val) == x) {
	        ans++;
	    }
	    
	    return l + r + root.val;
    }
}
