import java.util.*;

public class GraphAlgorithms {

	public static void main(String[] args) {
		GraphAdjList graph = new GraphAdjList();

		graph.connectedComponent();

		for(int i : graph.componentMemCount) {
			System.out.println(i);
		}
		
		
		
		int res = 0;

		if (graph.componentMemCount.size() < 2) {
			System.out.println(res);
			return;
		}

		int curNumOfElements = graph.componentMemCount.get(0) + graph.componentMemCount.get(1);
		res = graph.componentMemCount.get(0) * graph.componentMemCount.get(1);

		for (int i = 2; i < graph.componentMemCount.size(); i++) {
			res += curNumOfElements * graph.componentMemCount.get(i);
			curNumOfElements += graph.componentMemCount.get(i);
		}

		System.out.println(res);

	}

}

class GraphAdjList {
	public int numOfNodes;
	public int numOfEdges;
	public boolean isUndirected;
	HashMap<Integer, GraphVertex> vertices;

	public ArrayList<Integer> componentMemCount;
	public int curMemCount = 1;

	public GraphAdjList() {
		this(false);
	}
	
	public GraphAdjList(boolean undirected) {
		
		this.vertices = new HashMap<>();

		for (int i = 0; i < this.numOfNodes; i++) {
			this.vertices.put(i, new GraphVertex(i));
		}
		
		readInput();
	}

	private void readInput() {
		Scanner sc = new Scanner(System.in);

		this.numOfNodes = sc.nextInt();
		this.numOfEdges = sc.nextInt();	

		for (int i = 0; i < this.numOfEdges; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			vertices.get(x).neighbour.add(vertices.get(y));
			vertices.get(y).neighbour.add(vertices.get(x));

		}

		sc.close();
	}

	public int connectedComponent() {
		this.componentMemCount = new ArrayList<>();
		int count = 0;

		for (HashMap.Entry<Integer, GraphVertex> pair : this.vertices.entrySet()) {
			GraphVertex gv = pair.getValue();

			if (gv.visited == false) {
				connectedComponent(gv);
				count++;
				this.componentMemCount.add(this.curMemCount);
				this.curMemCount = 1;
			}
		}
		return count;
	}

	private void connectedComponent(GraphVertex gv) {
		gv.visited = true;

		for (GraphVertex curGv : gv.neighbour) {			
			if (curGv.visited == false) {
				this.curMemCount++;
				connectedComponent(curGv);				
			}
		}
	}
	
	
}

class GraphVertex {
	int nodeId;
	String nodeName;
	int parentId;

	boolean visited;
	int componentId;

	ArrayList<GraphVertex> neighbour;

	public GraphVertex(int id) {
		this.nodeId = id;
		neighbour = new ArrayList<>();
	}
}

//class GraphAdjMatrix {
//	public int numOfNodes;
//	public int numOfEdges;
//	public int[][] graph;
//	public int[] whichComponent;
//	public boolean[] visited;
//	public int curMemCount = 1;
//	public ArrayList<Integer> componentMemCount;
//
//	public GraphAdjMatrix() {
//		readInput();
//	}
//
//	public int connectedComponent() {
//		this.componentMemCount = new ArrayList<>();
//		int count = 0;
//
//		for (int i = 0; i < this.numOfNodes; i++) {
//			if (this.visited[i] == false) {
//				connectedComponent(i);
//				count++;
//				this.componentMemCount.add(this.curMemCount);
//				this.curMemCount = 1;
//			}
//		}
//		return count;
//	}
//
//	private void connectedComponent(int node) {
//		this.visited[node] = true;
//
//		for (int i = 0; i < this.numOfNodes; i++) {
//			if (this.graph[node][i] == 1 && this.visited[i] == false) {
//				connectedComponent(i);
//				this.curMemCount++;
//			}
//		}
//	}
//
//	private void readInput() {
//		Scanner sc = new Scanner(System.in);
//
//		this.numOfNodes = sc.nextInt();
//		this.numOfEdges = sc.nextInt();
//
//		this.graph = new int[this.numOfNodes][this.numOfNodes];
//		this.whichComponent = new int[this.numOfNodes];
//		this.visited = new boolean[this.numOfNodes];
//
//		for (int i = 0; i < this.numOfEdges; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//
//			this.graph[x][y] = 1;
//			this.graph[y][x] = 1;
//		}
//
//		sc.close();
//	}
//}

/*
 * 13 13 0 1 0 2 0 5 0 6 3 4 3 5 4 5 4 6 7 8 9 10 9 11 9 12 11 12
 * 
 * 13 12 0 1 0 2 0 5 0 6 3 4 3 5 4 5 4 6 9 10 9 11 9 12 11 12
 * 
 * 
 */
