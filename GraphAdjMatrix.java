public class GraphAdjMatrix implements Graph {
	
	private int vertices;
	private int[][] graph;
	
	public GraphAdjMatrix(int numVertices) {
		vertices = numVertices;
		graph = new int[vertices][vertices];
	}
	
	public void addEdge(int src, int tar) {
		graph[src][tar] = 1;
	}
	
	public int[] neighbors(int vertex) {
		int[] temp = new int[vertices]; 
		int index = 0;
		
		for(int i = 0; i < graph.length; i++) {
			if (graph[vertex][i] == 1) {
					temp[index] = i;
					index++;
			}
		}
		return temp;
	}
	
	public void topologicalSort() {
		
		int[] temp = new int[vertices];
		boolean[] visited = new boolean[vertices];
		int index = 0;
		int count;
		int min;
		
		for(int i = 0; i < graph.length; i++) { //column
			count = 0;
			for(int j = 0; j < graph.length; j++) { //row
				if (graph[j][i] == 1) {
					count++;
				}
			}
			temp[i] = count;
		}
		
		for (int k = 0; k < temp.length; k++) {
			min = Integer.MAX_VALUE;
			index = 0;
			for (int m = 0; m < temp.length; m++) {
				if (temp[m] < min && visited[m] != true) {
					min = temp[m];
					index = m;
				}
			}
			System.out.println(temp[index]);
		}
		
	}
}
