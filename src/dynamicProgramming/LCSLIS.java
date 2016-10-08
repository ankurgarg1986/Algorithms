package dynamicProgramming;

public class LCSLIS {

	public static void main(String[] args) {
		int a1[] = {5, 3, 8, 9, 10, 2, 1};
	    int a2[] = {3, 4, 9, 1};
	 
	    int n = a1.length;
	    int m = a2.length;
	 
	 System.out.println(LCIS(a1,n,a2,m));
	        

	}

	private static int LCIS(int[] a1, int n, int[] a2, int m) {
		int ans = 0;
		int i,j;
		int[] lcs = new int[m];
		for(i=0;i<n;i++)
		{
			int curr = 0 ;
			for(j=0;j<m;j++)
			{
				if(a1[i] == a2[j])
				{
					if(lcs[j] < curr+1 )
					{
						lcs[j] = curr + 1;
					}
				}
				if(a1[i] > a2[j])
				{
					if(lcs[j] > curr)
						curr = lcs[j];
				}
			}
		}
		return ans;
	}

}
