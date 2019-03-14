import java.util.ArrayList;
import java.util.List;

public class GCD {
	public static void main(String[] s) {
		int[] nums = { 1, 0, 0, 0, 0, 1, 0, 0 };

		System.out.println(new GCD().add(15, 5));
	}

	int add(int x, int y) {
		// Iterate till there is no carry
		while (x != 0) {
			// carry now contains common
			// set bits of x and y
			int carry = x & y;

			// Sum of bits of x and y where at
			// least one of the bits is not set
			y = x ^ y;

			// Carry is shifted by one so that adding
			// it to x gives the required sum
			x = carry << 1;
		}
		return y;
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public int generalizedGCD(int num, int[] arr) {
		// WRITE YOUR CODE HERE
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		for (int i = max / 2; i >= 2; i--) {
			if (isGCD(arr, i)) {
				return i;
			}
		}

		return 1;
	}

	private boolean isGCD(int[] nums, int i) {
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] % i != 0) {
				return false;
			}
		}
		return true;
	}
	// METHOD SIGNATURE ENDS

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<Integer> cellCompete(int[] states, int days) {
		// WRITE YOUR CODE HERE
		for (int i = 0; i < days; i++) {
			int[] temp = copy(states);

			for (int j = 0; j < 8; j++) {
				states[j] = temp[j] ^ temp[j + 2];
			}

		}

		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			res.add(states[i]);
		}

		return res;
	}

	private int[] copy(int[] ori) {
		int[] res = new int[10];

		for (int i = 0; i < 8; i++) {
			res[i + 1] = ori[i];
		}
		return res;
	}
	// METHOD SIGNATURE ENDS
}
