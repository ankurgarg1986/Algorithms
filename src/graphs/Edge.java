package graphs;


public class Edge {

	int src;
	int dest;
	int weight;
	
	public Edge(int s, int d,int weight) {
		this.src = s;
		this.dest = d;
		this.weight = weight;
	}
	
	public Edge(int s, int d) {
		this.src = s;
		this.dest = d;
	}

//	@Override
//	public int compare(Edge e1, Edge e2) {
//		// TODO Auto-generated method stub
//		return e1.weight - e2.weight;
//	}

//	@Override
//	public int compareTo(Edge e1) {
//	   return this.weight - e1.weight;
//	}

}
