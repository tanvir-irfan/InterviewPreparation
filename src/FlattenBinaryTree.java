
public class FlattenBinaryTree {

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
		_1.right = _5;
		
		_2.left = _3;
		_2.right = _4;
		
		_5.left = null;
		_5.right = _6;
		
//		_2.left = _7;
//		_2.right = _4;
		
		new FlattenBinaryTree().flatten(_1);
		
	}
	
	public void flatten(TreeNode root) {
        recur(root, root);
        
    }
    
    private void recur(TreeNode root, TreeNode cur) {
    	System.out.println(cur.val);
        if(root == null) {
        	if(cur != null) {
        		cur.left = null;
        	}
            return;
        }
        
        if(root.left == null && root.right == null) {
        	if(cur != root) {
        		cur.left = null;
        		cur.right = root;
        	}
        	return;
        }
        
        TreeNode cL = cur.left;
        TreeNode cR = cur.right;
        
        if(root.left != null) {
            cur.left = null;
            cur.right = cL;
            
            cur = cur.right;
            recur(cL, cur);
        }
        
        recur(cR,cur);
    }
}
