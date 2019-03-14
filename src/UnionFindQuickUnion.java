import java.util.Collections;
import java.util.TreeMap;

public class UnionFindQuickUnion implements UnionFindI{

	private int[] array;
	int connectedComp;

	public UnionFindQuickUnion(int N) {
		array = new int [N];
		connectedComp = N;
		
		for(int i = 0; i < N; i++) {
			array[i] = i;
		}
	}
	
	@Override
	public boolean connected(int p, int q) {
		return rootRecur(p) ==  rootRecur (q);
	}

	@Override
	public void union(int p, int q) {
		int pRoot = rootRecur (p);
		int qRoot = rootRecur (q);
		
		if(pRoot != qRoot) {
			array[pRoot] = qRoot;
			connectedComp--;
		}
	}
	
	public int numOfConnectedComponent() {
		return connectedComp;
	}
	
	public void printArray() {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private int root (int node) {
		while(array[node] != node) {
			// path compression
			array[node] = array[array[node]];
			
			node = array[node];
		}
		
		return node;
	}
	
	private int rootRecur (int node) {
		if(node == array[node]) {
			return node;
		}
		
		int curNode = node;
		int root = rootRecur(array[node]);
		
		array[curNode] = root;
		
		return root;
	}
	
	public static void main(String[] args) {
		int[][] data = { { 4, 3 }, { 3, 8 }, { 6, 5 }, { 9, 4 }, { 2, 1 }, { 8, 9 }, { 5, 0 }, { 7, 2 }, { 6, 1 },
				{ 1, 0 }, { 6, 7 } };
		
		UnionFindQuickUnion uf = new UnionFindQuickUnion(data.length);
		int count = -1;
		while (++count < data.length) {
			int p = data[count][0];
			int q = data[count][1];;
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				
				System.out.println("# connected component = " + uf.connectedComp);
			} else {
				System.out.println(p + " " + q + " was already connected");
			}
		}
		
		System.out.println("# connected component = " + uf.connectedComp);
		uf.printArray();
		
		System.out.println("tanvir".hashCode());
		
		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(3, "fahim");
		tm.put(2, "Tanvir");
		System.out.println(tm.lastKey());
	}
	
	
}
