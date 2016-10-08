package dynamicProgramming;

public class KPalindrome {

	public static void main(String[] args) {
		
		    String str = "abc";
		    int k = 1;
		    int n = str.length();
		    System.out.println(isKPalindrome(str,k,0,n-1));
		    System.out.println(isKPalindromeDynamic(str,k));
		
	}

	private static boolean isKPalindromeDynamic(String str, int k) {
		if(str.length() <= 1) return true;
		int n = str.length();
		int[][] dp = new int[n+1][n+1];
		dp[0][0] = 0;
		int i,j;
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(str.charAt(i)==str.charAt(n-j))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = 
				}
				
			}
		}
		
		if(dp[n][n] >= 0) return true;
		return false;
	}

	private static boolean isKPalindrome(String str, int k,int i,int j) {
		if(k<0) return false;
		if(i>=j) return true;
		if(str.charAt(i) == str.charAt(j))
		{
			return isKPalindrome(str,k,i+1,j-1);
		}
		else
		{
			return isKPalindrome(str,k-1,i+1,j) || isKPalindrome(str,k-2,i+1,j-1) || isKPalindrome(str,k-1,i,j-1);
		}
		
	}

}
