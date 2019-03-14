package com.tanvir.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Amazon {
	public static void main(String[] s) {
		// List<Integer> list = new ArrayList<>();
		// for (int i = 0; i < 79; i++) {
		// list.add(i);
		// }
		//
		// System.out.println(new Amazon().size(list));

		// int [] arr = {6,0,8,2,1,5};
		// Amazon a = new Amazon();
		//
		// System.out.println(a.maxWidthRamp(arr));

		// int[] arr = { 0, 1 , 2, 3, 4, 5, 6, 7, 8};

		// changeArray(arr);
		//
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + " ");
		// }

		// Amazon a = new Amazon();
		// Integer [] arr = {1, 2, 3, 4};
		//
		// List<Integer[]> res = a.subset(arr);
		//
		// System.out.println(res.size());

		// List<Integer> list = Arrays.asList(arr);
		//
		// for(List<Integer> l : a.subset(list)) {
		// System.out.print("[");
		// for(int num : l) {
		// System.out.print(num + " ");
		// }
		// System.out.println("]");
		// }

		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		Amazon a = new Amazon();

		sort012(arr);
		System.out.println(arr);
	}

	static void sort012(int a[]) {
		int lo = 0;
		int hi = a.length - 1;
		int mid = 0;
		while (mid <= hi) {
			int aMid = a[mid];
			switch (aMid) {
			case 0: {
				swap(a, lo, mid);
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				swap(a, mid, hi);
				hi--;
				break;
			}
			}
		}
	}

	public int partition2(int[] arr) {
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

	public int partition(int[] A) {
		int n = A.length;
		int q = -1;
		for (int i = 0; i < n; i++) {
			if (A[i] > 0) {
				q++;
				swap(A, q, i);
			}
		}
		return q;
	}

	public List<List<Integer>> subset(List<Integer> list) {
		List<List<Integer>> res = new ArrayList<>();

		subset(list, new ArrayList<>(), 0, res);

		return res;
	}

	private void subset(List<Integer> arr, List<Integer> tempArr, int index, List<List<Integer>> res) {
		if (index == arr.size()) {
			res.add(new ArrayList<>(tempArr));
			return;
		}

		tempArr.add(arr.get(index));
		subset(arr, tempArr, index + 1, res);

		tempArr.remove(tempArr.size() - 1);
		subset(arr, tempArr, index + 1, res);
	}

	public List<Integer[]> subset(int[] arr) {
		List<Integer[]> res = new ArrayList<>();
		Integer[] tempArr = new Integer[arr.length];
		subset(arr, tempArr, 0, res);

		return res;
	}

	private void subset(int[] arr, Integer[] tempArr, int index, List<Integer[]> res) {
		if (index == arr.length) {
			res.add(tempArr.clone());
			return;
		}

		tempArr[index] = 0;
		subset(arr, tempArr, index + 1, res);

		tempArr[index] = 1;
		subset(arr, tempArr, index + 1, res);
	}

	public static void changeArray(int[] arr) {
		if (arr == null || arr.length <= 2) {
			return;
		}

		int len = arr.length;

		int mid = len / 2;
		for (int i = 0; i < len / 2 - 1; i++) {
			int count = i + 1;
			int start = mid - (i + 1);
			while (--count >= 0) {
				swap(arr, start, start + 1);
				start += 2;
			}

			if (count == mid) {
				break;
			}

		}
	}

	private static void swap(int[] arr, int x, int y) {
		if (x == y) {
			return;
		}

		arr[x] ^= arr[y];
		arr[y] ^= arr[x];
		arr[x] ^= arr[y];
	}

	int size(List<Integer> a) {
		int size = 1;

		int curSize = 0;

		while (true) {

			try {
				a.get(size - 1);
				curSize = size;
				size *= 2;
			} catch (Exception e) {
				size = curSize + (size - curSize) / 2;
			}

			if (size == curSize) {
				break;
			}
		}

		return size;
	}
}
