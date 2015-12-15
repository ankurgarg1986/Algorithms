package graphs;

import java.util.Arrays;
import java.util.Comparator;

class Subset {
	int parent;
	int rank;

	public Subset(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}
}

/**
 * 
 *  @author agarg
 *  Kruskal Algorithm which uses Union Find algorithm to find Minimum Spanning
 *  Tree in a undirected graph . Union Find is done using path compression 	and Rank to achieve 
 *  O(logV) complexity rather than normal O(V) complexity .
 *  
 *  Time Complexity of Kruskal Algorithm is O(ElogE) or O(ElogV) explained below
 *  Sorting of edges takes O(ELogE) time. After sorting, we iterate through all edges and 
 *  apply find-union algorithm. The find and union operations can take atmost O(LogV) time.
 *   So overall complexity is O(ELogE + ELogV) time. The value of E can be atmost V^2,
 *    so O(LogV) are O(LogE) same. Therefore, overall time complexity is O(ElogE) or O(ElogV)
 */
public class KruskalMST {

	private static Edge[] KruskalAlgo(Graph g) {

		Edge[] edges = g.edges;
		Arrays.sort(edges, new Comparator<Edge>() {

			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});
		int c = 0;
		int i = 0;
		Subset[] subsets = new Subset[g.V];
		for (i = 0; i < g.V; i++) {
			Subset subset = new Subset(i, 0);
			subsets[i] = subset;
		}
        Edge[] result = new Edge[g.V -1];
		for (i = 0; i < edges.length && c < g.V - 1; i++) {
			Edge edge = edges[i];
			int s = edge.src;
			int d = edge.dest;
			// Find if this edge makes graph cyclic
			int xroot = find(subsets, s);
			int yroot = find(subsets, d);
			if (xroot == yroot) {
				// discard this edge
				continue;
			}
			result[c] = edge;
			Union(xroot, yroot, subsets);
			c++;
		}
		return result;

	}

	private static void Union(int xroot, int yroot, Subset[] subsets) {

		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[xroot].parent = yroot;
			subsets[yroot].rank++;
		}

	}

	private static int find(Subset[] subsets, int s) {
		if (subsets[s].parent == s) {
			return s;
		}
		return find(subsets, subsets[s].parent);
	}

	public static void main(String[] args) {

		int V = 4;
		int E = 5;
		// Graph graph = new Graph(V,E);
		Edge e1 = new Edge(0, 1, 10);
		Edge e2 = new Edge(0, 2, 6);
		Edge e3 = new Edge(0, 3, 5);
		Edge e4 = new Edge(1, 3, 15);
		Edge e5 = new Edge(2, 3, 4);
		Edge[] edges = new Edge[E];
		edges[0] = e1;
		edges[1] = e2;
		edges[2] = e3;
		edges[3] = e4;
		edges[4] = e5;
		Graph g = new Graph(V, E, edges);
		Edge[] res = KruskalAlgo(g);
		for(int i=0;i<res.length;i++)
		{
			Edge e = res[i];
			System.out.println("Src ==> " + e.src + " Dest => " + e.dest + " Weight => " + e.weight );
		}
	}

}
