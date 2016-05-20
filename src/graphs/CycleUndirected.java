package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Code for detecting cycle in undirected Graphs
 * http://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 * @author agarg
 *
 */
class G4 {

	int V;
	LinkedList<Integer>[] adjList;

	public G4(int v) {
		adjList = new LinkedList[v];
		this.V = v;
		for (int i = 0; i < v; i++)
			adjList[i] = new LinkedList<Integer>();
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
	}

	public boolean isCyclic() {
		boolean[] vis = new boolean[V];
		int i = 0;
		for (i = 0; i < V; i++)
			vis[i] = false;
		for (i = 0; i < V; i++) {
			if (!vis[i]) {
				if (isCyclicUtil(i, vis, -1)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isCyclicUtil(int i, boolean[] vis, int parent) {

		vis[i] = true;
		Iterator<Integer> it = adjList[i].listIterator();
		while (it.hasNext()) {
			int j = it.next();
			if (!vis[j]) {
				if(isCyclicUtil(j,vis,i)) return true;
			} else if (j != parent) {
				return true;// cycle detected
			}
		}
		return false;
	}

}

public class CycleUndirected {

	public static void main(String[] args) {

		G4 g = new G4(6);
		g.addEdge(1, 0);
		g.addEdge(1, 2);
		//g.addEdge(2, 0);
		//g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 0);
		if (g.isCyclic()) {
			System.out.println("Graph contains cycle ");
		} else
			System.out.println("Graph doesnt contain cycle");

	}

}
