package dynamicProgramming;

public class PatternMatching {

	public static void   main(String[] args) {
		
		String str = "baaabab";
		//String pat = "a*ab";
		 String pat = "baaa?ab";
//		 char pattern[] = "ba*ab";
//		 char pattern[] = "a*ab";
//		 char pattern[] = "a*****ab";
//		 char pattern[] = "*a*****ab";
//		 char pattern[] = "ba*ab****";
//		 char pattern[] = "****";
//		 char pattern[] = "*";
//		 char pattern[] = "aa?ab";
//		 char pattern[] = "b*b";
//		 char pattern[] = "a*a";
//		 char pattern[] = "baaabab";
//		 char pattern[] = "?baaabab";
//		 char pattern[] = "*baaaba*";
       System.out.println(checkMatch(str,pat));
	}

	private static int checkMatch(String str, String pat) {
		int m = str.length();
		int n = pat.length();
		int[][] dp = new int[m+1][n+1];
		int i,j;
		dp[0][0] = 1;
		for(i=1;i<=m;i++)
		{
			dp[i][0] = 0;
		}
		for(j=1;j<=n;j++)
		{
			if(pat.charAt(j-1) == '*')
				dp[0][j] = 1;
			else 
			{
				while(j<=n){
					dp[0][j] = 0;
				    j++;
				}
				
			}
		}
		
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(pat.charAt(j-1) == '*')
				{
					dp[i][j] = dp[i][j-1] | dp[i-1][j];
				}
				else if(pat.charAt(j-1) == '?')
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
				  if(pat.charAt(j-1) == str.charAt(i-1))
				  {
					  dp[i][j] = dp[i-1][j-1];
				  }
				  else
				  {
					  dp[i][j] = 0;
				  }
				}
			}
		}
		return dp[m][n];
	}

}
