import java.util.ArrayList;
import java.util.LinkedList;

public class JavaCollectionFramework {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> lvs1 = getLeafValueSequence(root1);
        ArrayList<Integer> lvs2 = getLeafValueSequence(root2);
        
        if(lvs1.size() != lvs2.size()) {
            return false;
        }
        
        for(int i = 0; i < lvs1.size(); i++) {
            if(lvs1.get(i) != lvs2.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private ArrayList<Integer> getLeafValueSequence (TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        
        ArrayList<Integer> lvs = new ArrayList<>();
        
        q.addLast(root);
        
        while(!q.isEmpty()) {
            TreeNode tn = q.removeFirst();
            
            if(tn.left == null && tn.right == null) {
                lvs.add(tn.val);
            }
            
            if(tn.left != null) q.addLast(tn.left);
            if(tn.right != null) q.addLast(tn.right);
        }
        
        return lvs;
    }	
	
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode (1);
		TreeNode r2 = new TreeNode (2);
		TreeNode r3 = new TreeNode (3);
		TreeNode r4 = new TreeNode (4);
		TreeNode r5 = new TreeNode (5);
		TreeNode r6 = new TreeNode (6);
		TreeNode r7 = new TreeNode (7);
		TreeNode r8 = new TreeNode (8);
		TreeNode r9 = new TreeNode (9);
		
		r3.left = r5;
		r3.right = r1;
		
		r5.left = r6;
		r5.right = r2;
		
		r2.left = r7;
		r2.right = r4;
		
		r1.left = r9;
		r1.right = r8;
		
		new JavaCollectionFramework().leafSimilar(r3,r3);
//		TreeNode r1 = new TreeNode (1);
//		TreeNode r1 = new TreeNode (1);
//		TreeNode r1 = new TreeNode (1);
		
	}

}


