package treebo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class G3 {
	int V;
	LinkedList<Integer> adj[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public G3(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	public void addEdge(int s, int e) {
		adj[s].add(e);
	}

	public void removeEdge(int s) {
		adj[s].remove(0);// It contains only 1 element so removing it , Ideally
							// one should handle gracefully
		// but due to lack of time taking advantage of constraint
		// adj[s] = new LinkedList();
	}
}

public class TestClass2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int m = Integer.parseInt(line);// no of nodes
		line = br.readLine();
		G3 g = new G3(m);
		// String[] nodes = line.split(" ");
		StringTokenizer nodes = new StringTokenizer(line);
		int i = 0;
		// for( i=0;i<nodes.length;i++){
		while (nodes.hasMoreTokens()) {
			int n1 = Integer.parseInt(nodes.nextToken());
			// int n2 = Integer.parseInt(nodes[i+1]);
			g.addEdge(i, n1 - 1);
			i++;

		}
		line = br.readLine();
		int k = Integer.parseInt(line);
		for (i = 0; i < k; i++) {
			// queries
			line = br.readLine();
			String[] q = line.split(" ");
			if (q[0].equals("1")) {
				bfs(g, Integer.parseInt(q[1]) - 1);
			} else {
				g.removeEdge(Integer.parseInt(q[1]) - 1);
			}
		}
	}

	private static void bfs(G3 g, int s) {
		try {
			boolean[] vis = new boolean[g.V];
			int i;
			for (i = 0; i < g.V; i++)
				vis[i] = false;
			// vis[s] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			LinkedList<Integer> adj1;
			q.add(s);
			while (!q.isEmpty()) {
				s = q.poll();
				if (vis[s]) {
					System.out.println("LOOP");
					return;
				} else {
					vis[s] = true;
					adj1 = g.adj[s];
					if (adj1 != null) {
						Iterator<Integer> it = adj1.listIterator();
						while (it.hasNext()) {
							int n3 = it.next();
							q.add(n3);
						}
					}
				}
			}
			System.out.println(s + 1);
			return;
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

}
