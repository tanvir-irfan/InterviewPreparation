import java.util.LinkedList;

public class SerializeBinaryTree {
	static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	     
	     public String toString() {
	    	 return this.val + "";
	     }
	}
	
	private static String NULL_CHILD = "#";
    private static String NODE_SEPARATOR = ":";
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        
        while(!q.isEmpty()) {
            TreeNode cur = q.removeFirst();
            
            if(cur != null) {
            	res.append(cur.val);
            	q.addLast(cur.left);
                
                q.addLast(cur.right);
            } else {
            	res.append(NULL_CHILD);
            }
            res.append(NODE_SEPARATOR);
        }
        return res.toString();
    }
	
    
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) {
            return null;
        }
        String [] nodes = data.split(NODE_SEPARATOR);
        TreeNode root = new TreeNode( Integer.parseInt(nodes[0]));
        
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        TreeNode curL, curR;
        
        for(int i = 1; i < nodes.length; i += 2) {
        	curL = nodes[i].equals(NULL_CHILD) ? null : new TreeNode( Integer.parseInt(nodes[i]));
        	curR = nodes[i + 1].equals(NULL_CHILD) ? null : new TreeNode( Integer.parseInt(nodes[i + 1]));
        	
        	TreeNode addChild = q.removeFirst();
        	
        	if(addChild == null) {
        		continue;
        	}
        	
    		addChild.left = curL;
    	
    		addChild.right = curR;
        	if(curL != null)
        		q.addLast(curL);
        	if(curR != null)
        		q.addLast(curR);
        }
        
        return root;
    }
    
 // Decodes your encoded data to tree.
    public TreeNode deserialize_Old(String data) {
        if(data == null || data.isEmpty()) {
            return null;
        }
        String [] nodes = data.split(NODE_SEPARATOR);
        TreeNode root = new TreeNode( Integer.parseInt(nodes[0]));
        int counter = 0;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        TreeNode cur = root;
        
        for(int i = 1; i < nodes.length; i++) {
        	cur = nodes[i].equals(NULL_CHILD) ? null : new TreeNode( Integer.parseInt(nodes[i]));
        	TreeNode addChild = q.getFirst();
        	if(addChild == null) {
        		continue;
        	}
        	if(counter % 2 == 0 && addChild.left == null) {
        		addChild.left = cur;
        	} else if(addChild.right == null) {
        		addChild.right = cur;
        	}
        	
        	counter++;
        	if(counter % 2 == 0) {
        		q.removeFirst();
        	}
        	q.addLast(cur);
        }
        
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode _0 = new TreeNode(0);
		TreeNode _1 = new TreeNode(1);
		TreeNode _2 = new TreeNode(2);
		TreeNode _22 = new TreeNode(2);
		TreeNode _3 = new TreeNode(3);
		TreeNode _33 = new TreeNode(3);
		TreeNode _4 = new TreeNode(4);
		TreeNode _5 = new TreeNode(5);
		TreeNode _6 = new TreeNode(6);
		TreeNode _7 = new TreeNode(7);
		TreeNode _8 = new TreeNode(8);
		
		
		_5.left = _2;
		_5.right = _3;
		
		_3.left = _22;
		_3.right = _4;
		
		_22.left = _33;
		_22.right = _1;
		
		//#########################################
//		_3.left = _4;
//		_3.right = _5;
//		
//		_1.left = _2;
//		_1.right = _3;
		//#########################################
//		_3.left = _5;
//		_3.right = _1;
//		
//		_5.left = _6;
//		_5.right = _2;
//		
//		_1.left = _0;
//		_1.right = _8;
//		
//		_2.left = _7;
//		_2.right = _4;
		//#########################################
		
		SerializeBinaryTree sbt = new SerializeBinaryTree();
		String data = sbt.serialize(_5);
		System.out.println(data);
		
		TreeNode root = sbt.deserialize(data);
		
		System.out.println(root);
	}

}
