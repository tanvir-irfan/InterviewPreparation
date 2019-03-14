class SudokuValidation {
	
	public static void main(String [] s)  {
		char [] [] board = {{'5','3','.','.','7','.','.','.','.'},
			                {'6','.','.','1','9','5','.','.','.'},
			                {'.','9','8','.','.','.','.','6','.'},
			                {'8','.','.','.','6','.','.','.','3'},
			                {'4','.','.','8','.','3','.','.','1'},
			                {'7','.','.','.','2','.','.','.','6'},
			                {'.','6','.','.','.','.','2','8','.'},
			                {'.','.','.','4','1','9','.','.','5'},
			                {'.','.','.','.','8','.','.','7','9'}};
		
		System.out.println(new SudokuValidation().isValidSudoku(board));
	
	}
	
    public boolean isValidSudoku(char[][] board) {
        return checkRows(board) && checkCols(board) && checkSmallBoards(board);
    }
    
    private boolean checkRows(char [][] board) {
        for(int i = 0; i < 9; i++) {
            if(!checkRow(board, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkRow(char [][] board, int r) {
        int [] check = new int[9];
        
        for(int i = 0; i < 9; i++) {
            if(board[r][i] != '.') {
                int index = board[r][i] - '0';
                check[index-1]++;
            }
        }
        
        return checkFreq(check);
    }
    
    private boolean checkCols(char [][] board) {
        for(int i = 0; i < 9; i++) {
            if(!checkCol(board, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkCol(char [][] board, int c) {
        int [] check = new int[9];
        
        for(int i = 0; i < 9; i++) {
            if(board[i][c] != '.') {
                int index = board[i][c] - '0';
                check[index-1]++;
            }
        }
        
        return checkFreq(check);
    }
    
    private boolean checkSmallBoards(char [][] board) {
        int [] indexR = {0,0,0,3,3,3,6,6,6};
        int [] indexC = {0,3,6,0,3,6,0,3,6};
        
        for(int i = 0; i < 9; i++) {
                            
	        if(!checkSmallBoard(board, indexR[i], indexC[i])) {
	            return false;
	        }
            
        }
        return true;
    }
    
    private boolean checkSmallBoard(char [][] board, int r, int c) {
        int [] check = new int[9];
        
        for(int rO = 0; rO < 3; rO++) {
            for(int cO = 0; cO < 3; cO++) {
                if(board[r + rO][c + cO] != '.') {
                    int index = board[r + rO][c + cO] - '0';
                    check[index-1]++;
                }
            }
        }
        
        return checkFreq(check);
    }
    
    private boolean checkFreq(int [] c) {
        for(int i = 0; i < 9; i++) {
            if(c[i] > 1) 
                return false;
        }
        
        return true;
    }
}