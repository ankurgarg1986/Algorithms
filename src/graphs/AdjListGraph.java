package graphs;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;


class MinHeapNode
{
	int  V;
	int key;
	
	public MinHeapNode(int V, int key)
	{
		this.key = key;
		this.V = V;
	}
}
public class AdjListGraph {
	
	int V;
	static int maxm = Integer.MAX_VALUE;
	LinkedList<WeightedEdge> adj[];
	
	AdjListGraph(int V)
	{
		this.V = V;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			 adj[i] = new LinkedList<WeightedEdge>();
		}
	}
	
	public  void addEdge(Edge e)
	{
	    	int s  = e.src;
	    	adj[s].add(new WeightedEdge(e.dest,e.weight));
	}
	
    
	private static void primMST(AdjListGraph g) {
		
		PriorityQueue<MinHeapNode> pq = new PriorityQueue<MinHeapNode>(10 ,  new Comparator<MinHeapNode>() {

			@Override
			public int compare(MinHeapNode n1, MinHeapNode n2) {
			    
				return n1.key - n2.key;
			}
			
		});
		
		int i = 0;
		MinHeapNode node1 = new MinHeapNode(0,0);
		pq.add(node1);
		for(i=1;i<g.V;i++)
		{
		    MinHeapNode node = new MinHeapNode(i,maxm);
		    pq.add(node);
		}
		while(!pq.isEmpty())
		{
		    MinHeapNode e = pq.poll();
		    int v = e.V;
		    LinkedList<WeightedEdge> list =  g.adj[v];
		    Iterator<WeightedEdge> it = list.listIterator();
		    while(it.hasNext())
		    {
		    	WeightedEdge w = it.next();
		    	int dest = w.dest;
		    	int weight = w.weight;
		    	MinHeapNode nodeFound = FindWeightOfElement(pq,dest);
		    	if(nodeFound.key > weight)
		    	{
		    		//update the weight
		    		nodeFound.key = weight;
		    		
		    	}
		    }
		    
		}
		
		
	}
	
	

	private static MinHeapNode FindWeightOfElement(PriorityQueue<MinHeapNode> pq, int dest) {
		Iterator<MinHeapNode> it = pq.iterator();
		while(it.hasNext())
		{
			MinHeapNode node = it.next();
			if(node.V == dest)
			{
				return node;
			}
		}
		return null;
		
	}

	public static void main(String[] args)
	{
		AdjListGraph g = new AdjListGraph(5);
		Edge e1 = new Edge(0,1,4);
		Edge e2 = new Edge(0,7,8);
		Edge e3 = new Edge(1, 2, 8);
	    Edge e4 = new Edge(1, 7, 11);
	    Edge e5 = new Edge(2, 3, 7);
	    Edge e6 = new Edge(2, 8, 2);
	    Edge e7 = new Edge(2, 5, 4);
	    Edge e8 = new Edge(3, 4, 9);
	    Edge e9 = new Edge(3, 5, 14);
	    Edge e10 = new Edge(4, 5, 10);
	    Edge e11 = new Edge(5, 6, 2);
	    Edge e12 = new Edge(6, 7, 1);
	    Edge e13 = new Edge(6, 8, 6);
	    Edge e14 = new Edge(7, 8, 7);
	    g.addEdge(e1);
	    g.addEdge(e2);
	    g.addEdge(e3);
	    g.addEdge(e4);
	    g.addEdge(e5);
	    g.addEdge(e6);
	    g.addEdge(e7);
	    g.addEdge(e8);
	    g.addEdge(e9);
	    g.addEdge(e10);
	    g.addEdge(e11);
	    g.addEdge(e12);
	    g.addEdge(e13);
	    g.addEdge(e14);
		primMST(g);
	}

}
