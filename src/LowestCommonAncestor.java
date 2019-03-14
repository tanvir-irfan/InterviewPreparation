import java.util.ArrayList;
import java.util.LinkedList;;
public class LowestCommonAncestor {
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
		
		_3.left = _5;
		_3.right = _1;
		
		_5.left = _6;
		_5.right = _2;
		
		_1.left = _0;
		_1.right = _8;
		
		_2.left = _7;
		_2.right = _4;
	}
    
    private boolean find(TreeNode root, TreeNode p, ArrayList<TreeNode> pathP) {
        if(root == null) {
            return false;
        }
        
        pathP.add(root);
        if(root.val == p.val) {
            return true;
        }
        
        boolean found = find(root.left, p, pathP);
        
        if(!found) {            
            found = find(root.right, p, pathP);
        }
        
        if(!found) {
        	pathP.remove(pathP.size() - 1);
        }
        return found;
    }
    
    private TreeNode findCommon(ArrayList<TreeNode> pathP, ArrayList<TreeNode> pathQ) {
        
        if(pathQ.size() < pathP.size()) {
            return findCommon(pathQ, pathP);
        }
        
        int index = 0;
        while(true) {
            if(index >= pathP.size() || pathP.get(index) != pathQ.get(index)) {
                break;
            }
            index++;
        }
        
        return pathP.get(index - 1);
    }
}


 