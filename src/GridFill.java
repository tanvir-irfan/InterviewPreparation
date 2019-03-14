import java.util.ArrayList;
import java.util.LinkedList;

public class GridFill {
	enum SPACE {EMPTY(0), WALL(-2), GATE(-3);
		private final int value;
	    private SPACE(int value) {
	        this.value = value;
	    }
	
	    public int getValue() {
	        return value;
	    }
    }
	
	public static void main(String[] args) {
		int [][] board = 	{{-3,-2,0,0,0},
							{-2,-3,-3,0,0},
							{0,0,0,0,0},
							{0,-2,0,0,0},
							{0,0,-3,0,0}};
		
		board = new GridFill().fillBoard(board);
		
		System.out.println("hello");
	}
	
	private int [][]board;
	SPACE gate = SPACE.GATE;
	SPACE wall = SPACE.WALL;
	
	public int[][] fillBoard(int [][] board) {
		this.board = board;
		
		
		ArrayList<Integer> gateCells = new ArrayList<>();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == gate.getValue()) {
					gateCells.add(convertRCToCell(i, j));
				}
				if(board[i][j] != wall.value && board[i][j] != gate.value) {
					board[i][j] = 9;//Integer.MAX_VALUE;
				}
			}
		}
		
		boolean [][] visited;// = new boolean [board.length][board[0].length];
		for(int cell : gateCells) {
			visited = new boolean [board.length][board[0].length];
			BFS(board, visited, cell);
			int[] rc = convertCellToRC(cell);
			board[rc[0]][rc[1]] = gate.value;
		}
		
		printBoard(0);
		
		return board;
	}
	
	private void BFS(int[][] board, boolean [][] visited, int gateCell) {
		int [] rc = convertCellToRC(gateCell);
		
		LinkedList<Integer> q = new LinkedList<>();
		
		visited[rc[0]][rc[1]] = true;
		
		int distance = 0;
		
		//addNeighbours(board, visited, q, gateCell);
		q.addLast(gateCell);
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int curCell = (int)q.removeFirst();
				// update cell;
				rc = convertCellToRC(curCell);
				if(board[rc[0]][rc[1]] > distance)
					board[rc[0]][rc[1]] = distance;
				addNeighbours(board, visited, q, curCell);
			}
			
			distance++;
		}
		
	}
	
	private void printBoard(int distance) {
		System.out.println("distance = " + distance);
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private void addNeighbours(int [][] board, boolean [][] visited, LinkedList<Integer> q, int cell) {
		
		int [] rc = convertCellToRC(cell);
		
		// add all valid cell to q
		int [] x = {-1, 0, 1, 0};
		int [] y = {0, 1, 0, -1};
		
		for(int j = 0; j < 4; j++) {
			int nextR = rc[0] + x[j];
			int nextC = rc[1] + y[j];
			
			int nextCell = convertRCToCell(nextR, nextC);
			
			if(!isValid(board, visited, nextR, nextC)) {
				continue;
			}
			
			visited[nextR][nextC] = true;
			q.add(nextCell);
		}
	}
	
	public boolean isValidCell(int [][] board, boolean [][] visited, int r, int c) {
		return r >= 0 && r < board.length 
				&& c >= 0 && c < board.length 
				&& !visited[r][c];
	}
	
	public boolean isValid(int [][] board, boolean [][] visited,int r, int c) {
		return isValidCell(board, visited, r, c) 
				//&& board[r][c] != gate.getValue()
				&& board[r][c] != wall.getValue();
	}
	
	public int convertRCToCell (int i, int j) {
		return board.length * i + j;
	}
	
	public int[] convertCellToRC(int cell) {
		int [] rc = new int[2];
		rc[0] = cell / board.length;
		rc[1] = cell % board.length;
		
		return rc;
	}
}
