
public class IslandCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    BFS(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void BFS(char [][] grid, boolean [][] visited, int i, int j) {
        if(!isValid(grid, visited, i, j)) {
            return;
        }
        visited[i][j] = true;
        int [] x = {0, -1, 0, 1};
        int [] y = {-1, 0, 1, 0};
        
        for(int k = 0; k < 4; k++) {
            BFS(grid, visited, i + x[k], j + y[k]);
        }
    }
    
    private boolean isValid (char [][] grid, boolean [][] visited, int i, int j ) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid [i][j] == '1' && visited[i][j] == false;
    }
}
