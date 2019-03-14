//https://leetcode.com/problems/maximum-subarray/description/

public class _MaximumSubarray {
	// Function to find contiguous sub-array with the largest sum
	// in given set of integers
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxUntilNow = nums[0];
        int actualMax = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            maxUntilNow = Math.max(maxUntilNow + nums[i], nums[i]);
            actualMax = Math.max(maxUntilNow, actualMax);
        }
        
        return actualMax;
    }
	
	public static void main(String [] s) {
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new _MaximumSubarray().maxSubArray(nums));
	}
}
