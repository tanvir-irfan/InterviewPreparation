
public class DeleteDistance {

	public static void main(String[] args) {
		// int res = deleteDistance("sloughs",
		// "thought");
		// System.out.println(res);

		int[] A = { 0, 0, 0, 1, 0, 1, 1, 0 };
		int K = 3;
		
		System.out.println(minKBitFlips(A,K));
	}

	public static int minKBitFlips(int[] A, int K) {
		int N = A.length;
		int[] hint = new int[N];
		int ans = 0, flip = 0;

		// When we flip a subarray like A[i], A[i+1], ..., A[i+K-1]
		// we can instead flip our current writing state, and put a hint at
		// position i+K to flip back our writing state.
		for (int i = 0; i < N; ++i) {
			flip ^= hint[i];
			if (A[i] == flip) { // If we must flip the subarray starting here...
				ans++; // We're flipping the subarray from A[i] to A[i+K-1]
				if (i + K > N)
					return -1; // If we can't flip the entire subarray, its
								// impossible
				flip ^= 1;
				if (i + K < N)
					hint[i + K] ^= 1;
			}
		}

		return ans;
	}

	public static int almost_palindromes(String str) {
		int count = 0;

		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			char left = str.charAt(i);
			char right = str.charAt(len - 1 - i);

			if (left != right) {
				count += 2;
			}
		}

		return count;
	}

	public static int four_letter_words(String sentence) {
		if (sentence == null || sentence.length() < 4) {
			return 0;
		}

		String[] allWords = sentence.split("\\s");

		int res = 0;

		for (int i = 0; i < allWords.length; i++) {
			if (allWords[i].length() == 4) {
				res++;
			}
		}

		return res;
	}

	public static int deleteDistance(String a, String b) {

		int[][] memory = new int[a.length() + 1][b.length() + 1];

		memory[0][0] = 0;

		for (int i = 1; i <= b.length(); i++) {
			System.out.println(b.charAt(i - 1) + " : " + (int) b.charAt(i - 1));
			memory[0][i] = memory[0][i - 1] + (int) b.charAt(i - 1);
		}

		for (int i = 1; i <= a.length(); i++) {
			System.out.println(a.charAt(i - 1) + " : " + (int) a.charAt(i - 1));
			memory[i][0] = memory[i - 1][0] + (int) a.charAt(i - 1);
		}

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				char aC = a.charAt(i - 1);
				char bC = b.charAt(j - 1);

				if (aC == bC) {
					memory[i][j] = memory[i - 1][j - 1];
				} else {
					// delete one character from string a
					int left = bC + memory[i][j - 1];

					// delete one character from string b
					int up = aC + memory[i - 1][j];

					// delete one character from both string a and b
					int leftUp = aC + bC + memory[i - 1][j - 1];

					// take the minimum of all the costs
					memory[i][j] = Math.min(Math.min(left, leftUp), Math.min(up, left));
				}
			}
		}

		return memory[a.length()][b.length()];
	}
}
