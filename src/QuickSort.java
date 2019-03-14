

public class QuickSort {

	public static void main(String[] args) {

		int[] nums = { 4, 5, 6, 7, 4, 1, 2, 3 };

		System.out.println(QuickSort.quickPartition(nums, 0, nums.length - 1));
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	private static void quickSort(int[] arr, int left, int right) {

		if (left >= right)
			return;

		int partitionPoint = quickPartition(arr, left, right);

		quickSort(arr, left, partitionPoint - 1);
		quickSort(arr, partitionPoint + 1, right);
	}

	private static int quickPartition(int[] arr, int left, int right) {
		int curLeft = left;
		int curRight = right;
		int pivot = arr[left];
		curLeft += 1;

		while (curLeft <= curRight) {
			while (curLeft <= curRight && arr[curLeft] <= pivot) {
				curLeft += 1;
			}

			while (curRight >= curLeft && arr[curRight] > pivot) {
				curRight -= 1;
			}

			if (curLeft >= curRight) {
				break;
			}
			swap(arr, curLeft, curRight);
			curLeft++;
			curRight--;
		}

		swap(arr, left, curLeft - 1);

		return curLeft - 1;
	}

	private static void swap(int[] a, int i, int j) {
		if (i == j)
			return;
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}

	private static double findMedian(int[] arr) {

		int len = arr.length;
		int index[] = new int[2];
		
		index[0] = findValueAtPosition(arr, 0, len - 1, len / 2);
		if (len % 2 == 0) {
			index[1] = findValueAtPosition(arr, 0, len - 1, len / 2 - 1);
		}

		return (index[0] + index[1]) / 2.;
	}

	private static int findValueAtPosition(int[] arr, int left, int right, int pos) {
		int partition = quickPartition(arr, left, right);
		if (partition == pos) {
			return arr[pos];
		} else if (partition < pos) {
			return findValueAtPosition(arr, partition + 1, right, pos);
		} else {
			return findValueAtPosition(arr, left, partition - 1, pos);
		}
	}

}
