//https://leetcode.com/problems/minimum-size-subarray-sum/description/

// Given an array of n positive integers and a positive integer s, 
// find the minimal length of a contiguous subarray of which the sum >= s. If there isn't one, return 0 instead.

// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.

public class _MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] arr = { 2, 0, 0, 1, 0, 0 };

		_MinimumSizeSubarraySum ms = new _MinimumSizeSubarraySum();

		System.out.println(ms.minSubArrayLen(4, arr));
	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		
		int left = 0, right = 0, min = Integer.MAX_VALUE, sum = nums[0];
		
		while (right < nums.length) {
			if (sum < s) {
				right++;
				if (right == nums.length)
					break;
				sum += nums[right];
			} else {
				min = Math.min(min, right - left + 1);
				left++;
				sum -= nums[left - 1];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

}
