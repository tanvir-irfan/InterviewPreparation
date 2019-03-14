/*
 Suppose we have a structure Node like the following
 
  
Node {
  Node left
  Node right
  int value
}

Such structure can be used to represent a binary tree, where, for each node of the tree, 
"left" is the root of the left subtree, and "right" is the root of the right subtree. 
"value" is the actual value held by the node.
  
The Node structure can also be used to represent a doubly linked list 
(each node of the list is connected to one node to its left and another node to its right).
  
What I want you to do is, given a binary tree, turn it into a circular doubly linked list 
whose nodes are sorted in the same order as the in-order traversal of the tree. 
Please note that the tree needs to be modified in-place, that is, the original tree needs to be 
modified to somehow end up as the list we want to build. This algorithm needs to return the beginning of the list.
  
For instance given the following tree:

              
         1
       /   \
      5     4
    /   \    \
   3     2    7


The corresponding circular doubly linked list would be like so:


  ->3<-->5<-->2<-->1<-->4<-->7<-
  |                              |
  |______________________________|
    

(note that, since the list is circular, the first and the last nodes are connected)
   5
3    2

*/

public class BinaryTreeToDublyCircularLinkedList {
	
	public static void main(String [] s) {
		TreeNode _1 = new TreeNode(1);
		TreeNode _5 = new TreeNode(5);
		TreeNode _4 = new TreeNode(4);
		
		_1.left = _5;
		_1.right = _4;
		
		TreeNode _3 = new TreeNode(3);
		TreeNode _2 = new TreeNode(2);
		
		_5.left = _3;
		_5.right = _2;
		
//		TreeNode _6 = new TreeNode(6);
		TreeNode _7 = new TreeNode(7);
		
//		_4.left = _6;
		_4.right = _7;
		
		
		TreeNode root = new BinaryTreeToDublyCircularLinkedList().toDublyCircularList(_1);
		System.out.println(root);
		
	}
	
	TreeNode prev = null;
	
	private TreeNode toDublyCircularList(TreeNode root) {
		
		if(root == null) {
			return root;
		}
		
		TreeNode leftList = toDublyCircularList(root.left);
		TreeNode rightList = toDublyCircularList(root.right);
		
		root.left = root;
		root.right = root;
		
		root = concat(root, rightList);
		root = concat(leftList, root);
		
		
		return root;
	}
	
	private TreeNode concat (TreeNode a, TreeNode b) {
		if(a == null) {
			return b;
		} else if(b == null) {
			return a;
		}
		
		TreeNode aEnd = a.left;
		TreeNode bEnd = b.left;
		//a = <- 3 <-> 5 <-> 2 ->
		//    
		//b = <- 4 <-> 7 ->
		
		aEnd.right = b;
		b.left = aEnd;
		
		//<- 3 <-> 5 <-> 2 <-> 4 <-> 7 ->
		bEnd.right = a;
		a.left = bEnd;
		
		return a;
	}
	
}
