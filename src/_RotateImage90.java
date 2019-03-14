//https://leetcode.com/problems/rotate-image/description/
public class _RotateImage90 {
	public void rotate(int[][] matrix) {
        rotate(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    public void rotate(int[][] matrix, int iS, int jS, int iE, int jE) {

        // only needs to check one to end the loop.
        while(iS < iE) {

            swapTopToRight(matrix, iS, jS, iE, jE);
            swapTopToBottom(matrix, iS, jS, iE, jE);
            swapTopToToLeft(matrix, iS, jS, iE, jE);

            swap(matrix, iS, jS, iS, jE);
            swap(matrix, iS, jS, iE, jE);
            swap(matrix, iS, jS, iE, jS);

            iS++;
            jS++;
            iE--;
            jE--;
        }
    }

    private void swapTopToRight(int[][] matrix, int iS, int jS, int iE, int jE) {
        for(int i = 1; i <= iE - iS - 1; i++) {
            swap(matrix, iS, jS + i, iS + i, jE);
        }
    }

    private void swapTopToBottom(int[][] matrix, int iS, int jS, int iE, int jE) {
        for(int i = 1; i <= iE - iS - 1; i++) {
            swap(matrix, iS, jS + i, iE, jE - i);
        }
    }

    private void swapTopToToLeft(int[][] matrix, int iS, int jS, int iE, int jE) {
        for(int i = 1; i <= iE - iS - 1; i++) {
            swap(matrix, iS, jS + i, iE - i, jS);
        }
    }

    private void swap (int [][] matrix, int iS, int jS, int iE, int jE) {
        int temp = matrix[iS][jS];
        matrix[iS][jS] = matrix[iE][jE];
        matrix[iE][jE] = temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] matrix = {{1,2},{3,4}};
		
		_RotateImage90 r = new _RotateImage90();
		r.rotate(matrix);
		System.out.println("Hello");
		
	}

}
