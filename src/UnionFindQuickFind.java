
public class UnionFindQuickFind implements UnionFindI {

	private int[] array;

	public UnionFindQuickFind(int N) {
		array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = i;
		}
	}

	@Override
	public boolean connected(int p, int q) {
		return array[p] == array[q];
	}

	@Override
	public void union(int p, int q) {
		int pId = array[p];
		int qId = array[q];

		for (int i = 0; i < array.length; i++) {
			if (array[i] == pId) {
				array[i] = qId;
			}
		}
	}

	public static void main(String[] args) {
		int[][] data = { { 4, 3 }, { 3, 8 }, { 6, 5 }, { 9, 4 }, { 2, 1 }, { 8, 9 }, { 5, 0 }, { 7, 2 }, { 6, 1 },
				{ 1, 0 }, { 6, 7 } };

		UnionFindQuickFind uf = new UnionFindQuickFind(data.length);
		int count = -1;
		while (++count < data.length) {
			int p = data[count][0];
			int q = data[count][1];;
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				
				System.out.println(p + " " + q);
			}
		}
	}

}
