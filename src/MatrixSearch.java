
public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean matrixSearch(int [][] matrix, int num) {
		boolean res = false;
		int [] ind = {0, 0, matrix.length - 1, matrix.length - 1};
		
		while(true) {
			if(matrix[ind[0]] [ind[2]] == num) {
				res = true;
				break;
			}
//			while(matrix[ind[0]][ind[2]] < )
		}
		return res;
	}

}
