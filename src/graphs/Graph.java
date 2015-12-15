package graphs;

public class Graph
{
	int V,E;
	Edge[] edges;
	
	public Graph(int V,int E,Edge[] edge)
	{
		this.V = V;
		this.E = E;
		this.edges = edge;
	}
	
}