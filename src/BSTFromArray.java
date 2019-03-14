
public class BSTFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {-10,-3,0,5,9};
		
		TreeNode root = new BSTFromArray().sortedArrayToBST(nums);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		public String toString() {
			return this.val + "";
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start == end) {
			return new TreeNode(nums[start]);
		}

		if (start == end - 1) {
			TreeNode root = new TreeNode(nums[end]);
			root.left = new TreeNode(nums[start]);

			return root;
		}

		if (start == end - 2) {
			TreeNode root = new TreeNode(nums[start + 1]);
			root.left = new TreeNode(nums[start]);
			root.right = new TreeNode(nums[end]);

			return root;
		}

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, 0, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);

		return root;
	}
}
