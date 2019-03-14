
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {
		        47,31, 48, 33, 21, 20, 18, 45, 28, 47, 54, 41, 28, 47, 44, 
		        51, 15, 21, 64, 82, 23, 41, 82, 30, 25, 78, 72, 50, 34, 45, 59, 14, 71, 50, 97, 
		        39, 87, 74, 60, 52, 17, 87, 45, 69, 54, 91, 68, 46, 99, 78, 33, 27, 53, 41, 84, 
		        82, 54, 29, 55, 53, 87, 13, 98, 55, 33, 73, 64, 19, 81, 57, 78, 23, 45, 94, 75, 
		        55, 43, 93, 85, 96, 82, 44, 73, 22, 79, 89, 20, 36, 11, 12, 51, 86, 86, 75, 66, 
		        81, 90, 80, 80, 36, 36, 47, 43, 86, 96, 45, 73, 70, 90, 57, 23, 86, 29, 12, 54, 
		        37, 17, 87, 12, 36, 78, 26, 28, 30, 15, 10, 53, 76, 34, 23, 49, 65, 17, 37, 51, 
		        26, 23, 66, 12, 26, 84, 60, 47, 30, 26, 78, 20, 42, 40, 63, 40, 10, 37, 74, 99, 
		        86, 28, 17, 39, 18, 38, 70, 89, 94, 32, 46, 76, 43, 33, 62, 76  };

		long start = System.currentTimeMillis();
		int res[] = new MergeSort().mergeSort(arr);
		long end = System.currentTimeMillis();
		System.out.println("Sorted " + res.length + " items in " + (end - start) + " miliseconds");
	}

	public int[] mergeSort(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	private int[] mergeSort(int[] arr, int start, int end) {
		if (start == end) {
			int [] temp = new int[1];
			temp[0] =  arr[start];
			return temp;
		}

		int mid = start + (end - start) / 2;

		int[] firstHalf = mergeSort(arr, start, mid);
		int[] secondHalf = mergeSort(arr, mid + 1, end);

		int[] res = merge(firstHalf, secondHalf);

		return res;
	}

	private int[] merge(int[] firstHalf, int[] secondHalf) {
		int[] res = new int[firstHalf.length + secondHalf.length];

		int k = res.length - 1;

		int i = firstHalf.length - 1;
		int j = secondHalf.length - 1;

		while (k >= 0 && i >= 0 && j >= 0) {
			if (secondHalf[j] >= firstHalf[i]) {
				res[k] = secondHalf[j];
				j--;
			} else {
				res[k] = firstHalf[i];
				i--;
			}
			k--;
		}

		while (i >= 0) {
			res[k--] = firstHalf[i--];
		}

		while (j >= 0) {
			res[k--] = secondHalf[j--];
		}

		return res;
	}
}
