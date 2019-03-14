// https://leetcode.com/problems/binary-tree-paths/description/
// https://leetcode.com/problems/path-sum-ii/description/

import java.util.ArrayList;
import java.util.List;

public class _BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode _1 = new TreeNode(1);
		TreeNode _5 = new TreeNode(5);
		TreeNode _4 = new TreeNode(4);
		
		_1.left = _5;
		_1.right = _4;
		
		TreeNode _3 = new TreeNode(3);
		TreeNode _2 = new TreeNode(2);
		
		_5.left = _3;
		_5.right = _2;
		
		TreeNode _6 = new TreeNode(6);
		TreeNode _7 = new TreeNode(3);
		
		_4.left = _7;
		_4.right = _6;
		
		
		List<List<Integer>> res = new _BinaryTreePaths().pathSum(_1, 8);
		System.out.print(res);
	}

	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }
        
        pathSum(root, 0, sum, new ArrayList<Integer>(), res);
        
        return res;
    }
    
    private void pathSum(TreeNode root, int curSum, int target, ArrayList<Integer> prefix, List<List<Integer>> res) {
        if(root.left == null && root.right == null) {
            if(curSum + root.val == target) {
                prefix.add(root.val);
                res.add((ArrayList<Integer>)prefix.clone());
                
                prefix.remove(prefix.size() - 1);
            }
            return;
        }
        
        prefix.add(root.val);
        curSum += root.val;
        
        if(root.left != null) {
            pathSum(root.left, curSum, target, prefix, res);
        }
        
        if(root.right != null) {
            pathSum(root.right, curSum, target, prefix, res);
        }
        prefix.remove(prefix.size() - 1);
    }
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        if(root == null) {
        	return res;
        }
        
        paths(root, "", res);
        return res;
    }
    
    private void paths(TreeNode root, String prefix, List<String> res) {
        if(root.left == null && root.right == null) {
            res.add("" + prefix + root.val);
            return;
        }
        
        prefix += root.val + "->";
        
        if(root.left != null) {
            paths(root.left, prefix, res);
        }
        
        if(root.right != null) {
            paths(root.right, prefix, res);
        }
    }
    
}
