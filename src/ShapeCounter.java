import java.util.ArrayList;
import java.util.Arrays;

public class ShapeCounter {
	public void rotate(int[] nums, int k) {
		int[] res = new int[nums.length];

		k %= nums.length;

		int count = 0;
		while (count < nums.length) {
			res[k++] = nums[count++];

			if (k == nums.length) {
				k = 0;
			}
		}

		count = 0;
		for (int a : res) {
			nums[count++] = a;
		}
	}

	private void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] s) {
//		int[] input = { 1, 2, 2, 1 };
//		int[] input1 = { 2, 2 };
//		ShapeCounter sc = new ShapeCounter();
//		int [] res = sc.intersect(input, input1);		
//		sc.printArray(res);
		System.out.println(new ShapeCounter().countPrimes(10));
	}

	public int countPrimes(int n) {
        boolean [] nums = new boolean[n+1];        
        
        int res = 0;
        
        for(int i = 2; i <= n; i++) {
            if(!nums[i]) {
                res++;
                                
                int count = 2;
                int curI = i;

                while( curI * count <= n ) {
                    nums[curI * count] = true;
                    count++;
                }
            }                        
        }                
        
        return res;
    }
	
	public int[] intersect(int[] nums1, int[] nums2) {

		if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
			return new int[0];
		}

		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		ArrayList<Integer> resAL = new ArrayList<>();
		for (int i = 0, j = 0; i < nums1.length; ) {
			if (nums1[i] == nums2[j]) {
				resAL.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}

		int[] res = new int[resAL.size()];
		int count = 0;
		for (int a : resAL) {
			res[count] = resAL.get(count);
			count++;
		}

		return res;
	}
}

// import java.util.LinkedList;
// import java.util.Scanner;
//
// public class ShapeCounter {
//
// public static void main(String[] args) {
// // TODO Auto-generated method stub
// new ShapeCounter().getNumOfShapes();
// }
//
// private static int[] rowDir = { 0, 1, 0, -1 };
// private static int[] colDir = { 1, 0, -1, 0 };
//
// private static final char VISITED = '#';
// private static final char SHAPE_CHAR = 'X';
// private static final char EMPTY_CHAR = 'O';
//
// public int[][] board;
// public int row, col;
//
// private boolean isValidCell(int r, int c) {
// if (r < 0 || r >= row || c < 0 || c >= col)
// return false;
// return true;
// }
//
// private boolean isValidStartPoint(int r, int c) {
// if (isValidCell(r, c)) {
// return board[r][c] == SHAPE_CHAR;
// } else {
// return false;
// }
// }
//
// public void getNumOfShapes() {
// Scanner sc = new Scanner(System.in);
// int numCase = Integer.parseInt(sc.nextLine());
// for (int i = 0; i < numCase; i++) {
// String [] rC = sc.nextLine().split("\\s");
// int N = Integer.parseInt(rC[0]);
// int M = Integer.parseInt(rC[1]);
// String curBoard = sc.nextLine();
// fillCurBoard(curBoard, N, M);
//
// int res = 0;
//
// for (int r = 0; r < row; r++) {
// for (int c = 0; c < col; c++) {
// if (isValidStartPoint(r, c)) {
// res++;
// BFS(convertToCellNumber(r, c));
// }
// }
// }
// System.out.println(res);
// }
// sc.close();
// }
//
// private void fillCurBoard(String str, int r, int c) {
// String [] rows = str.trim().split("\\s");
//
// this.row = r;
// this.col = c;
// this.board = new int[r][c];
//
// for(int i = 0; i < r; i++) {
// for(int j = 0; j < c; j++) {
// char curC = rows[i].charAt(j);
// board[i][j] = curC;
// }
// }
// }
//
// int convertToCellNumber(int r, int c) {
// return col * r + c;
// }
//
// int[] convertToRowCol(int cell) {
// int[] res = new int[2];
// res[0] = (int) (cell / this.col);
// res[1] = cell % this.col;
// return res;
// }
//
// private void BFS(int cellNumber) {
// LinkedList<Integer> q = new LinkedList<>();
// q.addLast(cellNumber);
//
// while (!q.isEmpty()) {
// int curCell = q.pollFirst();
// int[] rowCol = convertToRowCol(curCell);
// int r = rowCol[0];
// int c = rowCol[1];
// //System.out.println(convertToCellNumber(r, c));
// board[r][c] = VISITED;
//
// for (int i = 0; i < 4; i++) {
// int nRow = r + rowDir[i];
// int nCol = c + colDir[i];
//
// if (isValidStartPoint(nRow, nCol)) {
// //System.out.println(convertToCellNumber(nRow, nCol));
// q.addLast(convertToCellNumber(nRow, nCol));
// board[nRow][nCol] = VISITED;
// }
// }
// }
// //System.out.println("BFS END");
// }
//
// }
