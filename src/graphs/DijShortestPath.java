package graphs;

/**
 * 
 * @author agarg
 * Dijiktra Algorithm for computing shortest path from Source to all Vertices in an undirected Graph.
 * This is similar to Prim's Algorithm for computing Minimum Spanning Tree.
 * This algo can't be used if there are negative weight edges in the graph.
 * Complexity of this algorithm is O(V^2).
 * 
 * For negative Weighted edges , Bellman Ford should be used .
 */
public class DijShortestPath {

	static int maxm = 9999;

	private static void dijkstraShortestPath(int[][] graph, int s) {
		int[] keySet = new int[graph.length];
		int[] parent = new int[graph.length];
		parent[s] = -1; //source has no parent 
		int i = 0;
		int V = graph.length;
		for (i = 0; i < V; i++) {
			if (i == s)
				keySet[i] = 0;
			else
				keySet[i] = maxm;
		}
		boolean[] spSet = new boolean[V];
		for(i=0;i<V;i++)
			spSet[i] = false;
		for(i=0;i<V-1;i++)
		{
			int u = findMinKeyVertex(spSet,keySet);
			spSet[u] = true;
			for(int j=0;j<V;j++)
			{
				if( graph[u][j]!= 0 &&  spSet[j] == false && (keySet[u] + graph[u][j] < keySet[j]))
				{
					keySet[j] = keySet[u] + graph[u][j];
					parent[j] = u;
				}
			}
			
		}
		
		printSolution(keySet,V,s);

	}

	private static void printSolution(int[] keySet, int v, int s) {
	     System.out.println("From Source => " + s); 
		 for(int i=0;i<v;i++)
	      {
	    	  System.out.println("To " + i + " Distance is = " + keySet[i]);
	      }
		 
		
	}

	private static int findMinKeyVertex(boolean[] spSet, int[] keySet) {
		int i = 0;
		int minm = maxm;
		int minmIndex = -1;
		for(i=0;i<keySet.length;i++)
		{
			if(spSet[i] == false && keySet[i] < minm)
			{
				minm = keySet[i];
				minmIndex = i;
			}
		}
		return minmIndex;
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		dijkstraShortestPath(graph, 0);

	}

}
