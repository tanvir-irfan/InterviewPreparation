import java.util.List;
import java.util.Arrays;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle pt = new PascalTriangle();

		List<Integer> res = pt.getRow(5);
		System.out.println(res);
	}

	
	// https://leetcode.com/problems/pascals-triangle-ii/description/
	// Given a non-negative index k where k <= 33, return the kth index row of the Pascal's triangle.

	// Note that the row index starts from 0.
	public List<Integer> getRow(int rowIndex) {

        rowIndex++;
        
		Integer[] res = new Integer[rowIndex];

		res[0] = 1;
		if (rowIndex == 1) {
			return Arrays.asList(res);
		}

		int prev = 0, cur = 0;

		for (int i = 2; i <= rowIndex; i++) {

			prev = 1;

			for (int j = 1; j < i; j++) {

				if (j == i - 1) {
					res[j] = 1;
					continue;
				}
				
				cur = res[j];
				
				res[j] = prev + cur;
				prev = cur;
			}
		}

		return Arrays.asList(res);
	}
}
