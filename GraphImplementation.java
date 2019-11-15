public class GraphImplementation {
	private LinkedList[] list;
	private LinkedList[] schedule;

	public GraphImplementation(int vertices) {
		list = new LinkedList[vertices];
		for(int i = 0; i < vertices; i++) {
			list[i] = new LinkedList(); //make new linked list for each vertix
		}
	}

	void add_edge(int v1, int v2) {
		if(v1 > list.length || v2 >= list.length) {
			System.out.println("Out of bounds.");
		}
		if(v1 < 0 || v2 < 0) {
			System.out.println("Out of bounds.");
		}
		list[v1].add(v2);
	}



	List<Integer> topologicalSort() {
		ArrayList<Integer> schedule = new ArrayList<Integer>;

		int[] sum = new int[vertices];

		//iterate through columns and rows
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < vertices; j++)
				sum[i] += matrix[i][j];
		}

		sum[n] = -1;

		for(int count = 0; count < vertices; count++) {
			schedule.add(n); // put in 

			int n = findZero(sum); //***have to write findZero function; finding out at which index its 0

			for(int i = 0; i < vertices; i++)
				sum[i] -= matrix[n][i];
		}

		return schedule;
	}

	List<Integer> neighbors(int vertex) {
		//Prints (to console) one ordering of vertices such that each directed edge (v1, v2) from vertex v1 to vertex v2, v1 comes before v2 in the ordering. If such an ordering is not possible (due to cycles, for example), this function must indicate so, though it may print a partial solution in so doing.

		List<Integer> neighbors = new ArrayList<Integer>();
		for(i = 0; i < vertex; i++) {
			neighbors.add_edge(i);
		}

		return neighbors;



	}
}
