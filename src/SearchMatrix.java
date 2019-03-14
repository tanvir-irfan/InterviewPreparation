
public class SearchMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 3, 5, 7 }, 
						{ 10, 11, 16, 20 }, 
						{ 23, 24, 30, 50 }, 
						{ 25, 26, 34, 51 },
						{ 28, 36, 44, 61 } };

		SearchMatrix sm = new SearchMatrix();

		System.out.println(sm.contains(mat, 26));
	}

	public boolean contains(int[][] arr, int x) {
		if (arr.length == 0 || arr[0].length == 0)
			return false;
		int row = 0;
		int col = arr[0].length - 1;

		while (row < arr.length && col >= 0) {
			if (arr[row][col] == x)
				return true;
			if (  x > arr[row][col] )
				row++;
			else
				col--;
		}

		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return false;
		int row = findRow(matrix, target);
		if (row != -1) {
			int col = findCol(matrix, target, row);

			if (col != -1)
				return true;
			else
				return false;
		} else
			return false;

	}

	public int findCol(int[][] matrix, int target, int row) {
		int col = -1;

		int l = 0;
		int r = matrix[0].length - 1;

		while (l <= r) {
			int mid = (l + r) / 2; // l + (r - l) / 2

			if (target == matrix[row][mid]) {
				return mid;
			} else if (target > matrix[row][mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return col;
	}

	public int findRow(int[][] matrix, int target) {
		int row = -1;

		int l = 0;
		int r = matrix.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2; // l + (r - l) / 2

			if (target < matrix[mid][0]) {
				r = mid - 1;
			} else if (target > matrix[mid][matrix[0].length - 1]) {
				l = mid + 1;
			} else {
				return mid;
			}
		}

		return row;
	}
}
