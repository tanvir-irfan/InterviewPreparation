
public class _SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = {{1},{0}};
		_SetMatrixZero smz = new _SetMatrixZero();
		
		smz.setZeroes(matrix);
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

public void setZeroes(int[][] matrix) {
        
        boolean rFlag = false;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                rFlag = true;
                break;
            }
        }
        
        boolean cFlag = false;
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                cFlag = true;
                break;
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if( matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        
        
        if(rFlag) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if(cFlag) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
	
}
