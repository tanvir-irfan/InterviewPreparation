
public class Matrix01 {
	
	int r, c;
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        
        r = matrix.length;
        c = matrix[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
            	System.out.println("[ " + i + " , " + j + " ] = " + matrix[i][j]);
                boolean [][] v = new boolean[r][c];
                matrix[i][j] = DFS(matrix, v, i, j, 0);
                System.out.println("[ " + i + " , " + j + " ] = " + matrix[i][j]);
            }
        }
        
        return matrix;
    }
    
    private int DFS(int[][] m, boolean [][] v, int i, int j, int dist) {
        if(m[i][j] == 0) {
            return dist;
        }
        
        v[i][j] = true;
        
        int [] x = {-1, 0, 1, 0};
        int [] y = {0, 1, 0, -1};
        
        int res [] = new int[4];
        
        for(int k = 0; k <= 3; k++) {
            if(isValid(i + x[k], j + y[k], v)) {
                res[k] = DFS(m, v, i + x[k], j + y[k], dist + 1);
            } else {
                res[k] = Integer.MAX_VALUE;
            }
        }
        
        int min = res[0];
        for(int k = 1; k <= 3; k++) {
            if(min > res[k]) {
                min = res[k];
            }
        }
        
        return min;
    }
    
    private boolean isValid(int i, int j, boolean[][] v) {
        if(i < 0 || i >= r || j < 0 || j >= c || v[i][j]) {
            return false;
        }
        
        v[i][j] = true;
        
        return true;
    }
    
	public static void main(String[] args) {
		int [][] nums = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
		
		Matrix01 m = new Matrix01();
		
		m.updateMatrix(nums);
		
		for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[0].length; j++) {
            	System.out.print(nums[i][j] + "  ");
            }
            System.out.println();
        }
		
		
	}

}
