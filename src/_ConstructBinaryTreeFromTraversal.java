// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

public class _ConstructBinaryTreeFromTraversal {

	public enum NODE {ROOT, LEFT, RIGHT}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] in = {4, 2, 5, 1, 6, 3, 7};
				
		int [] post = {4, 5, 2, 6, 7, 3, 1};
		
		TreeNode root = new _ConstructBinaryTreeFromTraversal().buildTree(in, post);
		System.out.println(root);
	}

	public TreeNode buildTree(int[] in, int[] post) {
		if (in == null || post == null) {
			return null;
		}

		return buildFromInPost(in, 0, in.length - 1, post, 0, post.length - 1, NODE.ROOT);
	}

	/**
	 * 
	 * @param  in Preorder traversal of the Tree
	 * @param  inL  Left/Starting index {@link in} array
	 * @param  inR  Right/End index {@link in} array
	 * @param  post  Inorder traversal of the Tree
	 * @param  postL  Left/Starting index {@link post} array
	 * @param  postR  Right/End index {@link post} array
	 * @return Returns the root node of generated Tree
	 */
	public TreeNode buildFromInPost(int[] in, int inL, int inR, int[] post, int postL, int postR, NODE whichNode) {
        
        if(in == null || post == null || inR < inL || postR < postL) {
            return null;
        }
        
        TreeNode root;
        
                
        if(postL == postR && whichNode == NODE.RIGHT) {
            root = new TreeNode(post[postL]);
            return root;
        }
        
        if(inL == inR && whichNode == NODE.LEFT) {
            root = new TreeNode(in[inL]);
            return root;
        }

        
        // fix the recursive state and then will come back to the base case. :-)
        int rootVal = post[postR];
        
        root = new TreeNode(rootVal);
        
        int rootPosIn = inL;    // finding the root position in Inorder traversal
        
        for( ; rootPosIn <= inR; rootPosIn++) {
            if(in[rootPosIn] == rootVal) {
                break;
            }
        }
        
        
        int numOfNodesInLeftSubTree = rootPosIn - inL;
        if(numOfNodesInLeftSubTree == 0) {
            root.left = null;
        } else {
            root.left = buildFromInPost(in, inL, rootPosIn - 1, post, postL, postL - 1 + numOfNodesInLeftSubTree, NODE.LEFT);
        }
        
        int numOfNodesInRightSubTree = inR - rootPosIn;
        
        if(numOfNodesInRightSubTree == 0) {
            root.right = null;
        } else {
            root.right = buildFromInPost(in, rootPosIn + 1, inR, post, postR - numOfNodesInRightSubTree, postR - 1, NODE.RIGHT);
        }
        
        return root;
    }
	
	/**
	 * 
	 * @param  preOrder Preorder traversal of the Tree
	 * @param  preLeft  Left/Starting index {@link pre} array
	 * @param  preRight  Right/End index {@link pre} array
	 * @param  inOrder  Inorder traversal of the Tree
	 * @param  inLeft  Left/Starting index {@link in} array
	 * @param  inRight  Right/End index {@link in} array
	 * @return Returns the root node of generated Tree
	 */
	private TreeNode recursive (int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if(preOrder == null || preOrder.length == 0 || preLeft >= preOrder.length) {
            return null;
        }
        
        TreeNode root;
        
        if(preLeft == preRight) {
            root = new TreeNode (preOrder[preLeft]);
            return root;
        }        
        
        int rootVal = preOrder[preLeft];
        root = new TreeNode (rootVal);
        
        int rootPos = inLeft;
        for(; rootPos < inRight; rootPos++) {
            if(inOrder[rootPos] == rootVal) {
                break;
            }
        }
        
        int leftTreeMembers = rootPos - inLeft;
        
        if(leftTreeMembers == 0) {
        	root.left = null;
        } else {
        	root.left = recursive(preOrder, preLeft + 1, preLeft + leftTreeMembers, inOrder, inLeft, rootPos - 1);
        }
        
        int rightTreeMembers = inRight - rootPos;
        if(rightTreeMembers == 0) {
        	root.right = null;
        } else {
        	root.right = recursive(preOrder, preLeft + leftTreeMembers + 1, preRight, inOrder, rootPos + 1, inRight);
        }
        
        return root;
    }

}
