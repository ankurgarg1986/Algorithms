package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class G2 {
	final int MAX = 9999;
	int V;// no of Vertices
	LinkedList<Node>[] adj; // adj List

	public G2(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			LinkedList<Node> ll  = new LinkedList<Node>();
			adj[i] = ll;
		}
	}

	public void addEdge(int u, int v, int w) {
		adj[u].add(new Node(u, v, w));
	}

	private static void topologySort(G2 g, boolean[] vis, Stack<Integer> st,
			int u) {

		if (!vis[u]) {
			vis[u] = true;
			LinkedList<Node> adjList = g.adj[u];
			Iterator<Node> it = adjList.listIterator();
			while (it.hasNext()) {
				Node n = it.next();
				if (!vis[n.v]) {
					topologySort(g, vis, st, n.v);
				}
			}
			st.push(u);
		}

	}

	public int[] ShortestPath(G2 g, int s) {

		int v = g.V;
		Stack<Integer> st = new Stack<Integer>();
		boolean[] vis = new boolean[v];
		int i;
		for (i = 0; i < v; i++)
			vis[i] = false;
		for (i = 0; i < v; i++) {
			if (!vis[i])
				topologySort(g, vis, st, i);
		}
		int[] ans = new int[v];
		for (i = 0; i < v; i++)
			ans[i] = MAX;
		ans[s] = 0;
		while (!st.isEmpty()) {
			int t = st.pop();
			if (ans[t] != MAX) {
				LinkedList<Node> n = g.adj[t];
				Iterator<Node> it = n.listIterator();
				while (it.hasNext()) {
					Node n1 = it.next();
					ans[n1.v] = Math.min(ans[n1.v], ans[t] + n1.w);
				}
			}
		}
		return ans;
	}
}

class Node {

	int u;// start
	int v;// dest
	int w;// weight of Edge

	public Node(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

}

public class ShortestPathDAG {

	public static void main(String[] args) {

		G2 g = new G2(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);
		System.out
				.println("Shortest Path from Vertex 1 to all other sources are :=> ");
		int[] res = g.ShortestPath(g, 1);
		for(int i=0;i<g.V;i++)
		{
			System.out.print( res[i] + " ");
		}

	}

}
