import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _LongestIncreasingSubSequence {

	public static void main(String[] args) {
		_LongestIncreasingSubSequence liss = new _LongestIncreasingSubSequence();

		int[] res = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 100 };

		int[] test = new int[10];

		for (int i = 0; i < res.length; i++) {
			test[i] = i * 2;
		}

		for (int i = 0; i < res.length; i++) {
			System.out.print(test[i] + " ");
		}

		System.out.println();

		for (int i = -5; i < 20; i++) {
			int index = Arrays.binarySearch(test, i);

			System.out.println("key = " + i + "\tindex = " + index);
		}

	}

	public int lengthOfLIS(int[] nums) {
		List<Integer> piles = new ArrayList<>(nums.length);
		for (int num : nums) {
			int pile = Collections.binarySearch(piles, num);
			if (pile < 0)
				pile = ~pile;
			if (pile == piles.size()) {
				piles.add(num);
			} else {
				piles.set(pile, num);
			}
		}
		return piles.size();
	}

	public int lengthOfLIS_N_SQR(int[] nums) {

		if (nums == null || nums.length < 1) {
			return 0;
		}

		int[] res = new int[nums.length];
		Arrays.fill(res, 0, res.length, 1);

		int max = 1;

		for (int i = 1; i < nums.length; i++) {

			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					res[i] = Math.max(res[j] + 1, res[i]);
				}
			}
		}

		for (int i = 0; i < res.length; i++) {
			max = Math.max(max, res[i]);
		}

		return max;
	}

}
