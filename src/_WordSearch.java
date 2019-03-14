
public class _WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_WordSearch ws = new _WordSearch();
//		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
//		String word = "E";
		char board [][] = {{'A','A'},{'A','A'}};
		String word = "AAAAA";

		System.out.println(ws.exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (exist(board, r, c, w, 0))
					return true;
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int r, int c, char[] word, int i) {
		if (i == word.length)
			return true;
		if (r < 0 || c < 0 || r == board.length || c == board[0].length)
			return false;
		if (board[r][c] != word[i])
			return false;
		board[r][c] ^= 256;
		boolean exist = exist(board, r, c + 1, word, i + 1) || exist(board, r, c - 1, word, i + 1)
				|| exist(board, r + 1, c, word, i + 1) || exist(board, r - 1, c, word, i + 1);
		board[r][c] ^= 256;
		return exist;
	}

}
