package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *  
 * Code to compute Transitive Closure of a graph
 * This is O(n^2) complexity using DFS
 * @author agarg
 *
 */
public class TransitiveClosureDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        G4 g = new G4(5);
        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(2, 0);
        g.addDirectedEdge(2, 3);
        g.addDirectedEdge(3, 0);
        g.addDirectedEdge(3, 4);
        System.out.println("Transitive Closure is => ");
        findTransitiveClosure(g);
	}

	private static void findTransitiveClosure(G4 g) {
		int[][] tc = new int[5][5];
        int i,j;
        for(i=0;i<5;i++)
        {
        	for(j=0;j<5;j++)
        	{
        		tc[i][j] = 0;
        	}
        }
       for(i=0;i<5;i++)
       {
    	   dfs(g,tc,i,i);
       }
       for(i=0;i<5;i++)
       {
    	   for(j=0;j<5;j++)
    	   {
    		   System.out.print(tc[i][j] + " ");
    	   }
    	   System.out.println();
       }
	}

	private static void dfs(G4 g, int[][] tc,int u,int v) {
		if(tc[u][v] == 0)
		{
			tc[u][v] = 1;
			LinkedList<Integer> ll = g.adjList[v];
			Iterator<Integer> it = ll.listIterator();
			while(it.hasNext())
			{
				int k = it.next();
				dfs(g,tc,u,k);
			}
		}
		
	}

}
