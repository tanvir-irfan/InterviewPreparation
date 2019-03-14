import java.util.List;
import java.util.ArrayList;

public class _Subset {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = subsetsNew(nums);
		System.out.println(res);
	}

//////////////////////////////////////////////////////////////////////////////////////////////
	
	public static List<List<Integer>> subsetsNew(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            buildSubsets(nums[i], res);
        }
        
        return res;
    }
    
    private static void buildSubsets(int num, List<List<Integer>> res) {
    	
    	if(res.size() == 0) {
    		List<Integer> temp = new ArrayList<>();
    		res.add(new ArrayList<>());
    		temp.add(num);
    		res.add(temp);
    	} else {
    		int size = res.size();
    		for(int i = 0; i < size; i++) {
    			List<Integer> temp = new ArrayList<>(res.get(i));
    			temp.add(num);
                res.add(temp);
            }
    	}
        
        return;
    }
	
//////////////////////////////////////////////////////////////////////////////////////////////
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        subsetHelper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void subsetHelper(int[] s, int index, List<Integer> path, List<List<Integer>> result){
    	result.add(new ArrayList<Integer>(path));

        for(int i = index; i < s.length; i++){
            path.add(s[i]);
            subsetHelper(s, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////
	
	public static ArrayList<ArrayList<Character>> getAllSubsets(char[] chars) {
		ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
		res.add(new ArrayList<Character>());
		for (int i = 0; i < chars.length; i++) {
			buildSubset(res, chars[i]);
		}
		return res;
	}

	public static void  buildSubset(ArrayList<ArrayList<Character>> res, char c) {
		ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>>();
		for (ArrayList<Character> a : res) {
			ArrayList<Character> tt = new ArrayList<>(a);
			tt.add(c);
			temp.add(tt);
		}
		res.addAll(temp);
	}
	
	public static int almost_palindromes(String str) {
        int score = 0;
        for(int i = 0; i < str.length() / 2; i++) {
            char a = str.charAt(i);
            char b = str.charAt(str.length() - 1 - i);
            
            if(a != b) {
                score++;
            }
        }
        return score;
    }
	
}
