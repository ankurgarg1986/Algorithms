package dynamicProgramming;

public class MaxFood {

	private static int maxFood(int[][] a, int m, int n,int x,int y1,int y2) {
		int ans = 0;
		if(x < 0 || x>= m || y1<0 || y1>=n || y2<0 || y2>=n) return 0;//out of bound
		//dest reached
		if(x == m-1 && y1 == 0 && y2== n-1)
			return a[x][y1] + a[x][y2];
		int sum = 0;
		if(x==m-1)
			return 0; //important condition
		if(y1==y2)
		  sum = a[x][y1];
		else
			sum  = a[x][y1] + a[x][y2];
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1+1,y2+1));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1+1,y2-1));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1+1,y2));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1-1,y2+1));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1-1,y2-1));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1-1,y2));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1,y2+1));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1,y2-1));
		ans = Math.max(ans , sum + maxFood(a,m,n,x+1,y1,y2));
		
		return ans;
	}
	// checks whether a given input is valid or not
	static boolean isValid(int x, int y1, int y2,int R ,int C)
	{
	    return (x >= 0 && x < R && y1 >=0 &&
	            y1 < C && y2 >=0 && y2 < C);
	}
	 
	// Driver function to collect max value
	static int getMaxUtil(int[][] arr, int[][][] mem, int x, int y1, int y2,int R ,int C,int C1)
	{
	    /*---------- BASE CASES -----------*/
	    // if P1 or P2 is at an invalid cell
	    if (!isValid(x, y1, y2,R,C)) return -9999;
	 
	    // if both traversals reach their destinations
	    if (x == R-1 && y1 == 0 && y2 == C-1)
	           return arr[x][y1] + arr[x][y2];
	 
	    // If both traversals are at last row but not at their destination
	    if (x == R-1) return -9999;
	 
	    // If subproblem is already solved
	    if (mem[x][y1][y2] != -1) return mem[x][y1][y2];
	 
	    // Initialize answer for this subproblem
	    int ans = -9999;
	 
	    // this variable is used to store gain of current cell(s)
	    int temp = (y1 == y2)? arr[x][y1]: arr[x][y1] + arr[x][y2];
	 
	    /* Recur for all possible cases, then store and return the
	       one with max value */
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1, y2-1,R,C,C1));
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1, y2+1,R,C,C1));
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1, y2,R,C,C1));
	 
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1-1, y2,R,C,C1));
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1-1, y2-1,R,C,C1));
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1-1, y2+1,R,C,C1));
	 
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1+1, y2,R,C,C1));
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1+1, y2-1,R,C,C1));
	    ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1+1, y2+1,R,C,C1));
	 
	    return (mem[x][y1][y2] = ans);
	}
	 
	// This is mainly a wrapper over recursive function getMaxUtil().
	// This function creates a table for memoization and calls
	// getMaxUtil()
	static int geMaxCollection(int[][] arr)
	{
	    // Create a memoization table and initialize all entries as -1
	    int R = arr.length;
	    int C = arr[0].length;
		int[][][] mem = new int[R][C][C];
	    int i,j,k;
	    for(i=0;i<R;i++)
	    {
	    	for(j=0;j<C;j++)
	    	{
	    		for(k=0;k<C;k++)
	    			mem[i][j][k] = -1;
	    	}
	    }
	 
	    // Calculation maximum value using memoization based function
	    // getMaxUtil()
	    return getMaxUtil(arr, mem, 0, 0, C-1,R,C,C);
	}
	 
	public static void main(String[] args) {
		int[][] arr = {{3},
                {5},
                {1},
                {1},
                {10},
               };
		int m  = arr.length;
		int n = arr[0].length;
		System.out.println("Max Food Collected is  " + maxFood(arr,m,n,0,0,n-1));
		System.out.println(geMaxCollection(arr));

	}
	

}
