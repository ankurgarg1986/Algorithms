package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class G {
	int V;
	LinkedList<Integer> adj[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public G(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	public void addEdge(int s, int e) {
		adj[s].add(e);
	}

	private void topologicalSortUtil(int d, boolean[] visited, Stack<Integer> s) {

		visited[d] = true;
		LinkedList<Integer> ll = adj[d];
		Iterator<Integer> it = ll.listIterator();
		while (it.hasNext()) {
			int x = it.next();
			if (!visited[x]) {
				topologicalSortUtil(x, visited, s);
			}
		}
		s.push(d);
	}

	public void topologicalSort() {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		int i = 0;
		for (i = 0; i < V; i++)
			visited[i] = false;
		for (i = 0; i < V; i++) {
			if (!visited[i]) {
				 topologicalSortUtil(i, visited, s);
			}
		}
		PrintSort(s);
	}

	private void PrintSort(Stack<Integer> s) {
		// Iterator<Integer> it = s.iterator();
		while (!s.isEmpty()) {
			System.out.println(s.pop() + " ");
		}

	}

}

public class TopologicalSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G g = new G(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological "
				+ "sort of the given graph");
		g.topologicalSort();
	}

}
