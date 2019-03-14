
public class RobHouses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 1 };

		int res = RobHouses.rob(nums);
		
		System.out.println(res);
	}

	public static int rob(int[] nums) {

		if(nums == null || nums.length == 0) {
			return 0;
		} else if(nums.length == 1) {
			return nums[0];
		}
		
		int[] res = new int[nums.length];

		res[0] = nums[0];
		res[1] = Math.max( nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
		}

		return res[nums.length - 1];
	}
}
