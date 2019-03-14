import java.util.Arrays;

public class MatrixProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = {{-1,2,3},
							{4,5,-6},
							{7,8,9}};
		
		long res = MatrixProduct.matrixSumOfProd(matrix);
		
		System.out.println(res);
	}
	
	public static long matrixSumOfProd(int [][] matrix) {
		
		// [1 2 3]		[1  2 6]		[1  2 6]
		// [4 5 6]		[4  0 0]		[4  0 0]
		// [7 8 9]		[28 0 0]		[28 0 0]
		
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		long[][] maxCache = new long[matrix.length][matrix[0].length];
		long[][] minCache = new long[matrix.length][matrix[0].length];
		
		maxCache[0][0] = matrix[0][0];
		minCache[0][0] = matrix[0][0];
		
		
		for(int i = 1; i < matrix[0].length; i++) {
			long valFromMax = matrix[0][i] * maxCache[0][i - 1];
			long valFromMin = matrix[0][i] * minCache[0][i - 1];
			
			maxCache[0][i] = Math.max(valFromMax, valFromMin);
			minCache[0][i] = Math.min(valFromMax, valFromMin);
		}
		
		for(int i = 1; i < matrix.length; i++) {
			long valFromMax = matrix[i][0] * maxCache[i-1][0];
			long valFromMin = matrix[i][0] * minCache[i-1][0];
			
			maxCache[i][0] = Math.max(valFromMax, valFromMin);
			minCache[i][0] = Math.min(valFromMax, valFromMin);
		}
		
		
		for(int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				
				
				long maxLeft = matrix[i][j] * maxCache[i][j - 1];
				long maxUp = matrix[i][j] * maxCache[i - 1][j];
				
				long minLeft = matrix[i][j] * minCache[i][j - 1];
				long minUp = matrix[i][j] * minCache[i - 1][j];
				
				
	            long [] allNums = {maxLeft, maxUp, minLeft, minUp};
	            
	            Arrays.sort(allNums);
	            
	            maxCache[i][j] = allNums[3];
	            minCache[i][j] = allNums[0];
			}
		}
		
		return maxCache[maxCache.length - 1][maxCache[0].length -1];
	}

}
