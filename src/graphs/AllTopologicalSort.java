package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class AdjGraph
{
	int v;
	LinkedList<Integer> adj[];
	int[] indegree;
	
	@SuppressWarnings("unchecked")
	public AdjGraph(int v)
	{
		this.v = v;
	    this.indegree = new int[v];
		adj = new LinkedList[v];
	    for(int i=0;i<v;i++)
	    {
	    	adj[i] = new LinkedList<Integer>();
	    }   
	}
	
	public void addEdge(int u,int v)
	{
	   adj[u].add(v);
	   indegree[v]++;
	}

	
	public void alltopologicalSort() {
	    boolean[] visited = new boolean[v];
	    LinkedList<Integer> res = new LinkedList<Integer>();
	    int i=0;
	    for(i=0;i<v;i++)
	    	 visited[i] = false;
	   allTopologicalSortUtil(visited,res);
		
	}

	private void allTopologicalSortUtil(boolean[] visited,
			LinkedList<Integer> res) {
		
		int i=0;
		int j;
		boolean flag = false;
		for(i=0;i<v;i++)
		{
			if(indegree[i]==0 && !visited[i])
			{
				visited[i] = true;
				//remove this edge
				Iterator<Integer> itr = adj[i].listIterator();
				while(itr.hasNext())
				{
				     j = itr.next();
				    indegree[j]--;  	
				}
				res.add(i);
				allTopologicalSortUtil(visited,res);
				visited[i] = false;
				itr = adj[i].listIterator();
				res.removeLast();
				while(itr.hasNext())
				{
				     j = itr.next();
				     indegree[j]++;  	
				}
				flag = true;
				
			}
		}
		
		if(!flag)
		{
			ListIterator<Integer> it = res.listIterator();
			while(it.hasNext())
			{
				System.out.print(it.next());
			}
			System.out.println("");
		}
	}
}

public class AllTopologicalSort {

	public static void main(String[] args) {
		AdjGraph g = new AdjGraph(6);
	    g.addEdge(5, 2);
	    g.addEdge(5, 0);
	    g.addEdge(4, 0);
	    g.addEdge(4, 1);
	    g.addEdge(2, 3);
	    g.addEdge(3, 1);
	 
	    System.out.println("All Topological sorts\n");
	 
	    g.alltopologicalSort();
	 
     
	}

}
