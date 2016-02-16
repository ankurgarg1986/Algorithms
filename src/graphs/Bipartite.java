package graphs;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * Algorithm to check whether a given graph is Bipartite or Not.
 * Algorithms using both BFS and DFS are provided here.
 * Adjacency Matrix representation of graph is used here . 
 * The complexity of the algorithms presented are O(V^2) where
 * V is no of Vertices. Alternatively , one can use 
 * m-Coloring backtracking solution to solve this problem (which is NP Complete) 
 * but that is of exponential complexity so should not be used here.
 * @author agarg
 *
 */
public class Bipartite {

	public static void main(String[] args) {
		
		int G[][] = {{0, 1, 0, 1, 0},
	            {1, 0, 1, 0, 0},
	            {0, 1, 0, 1, 0},
	            {0, 0, 1, 0, 1},
	            {1, 0, 0, 1, 0}
	        };
	        Bipartite b = new Bipartite();
	        if (b.isBipartiteBFS(G, 0))
	           System.out.println("Yes");
	        else
	           System.out.println("No");
	}

	/**
	 * 
	 * BFS based implementation is provided to check whether a 
	 * graph is bipartite or not.
	 * @param g
	 * @param v
	 * @return
	 */
	private boolean isBipartiteBFS(int[][] g, int v) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		int len = g.length;
		int[] colors = new int[len];
		int i;
		for(i=0;i<len;i++)
			colors[i] = -1;
		colors[v] = 1;
		while(!q.isEmpty())
		{
			int top = q.poll();
			
			for(i=0;i<len;i++)
			{
				if(g[top][i] ==1)
				{
					if(colors[i] == -1)
					{
						q.add(i);
						//color not set 
						colors[i] = 1-colors[top];
					}
					else{
						if(colors[i] == colors[top])
						{
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

}
