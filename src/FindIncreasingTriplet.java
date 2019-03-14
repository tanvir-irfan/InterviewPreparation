
public class FindIncreasingTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 0, 1, 2, 3, 4, 5, 6, 7, 9 };

		swap(nums, 1, 1);

		System.out.println("Hello");
	}

	public static void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public int[] findIncreasingValues(int[] input) {
		// We're going to keep track of the best values we've found so far for i
		// and j.
		int i = -1;
		int j = -1;
		// We're also going to keep track of a candidate that's "better" (smaller) than i,
		// which we'll use as i once we've found a new value for j as well.
		int temp = -1;
		for (int cur = 0; cur < input.length; cur++) {
			if (i == -1) {
				// Start by setting i to be the first value in the array.
				i = cur;
			} else if (j == -1) {
				if (input[cur] < input[i]) {
					// Suppose the array begins [5, 3, ...]. In this case we have nothing to
					// lose and everything to gain by updating i to point at the 3 instead of
					// the 5: it will be easier to find j and k that satisfy our requirement,
					// and this cannot eliminate a possible solution.
					i = cur;
				} else {
					// Otherwise, if the array begins [5, 8, ...], then just take the second
					// value as our candidate for j.
					j = cur;
				}
			} else if (input[cur] > input[j]) {
				// We're done! Just return the result.
				return new int[] { i, j, cur };
			} else if (input[cur] < input[j]) {
				// Suppose we see an array like [5, 8, 3, ...]. What should we do with that 3?
				// We'd like to make that position our new i, because it will be easier to find
				// other elements greater than 3 instead of elements greater than 8, but here
				// we have a problem: we might be throwing away the only valid solution if we
				// do that. For example, if the array is [5, 8, 3, 10], the only solution is
				// (5, 8, 10) -- so we can't use the 3. But if the array is [5, 8, 3, 4, ...]
				// then we should take (i, j) to be (3, 4) since this will be easier to find k
				// for than our old (i, j) of (5, 8). So what we do here is that when we see the 3, 
				// we put it into temp initially,  and we only promote it to be the new value of i 
				// once we've found a corresponding new value for j as well.
				if (temp == -1) {
					// We don't have a saved candidate for i, so just remember this number for now.
					temp = cur;
				} else {
					if (input[cur] > input[temp]) {
						// We have new candidates for both i and j, so update them.
						i = temp;
						j = cur;
						temp = -1;
					} else if (input[cur] < input[temp]) {
						// Suppose we see [5, 8, 3, 2, ...]. In this case we should forget about
						// the 3 and take the 2 to be our new candidate value for i, since it is
						// strictly better (easier to find j and k for), so we just update temp.
						temp = cur;
					}
				}
			}
		}
		// If we make it to the end of the loop over the array without returning anything,
		// then we've failed to find a solution, so just return some sort of special value
		// indicating there's no solution.
		return new int[] { -1, -1, -1 };
	}

}
