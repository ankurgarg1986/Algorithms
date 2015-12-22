package graphs;

/**
 * 
 * @author agarg Algorithm for PrimMST. 
 * This is based on adjacency matrix representation of directed graph.
 * Running complexity for this program is O(V^2).
 * For more details please visit 
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
 */
public class PrimMST {

	public static int max = 9999;

	public static void main(String[] args) {
		/*
		 * Let us create the following graph 2 3 (0)--(1)--(2) | / \ | 6| 8/ \5
		 * |7 | / \ | (3)-------(4) 9
		 */
		PrimMST t = new PrimMST();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 },
				{ 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 }, { 0, 5, 7, 9, 0 }, };

		// Print the solution
		t.primMST(graph);
	}

	private void primMST(int[][] graph) {
		int V = graph.length;
		int[] keys = new int[V];
		Boolean[] mstSet = new Boolean[V];
		
		int i = 0;
		for (i = 0; i < V; i++)
		{
			keys[i] = max;
			mstSet[i] = false;
		}
		keys[0] = 0;
		int[] sol = new int[V];
		int[] parent = new int[V];
		parent[0] = -1;
		for (i = 0; i < V ; i++) {
			int u = findMinKeyIndex(keys, mstSet);
			mstSet[u] = true;
			int j = 0;
			for(j=0;j<graph.length;j++)
			{
				if(graph[u][j] != 0 && mstSet[j] == false && graph[u][j] < keys[j] )
				{
                       keys[j] = graph[u][j];
                       parent[j] = u;      
				}
			}
		}
		
		printMST(parent , V , graph);

	}

	private void printMST(int[] parent, int v, int[][] graph) {
		System.out.println("Edge   Weight");
        for (int i = 1; i < v; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
		
	}

	private int findMinKeyIndex(int[] keys, Boolean[] mstSet) {
		int i = 0;
		int minmIndex = -1;
		int minm  = max;
		for (i = 0; i < keys.length; i++) {
			if (mstSet[i] == false) {
				if(keys[i] < minm)
				{
					minmIndex = i;
					minm = keys[i];
				}
				
			}
		}
		return minmIndex;
	}

}
