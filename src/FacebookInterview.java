import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacebookInterview {

	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
        if(path.size() == s.length)
        	result.add(new ArrayList<Integer>(path));

        for(int i = index; i < s.length; i++){
            path.add(s[i]);
            dfs(s, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
	///////////////////////////////////////////////////////////////////////////////////////////////
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        permuteRecursion(results, nums, 0, nums.length - 1);
        
        return results;
    }
    
    public void permuteRecursion(List<List<Integer>> results, int[] nums, int start, int end) {
    	
//    	System.out.println("start, end = " + nums[start] + ", " + nums[end] );
//    	System.out.println("start, end = " + start + ", " + end );
    	
        if(start == end) {
            List<Integer> result = new ArrayList<Integer>();
            for (int num : nums) {
                result.add(num);
            }
            results.add(result);
        } else {
            for(int i = start; i <= end; i++) {
                nums = swap(nums, start, i);
                permuteRecursion(results, nums, start + 1, end);
                nums = swap(nums, start, i);
            }
        }
    }
    
    public int[] swap(int[] nums, int first, int second) {
        int c = nums[first];
        nums[first] = nums[second];
        nums[second] = c;
        
        return nums;
    }
    
    public static void main(String [] s) {
    	int [] nums = {1,2,3,4};
    	
    	List<List<Integer>> res = new FacebookInterview().permute(nums);
    	
    	
    	ArrayList[] arr = res.toArray(new ArrayList [0]);
    	
    	String str = Arrays.deepToString(arr);
    	
    	System.out.println(str);
    	System.out.println(arr.length);
    }
	
}
