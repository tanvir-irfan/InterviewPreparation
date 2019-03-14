import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MedianOfMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();

		int[][] arr = { { 9, 9, 9 }, { 9, 9, 9 }, { 9, 9, 9 } };

		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < arr[0].length; j++) {
				temp.add(arr[i][j]);
			}

			A.add(temp);
		}

		MedianOfMatrix m = new MedianOfMatrix();

		int res = m.findMedian(A);

		System.out.println(res);
	}

	public int findMedian(ArrayList<ArrayList<Integer>> A) {

		if (A == null || A.size() == 0)
			return 0;

		int row = A.size();
		int col = A.get(0).size();

		int cntSmaller = 0, cntRequired = (row * col) / 2;

		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;

		for (int i = 0; i < row; i++) {
			if (A.get(i).get(col - 1) > high) {
				high = A.get(i).get(col - 1);
			}
		}
		for (int i = 0; i < row; i++) {
			if (A.get(i).get(0) < low) {
				low = A.get(i).get(0);
			}
		}

		int mid = 0;
		int pos = 0, ans = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			cntSmaller = 0;

			for (int i = 0; i < row; i++) {
				pos = binarySearch(A.get(i), mid);
				cntSmaller += pos;
			}

			if (cntSmaller < cntRequired + 1)
				low = mid + 1;
			else {
				ans = mid;
				high = mid - 1;
			}
		}
		return ans;
	}

	public int binarySearch(ArrayList<Integer> A, int n) {
		if (A == null)
			return -1;

		if (A.get(0) > n)
			return 0;

		int low, mid, high;

		low = 0;
		mid = 0;
		high = A.size() - 1;

		while (low <= high) {
			mid = (low + high) / 2;

			if (A.get(mid) > n)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

}
