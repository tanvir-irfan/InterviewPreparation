/**
 * Reference: https://www.youtube.com/watch?v=8hHWpuAPBHo
 */


import java.util.concurrent.ThreadLocalRandom;

public class QuickSortAlgorithm {

	public static <T extends Comparable<T>>
	void quickSort(T [] arr) {
		if( arr.length <= 1) return;

		sort(arr, 0, arr.length-1);
	}

	private static <T extends Comparable<T>> 
	void sort(T [] arr, int lo, int hi) {
		if(hi - lo <= 0) return;

		int splitPoint = split(arr, lo, hi);

		sort(arr, lo, splitPoint -1);
		sort(arr, splitPoint + 1, hi);
	}

	private static <T extends Comparable<T>>
	int split(T [] arr, int lo, int hi) {

		int left = lo + 1;
		int right = hi;
		T pivot = arr[lo];

		while(true) {

			// increase left pointer until we found an element that bigger than pivot
			while(left <= right) {
				if(arr[left].compareTo(pivot) < 0) left++;
				else break;
			}
			// decrease right pointer until we found an element that smaller	 than pivot
			while (right > left) {
				if(arr[right].compareTo(pivot) > 0) right--;
				else break;
			}

			if(left >= right) {
				break;
			}

			// swap left and right position
			T temp = arr[left];
			arr [left] = arr [right];
			arr[left] = temp;

			// advance the left and right pointer
			left++;
			right--;
		}

		//swap the pivot with left-1
		arr[lo] = arr[left -1];
		arr[left-1] = pivot;
		return left-1;
	}

	public static <T extends Comparable<T>>
	void printArray(T [] arr, String msg) {
		if(msg != null)
			System.out.println(msg);
		for(T e : arr) {
			System.out.print (e + " ");
		}
		System.out.println();
	}

	private static int getRandomInteger(int min, int max) {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}


	public static void main(String[] s) {
		int arrLen = 20;
		Integer [] arr = new Integer[arrLen];

		for(int i = 0; i < arrLen; i++) {
			arr[i] = getRandomInteger(1, 1000);
		}

		printArray(arr, "Before");
		QuickSortAlgorithm.quickSort(arr);
		printArray(arr, "After");
	}
}
