
/*package whatever //do not write package name here */

import java.util.HashMap;
import java.util.LinkedList;

class _RottenOranges {
	public static void main(String[] str) {
		int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		_RottenOranges ro = new _RottenOranges();
		
		System.out.println(ro.orangesRotting(grid));
	}

	public int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		LinkedList<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> memory = new HashMap<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					int cell = rc2Cell(grid, i, j);
					q.addLast(cell);
					memory.put(cell, 0);
				}
			}
		}

		int ans = 0;

		while (!q.isEmpty()) {
			int curCell = q.removeFirst();
			int[] curRc = cell2RC(grid, curCell);

			int distance = memory.get(curCell);

			int[] dx = { -1, 0, 1, 0 };
			int[] dy = { 0, 1, 0, -1 };

			for (int d = 0; d < 4; d++) {
				int newR = curRc[0] + dx[d];
				int newC = curRc[1] + dy[d];

				if (isValid(grid, newR, newC)) {
					grid[newR][newC] = 2;

					int newCell = rc2Cell(grid, newR, newC);
					memory.put(newCell, distance + 1);
					q.addLast(newCell);
					ans = memory.get(newCell);
				}
			}
		}

		for (int[] row : grid)
			for (int v : row)
				if (v == 1)
					return -1;
		return ans;
	}

	private int rc2Cell(int[][] grid, int r, int c) {
		return r * grid[0].length + c;
	}

	private int[] cell2RC(int[][] grid, int cell) {
		int[] RC = new int[2];
		RC[0] = cell / grid[0].length;
		RC[1] = cell % grid[0].length;
		return RC;
	}

	private boolean isValid(int[][] grid, int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1;
	}

}