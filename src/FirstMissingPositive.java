
public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3 };

		FirstMissingPositive f = new FirstMissingPositive();

		System.out.println(f.firstMissingPositive(arr));
	}

	public int firstMissingPositive(int[] A) {
		int n = A.length;
		if (n == 0)
			return 1;
		int k = partition(A) + 1;
		int temp = 0;
		int first_missing_Index = k;
		for (int i = 0; i < k; i++) {
			temp = Math.abs(A[i]);
			if (temp <= k)
				A[temp - 1] = (A[temp - 1] < 0) ? A[temp - 1] : -A[temp - 1];
		}
		for (int i = 0; i < k; i++) {
			if (A[i] > 0) {
				first_missing_Index = i;
				break;
			}
		}
		return first_missing_Index + 1;
	}

	public int partition(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			while (left < right && arr[left] >= 0) {
				left++;
			}

			while (left < right && arr[right] < 0) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(arr, left, right);
			left++;
			right--;
		}

		return left;
	}

	private void swap(int[] arr, int x, int y) {
		if (x == y) {
			return;
		}

		arr[x] ^= arr[y];
		arr[y] ^= arr[x];
		arr[x] ^= arr[y];
	}
}
