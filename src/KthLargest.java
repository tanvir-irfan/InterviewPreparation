class KthLargest {
    static class TreeNode {
        int val;
        int numLeftChild;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
            this(0, 0, null, null);
        }
        
        TreeNode(int val) {
            this(val, 0, null, null);
        }
        
        TreeNode(int val, int numLeftChild) {
            this (val, numLeftChild, null, null);
        }
        
        TreeNode(int val, int numLeftChild, TreeNode left, TreeNode right) {
            this.val = val;
            this.numLeftChild = numLeftChild;
            this.left = left;
            this.right = right;
        }
        
        public String toString() {
        	return this.val + "";
        }
    }
    
    TreeNode root;
    int size;
    int k;
    
    public KthLargest(int k, int[] nums) {
        root = null;
        this.k = k;
        this.size = nums.length;
        
        
        for(int i = 0; i < nums.length; i++) {
        	root = insertIntoBST (root, nums[i]);
        }
    }
    
    public int add(int val) {
    	this.size++;
        this.root = insertIntoBST (root, val);
        
        TreeNode cur = findKthLargest(root, this.k);
        
        return cur.val;
    }
    
    private TreeNode findKthLargest(TreeNode root, int k) {
    	return findKthSmallest(root, size - k + 1);
    }
    
    private TreeNode findKthSmallest(TreeNode root, int k) {
    	
    	if(root == null) {
    		return null;
    	}
    	
    	if(root.numLeftChild == k - 1) {
    		return root;
    	}
    	
    	if(root.numLeftChild >= k) {
    		return findKthSmallest(root.left, k);
    	} else {
    		return findKthSmallest(root.right, k - root.numLeftChild - 1);
    	}
    }
    
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            TreeNode tr = new TreeNode(val, 0);
            return tr;
        }
        
        if(root.val >= val) {
            if(root.left == null) {
                TreeNode tr = new TreeNode(val);
                root.left = tr;
                root.numLeftChild++;
                return root;
            } else {
                root.numLeftChild++;
                insertIntoBST(root.left, val);
                return root;
            }
        } else {
            if(root.right == null) {
                TreeNode tr = new TreeNode(val);
                root.right = tr;
                return root;
            } else {
                insertIntoBST(root.right, val);
                return root;
            }
        }
    }
    
    public static void main(String str[]) {
    	int [] nums = {4,5,8,2};
    	
    	KthLargest kth = new KthLargest(3, nums);
    	
    	int [] nums2 = {3,5,10,9,4};
    	
    	for(int i = 0;  i < nums2.length; i++) {
    		int x = kth.add(nums2[i]);
    		System.out.println(x);
    	}
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */