// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class _GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_GenerateParenthesis gp = new _GenerateParenthesis();

		List<String> res = gp.generateParenthesis(3);
		System.out.println("Actual Result:");
		for(int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	
	public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        
        genParenthesis(n, 0, 0, "", res);
        
        return res;
    }
    
    private void genParenthesis(int max, int leftB, int rightB, String path, List<String> res) {
    	System.out.println(path);
        if(path.length() == max * 2) {
            res.add(path);
            System.out.println();
            return;
        }
        
        if(leftB < max) {
            genParenthesis(max, leftB + 1, rightB, path + "(", res);
        }
        
        if(rightB < leftB) {
            genParenthesis(max, leftB, rightB + 1, path + ")", res);
        }
    }

}
