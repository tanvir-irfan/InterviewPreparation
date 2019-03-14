import java.util.*;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		
		int M = 0b11101111101;
		int N = 0b11111;
		int i = 6; 
		int j = 2;
		
		N = N << j;
		
		int maskForM = (int)Math.pow(2, (i - j + 1)) - 1;		
		System.out.println(Integer.toBinaryString(maskForM));
		maskForM = maskForM << j;
		System.out.println(Integer.toBinaryString(maskForM));
		maskForM = ~maskForM;
		System.out.println(Integer.toBinaryString(maskForM));
		
		M = M & maskForM;
		System.out.println(Integer.toBinaryString(M));
		
		M = M | N;
		System.out.println(Integer.toBinaryString(M));
		
	}

	static ArrayList<List<Integer>> twoSumWithSorting(int[] nums, int target) {

		Arrays.sort(nums);
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> pair = twoSumWithSortingFromIndex(nums, target, i);
			if (pair.size() == 2)
				res.add(pair);
		}

		return res;
	}

	static ArrayList<Integer> twoSumWithSortingFromIndex(int[] nums, int target, int index) {
		ArrayList<Integer> pair = new ArrayList<Integer>();
		int numToFind = target - nums[index];

		int left = index + 1;
		int right = nums.length - 1;
		int mid = 0;
		boolean isFound = false;
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == numToFind) {
				isFound = true;
				break;
			} else if (nums[mid] > numToFind) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (isFound) {
			pair.add(nums[index]);
			pair.add(nums[mid]);
		}
		return pair;
	}

	static int[] getArrayInput() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		int[] nums = new int[count];

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		return nums;

	}

	static int[] increment(int[] input) throws Exception {

		if (input == null || input.length == 0)
			throw new Exception("Not a valid representation");

		int carry = 1;
		int i;

		for (i = input.length - 1; i >= 0; i--) {
			if (input[i] > 9 && input[i] < 0)
				throw new Exception("Not a valid representation");
			int sum = input[i] + carry;

			input[i] = sum % 10;
			carry = sum / 10;

			if (carry == 0)
				break;
		}

		int[] ret;

		if (i < 0 && carry != 0) {
			ret = new int[input.length + 1];
			ret[0] = 1;
			return ret;
		}

		return input;
	}

}
