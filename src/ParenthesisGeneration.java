import java.util.List;
import java.util.ArrayList;

public class ParenthesisGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParenthesisGeneration p = new ParenthesisGeneration();
		for(String s : p.generateListBackTracking(2)) {
			System.out.println(s);
		}
	}

	
	public List<String> generateParenthesis(int n) {
	    List<String> combinations = new ArrayList<>();
	    generateAll(new char[2 * n], 0, combinations);
	    return combinations;
	}

	private void generateAll(char[] current, int pos, List<String> result) {
	    if (pos == current.length) {
	        if (valid(current))
	            result.add(new String(current));
	    } else {
	        current[pos] = '(';
	        generateAll(current, pos+1, result);
	        current[pos] = ')';
	        generateAll(current, pos+1, result);
	    }
	}

	private boolean valid(char[] current) {
	    int balance = 0;
	    for (char c: current) {
	        if (c == '(') balance++;
	        else balance--;
	        if (balance < 0) return false;
	    }
	    return (balance == 0);
	}
	
	public List<String> generateListBackTracking(int n) {
		List<String> res = new ArrayList<>();
		generateListBackTracking(res, "", 0, 0, n );
		return res;
	}
	
	public void generateListBackTracking(List<String> res, String cur, int open, int close, int max) {
		if(cur.length() == max * 2) {
			res.add(cur);
			return;
		}
		
		if(open < max) {
			generateListBackTracking(res, cur+"(", open + 1, close, max );
		}
		if(close < open) {
			generateListBackTracking(res, cur+")", open, close + 1, max );
		}
	}
}


