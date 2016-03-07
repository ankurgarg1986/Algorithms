package graphs;

/***
 * 
 * @author agarg
 * http://www.geeksforgeeks.org/find-number-of-islands/
 * Using dfs to solve the problem
 */
public class Islands {

	
	private int countIslands(int[][] m) {
		int ans = 0;
		int r = m.length;
		int[][] visited = new int[r][r];
		int i,j;
		for(i=0;i<r;i++)
		{
			for(j=0;j<r;j++)
				 visited[i][j] = 0;
		}
		int[] dx = {1,1,1,0,0,-1,-1,-1};
		int[] dy = {1,0,-1,1,-1,1,0,-1};
		for(i=0;i<r;i++)
		{
			for(j=0;j<r;j++)
			{
				if(m[i][j]==1 && visited[i][j]!= 1)
				{
					dfs(i,j,visited,m,dx,dy);
					ans++;
				}
			}
		}
		return ans;
	}
	
	
	private void dfs(int i, int j, int[][] visited, int[][] m, int[] dx,int[] dy) {
	   int k = 0;
	   visited[i][j] = 1;
	   int x,y;
	   for(k=0;k<8;k++)
	   {
		   x= i+dx[k];
		   y = j+dy[k];
		   if(canVisit(x,y,visited))
		   {
			   if(visited[x][y] !=1)
			   {
				   if(m[x][y] ==1)
				   {
					   dfs(x,y,visited,m,dx,dy); 
				   }
				   else
					   visited[x][y] = 1;
				 
			   }
		   }
		   
	   }
	  
	}


	private boolean canVisit(int x, int y, int[][] visited) {
		int m = visited.length;
		return (x >= 0 && y>=0 && x<m && y<m);
	}


	public static void main (String[] args) 
	    {
	        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
	                                 {0, 1, 0, 0, 0},
	                                 {1, 0, 0, 1, 1},
	                                 {0, 0, 0, 0, 0},
	                                 {1, 0, 0, 0, 0}
	                                };
	        Islands I = new Islands();
	        System.out.println("Number of islands is: "+ I.countIslands(M));
	    }

	
}
