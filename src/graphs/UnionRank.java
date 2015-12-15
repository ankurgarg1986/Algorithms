package graphs;


//class Graph
//{
//	int V;
//	int E;
//	Edge[] edges;
//	public Graph(int V,int E, Edge edges[])
//	{
//		this.V = V;
//		this.E = E;
//		this.edges = edges;
//	}
//	
//	
//	public int isCycle(Graph g) {
//		Subset[] subsets = new Subset[V];
//		int i = 0;
//		for(i=0;i<V;i++)
//		{
//			subsets[i] = new Subset();
//			subsets[i].parent = i;
//			subsets[i].rank = 0;
//		}
//		for(i=0;i<E;i++)
//		{
//			Edge e = g.edges[i];
//			int xroot =  find(subsets,e.src);
//			int yroot =  find(subsets,e.dest);
//			if(xroot == yroot) return 1;
//			
//			union(subsets,xroot,yroot);
//		}
//		return 0;
//	}
//
//	private void union(Subset[] subsets, int xroot, int yroot) {
//		if(subsets[xroot].rank < subsets[yroot].rank)
//			subsets[xroot].parent = yroot;
//		else if(subsets[xroot].rank > subsets[yroot].rank)
//			subsets[yroot].parent = xroot;
//		else 
//		{
//			subsets[yroot].parent = xroot;
//			subsets[xroot].rank++;
//		}
//	}
//
//	private int find(Subset[] subsets, int src) {
//		if(subsets[src].parent == src)
//		{
//			return src;
//		}
//		return find(subsets,subsets[src].parent);
//	}
//}
//
//class Edge
//{
//	int src;
//	int dest;
//	public Edge(int s , int d)
//	{
//		this.src = s;
//		this.dest = d;
//	}
//}

public class UnionRank {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
		int v = 3;
		int e = 3;
		Edge e1 = new Edge(0,1);
		Edge e2 = new Edge(1,2);
		Edge e3 = new Edge(0,2);
		Edge[] edges = new Edge[v];
		edges[0] = e1;
		edges[1] = e2;
		edges[2] = e3;
        //Graph g = new Graph(v,e,edges);
     //   System.out.println(g.isCycle(g));
	}

}

