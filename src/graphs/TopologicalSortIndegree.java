package graphs;

public class TopologicalSortIndegree {

	
	public static void main(String[] args) {
		
       AdjGraph g  = new AdjGraph(6);
       g.addEdge(5, 2);
	   g.addEdge(5, 0);
	   g.addEdge(4, 0);
	   g.addEdge(4, 1);
	   g.addEdge(2, 3);
	   g.addEdge(3, 1);
	   //g.topologicalSortIndegree();
	}

}
