import java.util.ArrayList;
import java.util.List;

public class VerticalOrderOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	static void verticalOrder(TreeNode root)
    {
        // add your code
        int [] width = new int[2];
        
        findWidth(root, width);
        
        List<List<Integer>> res = new ArrayList<>(width[1] - width[0]);
        
        for(int i = 0; i < (width[1] - width[0]) + 1; i++) {
            res.add(new ArrayList<>());
        }
        
        addToVerticalLevel(root, 0, width[0], res);
        
        for(List<Integer> resT : res) {
            for(Integer i : resT) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        return;
    }
    
    private static void addToVerticalLevel(TreeNode root, int width, int minW, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        
        res.get(width + - 1 * minW).add(root.val);
        
        if(root.left != null) {
            addToVerticalLevel(root.left, width - 1, minW, res);
        }
        
        if(root.right != null) {
            addToVerticalLevel(root.left, width + 1, minW, res);
        }
    }
    
    private static void findWidth(TreeNode root, int[] width) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            width[0] = width[0] - 1;
            findWidth(root.left, width);
        }
        
        if(root.right != null) {
            width[1] = width[1] + 1;
            findWidth(root.left, width);
        }
    }
}
