import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NAryTree {
	
	static class NAryTreeNode {
	    public int val;
	    public List<NAryTreeNode> children;

	    NAryTreeNode() {}

	    NAryTreeNode(int _val, List<NAryTreeNode> _children) {
	        val = _val;
	        children = _children;
	    }
	    
	    public String toString() {
	    	return val + "";
	    }
	}
	
	public List<List<Integer>> levelOrder(NAryTreeNode root) {
		List<List<Integer>> results = new ArrayList<>();
		if (root != null) {
			Queue<NAryTreeNode> queue = new ArrayDeque<>();
			queue.add(root);
			List<Integer> temp = new ArrayList<>();
			List<NAryTreeNode> levelChildren = new ArrayList<>();
			while (!queue.isEmpty()) {
				while (!queue.isEmpty()) {
					NAryTreeNode current = queue.poll();
					temp.add(current.val);
					if (current.children != null) {
						levelChildren.addAll(current.children);
					}
				}
				results.add(temp);
				temp = new ArrayList<>();
				queue.addAll(levelChildren);
				levelChildren = new ArrayList<>();
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NAryTree.NAryTreeNode _6 = new NAryTreeNode(6, null);
		NAryTree.NAryTreeNode _5 = new NAryTreeNode(5, null);
		
		NAryTree.NAryTreeNode _3 = new NAryTreeNode(3, new ArrayList<NAryTree.NAryTreeNode>());
		_3.children.add(_6);
		_3.children.add(_5);
		
		NAryTree.NAryTreeNode _2 = new NAryTreeNode(2, null);		
		NAryTree.NAryTreeNode _4 = new NAryTreeNode(4, null);
		
		NAryTree.NAryTreeNode _1 = new NAryTreeNode(1, new ArrayList<NAryTree.NAryTreeNode>());
		
		_1.children.add(_3);
		_1.children.add(_2);
		_1.children.add(_4);
		
		
		List<List<Integer>> res = new NAryTree().levelOrder(_1);
		
		System.out.println(res.size());
	}

}
