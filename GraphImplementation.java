import java.util.*;

public class GraphImplementation implements Graph {
	private int[][] list;
	private int vertices;

	public GraphImplementation(int vertices) {
		list = new int[vertices][vertices];
		this.vertices = vertices;
	}

	public void addEdge(int v1, int v2) throws Exception{
		if(v1 > vertices || v2 >= vertices || v1 < 0 || v2 < 0) {
			throw new Exception("Out of Bounds.");
		}
		list[v1][v2] = 1; //add a 1 in list;
	}


	public List<Integer> topologicalSort() {
		List<Integer> schedule = new ArrayList<Integer>();

		int[] sum = new int[vertices];


		//iterate through columns and rows
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < vertices; j++)
				sum[j] += list[i][j];
		}

		for(int count = 0; count < vertices; count++) {

			int n = findZero(sum); //***have to write findZero function; finding out at which index its 0
			if(n == -1) {
				System.out.println("Incorrect.");
			}

			schedule.add(n); // put in 
			sum[n] = -1;
			for(int i = 0; i < vertices; i++)
				sum[i] -= list[n][i];
		}

		return schedule;
	}

	public List<Integer> neighbors(int vertex) throws Exception{
		//Prints (to console) one ordering of vertices such that each directed edge (v1, v2) from vertex v1 to vertex v2, v1 comes before v2 in the ordering. If such an ordering is not possible (due to cycles, for example), this function must indicate so, though it may print a partial solution in so doing.

		if(vertex > vertices || vertex < 0)
			throw new Exception("Out of Bounds.");

		List<Integer> neighbors = new ArrayList<Integer>();
		for(int i = 0; i < vertices; i++) {
			if(list[vertex][i] == 1) {
				neighbors.add(i);
			}
		}

		return neighbors;

	}

	private int findZero(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0)
				return i;
		}
		return -1;
}
}

//time complexity: O(v^2 * |E| )
