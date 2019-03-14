
public class SumRootToLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r0 = new TreeNode (0);
		TreeNode r1 = new TreeNode (1);
		TreeNode r2 = new TreeNode (2);
		TreeNode r3 = new TreeNode (3);
		TreeNode r4 = new TreeNode (4);
		TreeNode r5 = new TreeNode (5);
		TreeNode r6 = new TreeNode (6);
		TreeNode r7 = new TreeNode (7);
		TreeNode r8 = new TreeNode (8);
		TreeNode r9 = new TreeNode (9);
		
		r4.left = r9;
		r4.right = r0;
		r9.left = r5;
		r9.right = r1;
		
		System.out.println(new SumRootToLeaf().sumNumbers(r4));
	}
	
	public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return sumNumbers(root, new Integer(0), 0);
    }
    
    private int sumNumbers(TreeNode root, Integer sum, int path) {
        path =  path * 10 + root.val;
        
        if(root.left == null && root.right == null) {
            sum += path;
            return sum;
        }
        
        if(root.left != null){
            sum += sumNumbers(root.left, 0, path);
        }
        
        if(root.right != null){
        	sum += sumNumbers(root.right, 0, path);
        }
        
        return sum;
    }

}
