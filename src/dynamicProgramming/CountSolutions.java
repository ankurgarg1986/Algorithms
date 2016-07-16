package dynamicProgramming;

public class CountSolutions {

	public static void main(String[] args) {
		
		int[] coeff = {2,2,2};
		int rhs = 4;
		int n = coeff.length;
		System.out.println(countSolRecursive(coeff,0,n-1,rhs));
		System.out.println(countSolDynamic(coeff,n,rhs));
	}

	private static int countSolDynamic(int[] coeff, int n, int rhs) {
		int[] dp = new int[rhs+1];
		dp[0] = 1;
		int i,j;
		for(i=0;i<n;i++)
		{
			for(j=coeff[i];j<=rhs;j++)
			{
				dp[j] += dp[j-coeff[i]];
			}
		}
		return dp[rhs];
		
	}

	private static int countSolRecursive(int[] coeff, int s, int e, int rhs) {
		
		if(rhs == 0) return 1;
		int res = 0;
		for(int i=s;i<=e;i++)
		{
			if(rhs >= coeff[i])
				res = res + countSolRecursive(coeff,i,e,rhs-coeff[i]);
		}
		return res;
	}

}
