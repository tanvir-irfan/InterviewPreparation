public class CompleteBinaryTree {

	static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	     
	     public String toString() {
	    	 return this.val + "";
	     }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode _0 = new TreeNode(0);
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
		
//		_3.left = _6;
//		_3.right = _7;
		
//		_2.left = _7;
//		_2.right = _4;
		
		boolean res = new CompleteBinaryTree().isCompleteTree(_1);
		
		System.out.println(res);
	}
	
	public boolean isCompleteTree(TreeNode root) {
        if(root == null || root.right == null) {
            return true;
        }
        
        return recursive (root.left, root.right);
    }
    
    private boolean recursive(TreeNode l, TreeNode r) {
        if(l == null && r == null) {
            return true;
        }
        
        int ll = (l != null && l.left != null) ? 8 : 0;
        int lr = (l != null && l.right != null) ? 4 : 0;
        int rl = (r != null && r.left != null) ? 2 : 0;
        int rr = (r != null && r.right != null) ? 1 : 0;
        
        int combination = ll + lr + rl + rr;
        
        if(combination == 15 || combination == 14) {
            return recursive(l.left, l.right) && recursive(r.left, r.right);
        } else if(combination == 0) {
            return true;
        } else if(combination == 12) {
            return l.left.left == null && l.left.right == null;
        }
        
        return false;
    }

}
