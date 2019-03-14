import java.util.ArrayList;
import java.util.List;
public class _Permutation {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4};
		
		_Permutation p = new _Permutation();
		
		List<List<Integer>> res = p.permute(arr);
		
		System.out.println(res);
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        permuteHelper(nums, 0, nums.length - 1, res);
        
        return res;
    }
	
	private void permuteHelper (int [] nums, int start, int end, List<List<Integer>> res) {
        if(start == end) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            
            res.add(temp);
            return;
        }
        
        for(int i = start; i <= end; i++) {
            swap(nums, start, i);
            permuteHelper(nums, start + 1, end, res);
            swap(nums, start, i);
        }
    }
    
    private void swap (int [] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
	///////////////////////////////////////////////////////////////////////////
	
	private static ArrayList< String > permutation(String str) {
		ArrayList<String> res = new ArrayList<String>();
		permutation("", str, res);
		return res;
	}
	
	private static void permutation(String pre, String suf, ArrayList<String> res) {
		if(suf.isEmpty()) {
			res.add(pre);
			return;
		}
		
		for(int i = 0; i < suf.length(); i++) {
			String preT = pre + suf.charAt(i);
			String sufT = suf.substring(0, i) + suf.substring(i+1);
			permutation(preT,sufT,res);
		}
	}
}
