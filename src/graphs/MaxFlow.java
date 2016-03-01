package graphs;

import java.util.LinkedList;
import java.util.Queue;

// Java program for implementation of Ford Fulkerson algorithm
 
class MaxFlow
{
    //static final int V = 6; //Number of vertices in graph
	
    private int fordFulkerson(int[][] graph, int s, int d) {
	    int V = graph.length;
    	int[][] rc = new int[V][V];
    	int i,j;
    	int u,v;
    	for(i=0;i<V;i++)
    	{
    		for(j=0;j<V;j++)
    			rc[i][j] = graph[i][j];
    	}
    	int[] parent  = new int[V];
    	int max_flow = 0;
        while(bfs(rc,s,d,parent))  
        {
        	//there exists a path between source and destination
        	int flow  = 99999;
        	for(v=d;v!=s;v=parent[v])
        	{
        		u = parent[v];
        		flow = Math.min(rc[u][v], flow);
        	}
        	for(v=d;v!=s;v=parent[v])
        	{
        		u = parent[v];
        		rc[u][v] = rc[u][v] - flow;
        		rc[v][u] = rc[v][u] + flow;
        	}
            max_flow += flow;	
        }
    	
		return max_flow;
	}
    
    /**
     * 
     * @param rc
     * @param s
     * @param d
     * @param parent
     * @return
     */
    private boolean bfs(int[][] rc, int s, int d, int[] parent) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		parent[s] = -1;
		int v = rc.length;
		int[] visited  = new int[v];
		visited[s] = 1;
		while(!q.isEmpty())
		{
			int u = q.poll();
			for(int i=0;i<v;i++)
			{
				if(rc[u][i] > 0 && visited[i] == 0)
				{
					q.add(i);
					parent[i] = u;
					visited[i] =1;
				}
			}
		}
    	return (visited[d]== 1);
	}
    
    
	// Driver program to test above functions
    public static void main (String[] args) throws java.lang.Exception
    {
        // Let us create a graph shown in the above example
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                                     {0, 0, 10, 12, 0, 0},
                                     {0, 4, 0, 0, 14, 0},
                                     {0, 0, 9, 0, 0, 20},
                                     {0, 0, 0, 7, 0, 4},
                                     {0, 0, 0, 0, 0, 0}
                                   };
        MaxFlow m = new MaxFlow();
 
        System.out.println("The maximum possible flow is " +
                           m.fordFulkerson(graph, 0, 5));
 
    }


	
}