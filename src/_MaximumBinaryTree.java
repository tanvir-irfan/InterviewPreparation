//https://leetcode.com/problems/maximum-binary-tree/description/


public class _MaximumBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,2,1,6,0,5};
		new _MaximumBinaryTree().constructMaximumBinaryTree(nums);
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        
        if(low < 0 || high >= nums.length || high < low) {
           return null; 
        }
        
        if(low == high) {
            return new TreeNode(nums[low]);
        }
        
        int maxInd = findMax(nums, low, high);
        
        System.out.println(maxInd);
        
        TreeNode root = new TreeNode(nums[maxInd]);
        
        root.left = constructMaximumBinaryTree(nums, low, maxInd - 1);
        root.right = constructMaximumBinaryTree(nums, maxInd + 1, high);
        
        return root;
    }
    
    private int findMax(int []nums, int low, int high) {
        int res = low;
        
        for(int i = low; i <= high; i++) {
            if(nums[i] > nums[res]) {
                res = i;
            }
        }
        
        return res;
    }
}
