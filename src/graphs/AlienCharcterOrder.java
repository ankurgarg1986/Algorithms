package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author agarg
 * http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * This solution also covers Checking for Cycle in the graph for deciding the
 * validity of Input.
 * 
 * PS-> Cycle detection alone is not sufficient to decide the validity .
 * In addition to it , one should also check the count of Indegree and Outdegree of all vertex
 * Valid input should only have one vertex with indegree 0 and One vertex with Outdegree 0
 * This has not been covered here but can be easily computed while creating graph from the input.
 *
 */
public class AlienCharcterOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"aba", "bba", "bbb"};
	    printOrder(words, 3, 2);
	    
	}

	private static void compareAndAddEdge(String s1, String s2, G4 g) {
	  int i,j;
	  for(i=0,j=0;i<s1.length() && j<s2.length();i++,j++)
	  {
		  if(s1.charAt(i) != s2.charAt(j))
		  {
			  g.addDirectedEdge(s1.charAt(i)-'a', s2.charAt(j)-'a');
			  break;
		  }
	  }
		
	}
	
	private static void printOrder(String[] words, int n, int w) {
		int i = 0,j;
		G4 g = new G4(w);
		for(i=0;i<n-1;i++)
		{
			//for(j=i+1;j<n;j++)
			//{
				compareAndAddEdge(words[i],words[i+1],g);
			//}
		}
		if(checkforCycle(g))
		{
			System.out.println("Not valid input ");
			return;
		}
		Stack<Integer> s = new Stack<Integer>();
		topologicalSort(g,s);
		System.out.println("Ordering is => ");
		while(!s.isEmpty())
		{
			int p= s.pop(); 
			char c = (char) ((char)p + 'a');
			System.out.print(c + " ");
		}
	}

	/**
	 * Method to check for presence of Cycle in the created
	 * Graph . If there is a cycle in the graph, input is invalid
	 * @param g
	 * @return
	 */
	private static boolean checkforCycle(G4 g) {
		boolean[] vis = new boolean[g.V];
		boolean[] recStack = new boolean[g.V];
		int i;
		for(i=0;i<g.V;i++)
		{
			vis[i] = false;
			recStack[i] = false;
		}
		for(i=0;i<g.V;i++)
		{
			if(!vis[i])
			{
				if(cycleUtil(g,recStack,vis,i))
					return true;
			}
		}
		return false;
	}

	private static boolean cycleUtil(G4 g, boolean[] recStack, boolean[] vis, int u) {
		if(!vis[u])
		{
			recStack[u] = true;
			vis[u] = true;
			LinkedList<Integer> ll = g.adjList[u];
			Iterator<Integer> it = ll.listIterator();
			while(it.hasNext())
			{
				int j = it.next();
				if(recStack[j])
				{
					return true;
				}
				if(!vis[j])
				{
					if(cycleUtil(g,recStack,vis,j))
						return true;
				}
			}
		}
		
		recStack[u] = false;
		return false;
		
	}

	private static void topologicalSort(G4 g,Stack<Integer> s) {
		int v = g.V;
		boolean[] vis = new boolean[v];
		int i;
		for(i=0;i<v;i++)
		{
			vis[i] = false;
		}
		
		for(i=0;i<v;i++)
		{
			if(!vis[i])
			{
				topologicalSortUtil(g,vis,i,s);
			}
		}
		
	}

	private static void topologicalSortUtil(G4 g, boolean[] vis, int u,Stack<Integer> s) {
		vis[u] = true;
		int x;
		LinkedList<Integer> adj = g.adjList[u];
	    Iterator<Integer> it = adj.listIterator();
	    while(it.hasNext())
	    {
	    	x = it.next();
	    	if(!vis[x])
	    	{
	    		topologicalSortUtil(g,vis,x,s);
	    	}
	    }
		s.push(u);
	}

	

}
