package graphs;

import java.util.Iterator;
import java.util.LinkedList;


class G3
{
	int v;
	LinkedList<Node1>[] adj;
	
	public G3(int V)
	{
		this.v = V;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i] = new LinkedList<Node1>();
		}
	}
	
	public void addEdge(int u,int v)
	{
		Node1 n = new Node1(u,v);
		adj[u].add(n);
	}
	
	public boolean isCyclic()
	{
		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];
		int i;
		for( i=0;i<v;i++)
		{
			visited[i] = false;
			recStack[i] = false;
		}
		
		for(i=0;i<v;i++)
		{
			if(!visited[i])
			{
				boolean res =  isCyclicUtil(i,visited,recStack);
				if(res) return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

	   if(!visited[i])
	   {
          visited[i] = true;
          recStack[i] = true;
          Iterator<Node1> it = adj[i].listIterator();
          while(it.hasNext())
          {
        	  int j = it.next().v;
        	  if(!visited[j])
        	  {
        		 if(isCyclicUtil(j,visited,recStack)) return true;
        	  }
        	  else if(recStack[j])
        	  {
        		  return true;
        	  }
          }
	   }
	   recStack[i] = false;
       return false;
		
	}
}

class Node1
{
	int u;
	int v;
	public Node1(int u,int v)
	{
		this.u = u;
		this.v = v;
	}
}
public class CycleDirected {

	public static void main(String[] args) {
		G3 g = new G3(6);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        if(g.isCyclic())
        {
        	System.out.println(" Cycle Detected");
        }
        else
        	System.out.println("No Cycle present");

	}

}
