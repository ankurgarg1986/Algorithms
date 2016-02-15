package backtracking;

public class MColouring {

	public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0},
        };
        int m = 3; // Number of colors
        System.out.println(MColouring.canGraphBeColoured(graph,m));
	}

	private static boolean canGraphBeColoured(int[][] graph, int m) {
		int V = graph.length;
		int[] colors = new int[V];//To maintain colors for different vertices
		return graphColors(graph,V,m,colors,0);
		
	}

	private static boolean graphColors(int[][] graph, int V, int m, int[] colors,int x) {
	    if(x==V)
	    {
	    	//all the vertices have been colored
	    	return true;
	    }
	    for(int c=1;c<=m;c++)
	    {
	    	//Can color chosen can be used to color vertice x
	    	if(canColor(graph,colors,c,x))
	    	{
	    		colors[x] = c;
	    		//Check whether With this premise can we color the other vertices
	    		if(graphColors(graph,V,m,colors,x+1))
	    		{
	    			return true;
	    		}
	    		colors[x] = 0;//backtrack
	    	}
	    }
	    
		return false;
	}

	private static boolean canColor(int[][] graph, int[] colors, int c, int v) {
		for(int i=0;i<graph.length;i++)
		{
			if(graph[v][i]==1  && (colors[i]==c))
			{
				return false; //cant be colored
			}
		}
		return true;
	}

}
